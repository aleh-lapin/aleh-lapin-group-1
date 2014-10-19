package compile.runtime;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;
import org.apache.log4j.Logger;

public class ClassBuilder {

	private static final Logger LOG = Logger.getLogger(ClassBuilder.class);
	
	private static final String DEFAULT_CLASS_NAME_PREFIX = "auto.classes.TestCase";
	private static String SOURCE_TEMPLATE;
	private static JavaCompiler COMPILER;
	private static boolean SUCCESS = false;
	private static long CLASS_COUNTER = 0;
	private static final String DEFAULT_CLASS_PATH = System.getProperty("java.home");
	private static URLClassLoader cls;
	private static final List<URL> urls = new ArrayList<URL>();

	static {
		StringWriter writer = new StringWriter();
		PrintWriter out = new PrintWriter(writer);
		String classPath[] = System.getProperty("java.class.path").split(System.getProperty("path.separator"));
		for(String path : classPath) {
			try {
				urls.add(new URL("file", "", path));
			} catch (MalformedURLException e) {
				LOG.error("Incorrect format URL: " + e);
			}
		}
		cls = URLClassLoader.newInstance(urls.toArray(new URL[0]));
		out.println("package auto.classes;");
		out.println("import org.apache.log4j.Logger;");
		out.println("import java.net.URL;");
		out.println("import java.net.URLClassLoader;");
		out.println("import java.util.List;");
		out.println("import java.util.ArrayList;");
		out.println("import java.util.Arrays;");
		out.println("import compile.runtime.ClassBuilder.Display;");
		out.println("public class TestCase{0} implements Display {");
		out.println(" 	public static final Logger LOG = Logger.getLogger(TestCase{0}.class);");
		out.println(" 	public static final Class<? extends Display> self = loadClass(\"auto.classes.TestCase{0}\");");
		out.println("@SuppressWarnings(\"unchecked\")");
		out.println("private static Class<? extends Display> loadClass(String className) {");
		out.println("	Class<? extends Display> clazz = null;");
		out.println("	try {");
		out.println("		String classPath[] = System.getProperty(\"java.class.path\").split(\";\");");
		out.println("		List<URL> urls = new ArrayList<URL>();");
		out.println("		for(String path : classPath) {");
		out.println("			urls.add(new URL(\"file\", \"\", path));");
		out.println("		}");
		out.println("		URLClassLoader cls = URLClassLoader.newInstance(urls.toArray(new URL[0]));");
		out.println("		clazz = (Class<? extends Display>)cls.loadClass(className);");
		out.println("	} catch (Exception e) {");
		out.println("		LOG.error(e);");
		out.println("	}");
		out.println("	return clazz;");
		out.println("}");
		out.println("  	public void display(Logger log) throws IllegalAccessException, InstantiationException {");
		out.println("		displays.add(getClass());");
		//out.println("    	log.info(\"This is a new generated class with name \" + getClass().getSimpleName());");    
		out.println("  	}");
		out.println("}");
		out.close();
		SOURCE_TEMPLATE = writer.toString();
	}

	private ClassBuilder(){

	}

	private static String createSource(Object... args) {
		String result = SOURCE_TEMPLATE;
		if (args != null && args.length > 0) {
			for(int i = 0; i < args.length; i++)
				result = result.replaceAll("[{]" + i + "[}]", "" + args[i]);
		}
		return result;
	}

	public static void setToolPath() {
		String env = System.getenv("JAVA_HOME");		
		System.setProperty("java.home", env);
		ClassLoader cs = ToolProvider.getSystemToolClassLoader();
		if (cs == null) {
			throw new RuntimeException("Cannot load system tool extension.");
		} else {
			COMPILER = ToolProvider.getSystemJavaCompiler();
		}
	}

	public static void resetToolPath(){
		System.setProperty("java.home", DEFAULT_CLASS_PATH);
	}

	public static void buildClass(String prefix) {

		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		String compileOpts[] = {"-d", "target/classes"};
		Iterable<String> opts = Arrays.asList(compileOpts);
		JavaFileObject file = new JavaSource(DEFAULT_CLASS_NAME_PREFIX + prefix, createSource(prefix));
		StandardJavaFileManager stdFileManager = COMPILER.getStandardFileManager(null, Locale.getDefault(), null);
		Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(file);

		CompilationTask task = COMPILER.getTask(null, stdFileManager, diagnostics, opts, null, compilationUnits);
		SUCCESS = task.call();
		CLASS_COUNTER = (SUCCESS) ? ++CLASS_COUNTER : CLASS_COUNTER;
		for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
			LOG.error(diagnostic.getCode());
			LOG.error(diagnostic.getKind());
			LOG.error(diagnostic.getPosition());
			LOG.error(diagnostic.getStartPosition());
			LOG.error(diagnostic.getEndPosition());
			LOG.error(diagnostic.getSource());
			LOG.error(diagnostic.getMessage(null));
		}

	}

	public static Class<?> loadClass(String prefix) {
		Object object = null;
		Class<?> clazz  = null;
		try {
			if (cls != null) {
				cls = new URLClassLoader(urls.toArray(new URL[0]));//URLClassLoader.newInstance(urls.toArray(new URL[0]));
				clazz = Class.forName(DEFAULT_CLASS_NAME_PREFIX + prefix, true, cls);
				//System.out.println(clazz.hashCode());
				object = clazz.newInstance();
				Method method = clazz.getDeclaredMethod("display", new Class[] { Logger.class });
				method.setAccessible(true);
				method.invoke(object, new Object[] { LOG });
			}
			//classURL = clazz.getResource(clazz.getSimpleName() + CLASS_POSTFIX);
			//boolean isDelete = new File(classURL.getPath().substring(1).replace("/", System.getProperty("file.separator"))).delete();

		} catch (ClassNotFoundException e) {
			LOG.error("Class not found: " + e);
		} catch (NoSuchMethodException e) {
			LOG.error("No such method: " + e);
		} catch (IllegalAccessException e) {
			LOG.error("Illegal access: " + e);
		} catch (InvocationTargetException e) {
			LOG.error("Invocation target: " + e.getTargetException());
		} catch (InstantiationException e) {
			LOG.error("Cannot instantiate target: " + e);
		} 
		return clazz;
	}



	private static class JavaSource extends SimpleJavaFileObject {
		final String code;

		JavaSource(String name, String code) {
			super(URI.create("string:///" + name.replaceAll("[.]","/") + Kind.SOURCE.extension),Kind.SOURCE);
			this.code = code;
		}

		@Override
		public CharSequence getCharContent(boolean ignoreEncodingErrors) {
			return code;
		}
	}

	public static interface Display {
		Set<Class<? extends Display>> displays = new HashSet<Class<? extends Display>>();
		void display(Logger log) throws IllegalAccessException, InstantiationException;
	}

	public static long getClassCounter() {
		return CLASS_COUNTER;
	}

}
