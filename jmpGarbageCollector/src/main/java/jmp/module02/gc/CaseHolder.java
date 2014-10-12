package jmp.module02.gc;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.*;

public class CaseHolder {

	private static final String HEAP_SIZE = "heapSize";
	private static final String YOUNG_SIZE = "youngSize";
	private static final String PERM_SIZE = "PermSize";
	private static final String GC_TYPE = "gcType";
	
	private URL url;
	private URI uri;
	private Map<Integer, String> content = new HashMap<Integer, String>();

	public CaseHolder() throws URISyntaxException {
		this.url = getClass().getClassLoader().getResource(".");
		this.uri = url.toURI();
		obtainResources();
	}

	private void obtainResources() {
		final String separator = System.getProperty("file.separator");
		String rawPath = uri.getRawPath();
		String path = rawPath.substring(1, rawPath.length() - 1).replace("/", separator);
		File directory = new File(path);
		directory.list(new FilenameFilter(){
			private Pattern pattern = Pattern.compile("(\\w+(\\d+).properties)|(.+.jar)");
			public boolean accept(File file, String name){
				Matcher matcher = pattern.matcher(name);
				if (matcher.matches()) {
					if (matcher.group(1) != null) {
						content.put(Integer.parseInt(matcher.group(2)), name);
					} else if (matcher.group(3) != null) {
						content.put(0, file + separator + name);
					}
					return true;
				}
				return false;
			}
		});
	}

	public String getParameters(int index) throws MalformedURLException, IOException {
		if (index > 0) {
			StringBuilder parameters = new StringBuilder();
			String entry = content.get(index);
			Properties localProperties = new Properties();
			URI localURI = uri.resolve(entry);
			localProperties.load(localURI.toURL().openStream());
			parameters.append("java ");
			parameters.append(localProperties.getProperty(HEAP_SIZE)).append(" ");
			parameters.append(localProperties.getProperty(YOUNG_SIZE)).append(" ");
			parameters.append(localProperties.getProperty(PERM_SIZE)).append(" ");
			parameters.append(localProperties.getProperty(GC_TYPE)).append(" ");
			parameters.append("-jar " + content.get(0));
			return parameters.toString();
		} else {
			return "";
		}
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

}
