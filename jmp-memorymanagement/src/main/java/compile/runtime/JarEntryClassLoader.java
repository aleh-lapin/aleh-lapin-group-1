package compile.runtime;

import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import org.apache.log4j.Logger;

public class JarEntryClassLoader extends URLClassLoader {

private static final Logger LOG = Logger.getLogger(JarEntryClassLoader.class);
	
	private static final String NONE_URI = "NONE";
	
	private URL url;

	public JarEntryClassLoader(String jarName) throws IOException {
		super(new URL[] { getJarEntry(jarName) });
		this.url = getURLs()[0];
	}

	public JarEntryClassLoader(URL url, ClassLoader parent) {
		super(new URL[]{ url }, JarEntryClassLoader.class.getClassLoader());
	}

	public static URL getJarEntry(String jarName) throws IOException {		
		URL jarUrl = JarEntryClassLoader.class.getClassLoader().getResource(jarName);
		return jarUrl;
	}

	private JarFile getJarFile(URL jarUrl) throws IOException {
		URL localURL = (jarUrl == null) ? url : jarUrl;
		URL u = new URL("jar", "", localURL + "!/");
		JarURLConnection uc = (JarURLConnection)u.openConnection();
		JarFile jarFile = uc.getJarFile();
		return jarFile;
	}

	private void closeJarFile(JarFile jarFile) {
		if (jarFile != null) {
			try {
				jarFile.close();
			} catch (IOException e) {
				LOG.error(e);
			}		
		}
	}

	private boolean matches(String resourceName, String entryName, boolean isClass) {
		if (isClass) {
			int endIndex = entryName.lastIndexOf('.');
			final String canonicalName = entryName.substring(0, endIndex).replaceAll("/", ".");
			if (resourceName != null && canonicalName.equals(resourceName)) {
				return true;
			} 
		} else {
			if (resourceName != null && entryName.equals(resourceName)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Class findClass(final String name) throws ClassNotFoundException {
		SecurityManager sm = System.getSecurityManager();
		if (sm != null) {
			int i = name.lastIndexOf('.');
			if (i != -1) {
				sm.checkPackageDefinition(name.substring(0, i));
			}
		}
		Class result = findLoadedClass(name);
		if (result != null) {
			LOG.info("% Class " + name + " found in cache");
			return result;
		}
		URL currURL = url;
		CodeSource codeSource = null;
		byte[] bytes = null;
		JarFile jarFile = null;
		try {
			jarFile = getJarFile(null);
			Manifest mf = jarFile.getManifest();
			Attributes attr = mf.getMainAttributes();
			String attrVlue = attr.getValue(Attributes.Name.CLASS_PATH);
			String values[] = attrVlue.split(" ");
			
			String externalJars[] = new String[values.length + 1];
			externalJars[externalJars.length - 1] = NONE_URI;
			System.arraycopy(values, 0, externalJars, 0, values.length);
			
			Enumeration<JarEntry> entries = jarFile.entries();
			for (String url : externalJars) {
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (!entry.isDirectory() 
							&& entry.getName().endsWith(".class")) {
						if (matches(name, entry.getName(), true)) {
							URL u = new URL(currURL + "!/" + entry.getName());
							codeSource = getCodeSource(u);
							InputStream jarEntryStream = jarFile.getInputStream(entry);
							bytes = loadAsBytes(jarEntryStream, entry.getSize());
							LOG.info(" Jar entry " + entry.getName()
									+ " size " + entry.getSize());
							break;
						}
					}
				}
				if (codeSource != null && bytes != null) {
					break;
				} else {
					currURL = getJarEntry(url);
					jarFile = getJarFile(currURL);
					entries = jarFile.entries();
				}
			}
		} catch (Exception e) {

		} finally {
			closeJarFile(jarFile);
		}
		
		LOG.info("% Class " + name + codeSource != null && bytes != null ? " was found " : " was not found");
		if (codeSource == null && bytes == null) {
			return findSystemClass(name);
		}
		final CodeSource cs = codeSource;
		final byte[] classBytes = bytes;
		
		try {
			return (Class)
					AccessController.doPrivileged(new PrivilegedExceptionAction() {
						public Object run() throws Exception {
							return defineClass(name,
									classBytes, 0, classBytes.length, cs);
						}
					});
		} catch (ClassFormatError e) {
			throw new ClassNotFoundException(
					"Format of class file incorrect for class "
							+ name + ": " + e);
		} catch (PrivilegedActionException e) {
			throw new ClassNotFoundException(
					"Format of class file incorrect for class "
							+ name + ": " + e);
		}
	}
	
	@Override
	public InputStream getResourceAsStream(String name) {
		
		InputStream stream = super.getResourceAsStream(name);
		if (stream == null){
			URL currURL = url;
			JarFile jarFile = null;
			try {
				jarFile = getJarFile(null);
				Manifest mf = jarFile.getManifest();
				Attributes attr = mf.getMainAttributes();
				String attrVlue = attr.getValue(Attributes.Name.CLASS_PATH);
				String values[] = attrVlue.split(" ");
				String externalJars[] = new String[values.length + 1];
				externalJars[externalJars.length - 1] = NONE_URI;
				System.arraycopy(values, 0, externalJars, 0, values.length);
				Enumeration<JarEntry> entries = jarFile.entries();
				for (String url : externalJars) {
					while(entries.hasMoreElements()) {
						JarEntry entry = entries.nextElement();
						if (!entry.isDirectory()
								&& !entry.getName().endsWith(".class")) {
							if (matches(name, entry.getName(), false)) {
								stream = jarFile.getInputStream(entry);
								
								break;
							}
						}
					}
					if (stream != null) {
						break;
					} else {
						currURL = getJarEntry(url);
						jarFile = getJarFile(currURL);
						entries = jarFile.entries();
					}
				}
			} catch (Exception e) {
				LOG.error(e);
			} 
		}
	    return stream != null ? stream : null;
	}


	protected CodeSource getCodeSource(URL u) {
		Certificate[] cert = null;
		return new CodeSource(u, cert);
	}

	protected PermissionCollection getPermissions(CodeSource codesource) {
		PermissionCollection pc = new Permissions();
		pc.add(new RuntimePermission("createClassLoader"));
		pc.add(new RuntimePermission("exitVM"));
		return pc;
	}

	public static byte[] loadAsBytes(InputStream stream, long size)
			throws IOException {
		byte[] result = new byte[(int)size];

		try {
			stream.read(result, 0, result.length);
		} finally {
			try {
				stream.close();
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
		}
		return result;
	}

}
