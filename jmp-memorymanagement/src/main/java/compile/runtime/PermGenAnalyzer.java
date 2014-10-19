package compile.runtime;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;

public class PermGenAnalyzer {

	private static final Logger LOG = Logger.getLogger(PermGenAnalyzer.class);
	private static final String CLASS_POSTFIX = ".class";
	
	public static void analyze(final int count){
		ClassBuilder.setToolPath();
		List<String> classNames = new ArrayList<String>(); 
		Set<Class<?>> classes = new HashSet<Class<?>>();
		List<Class<?>> cleanClasses = new ArrayList<Class<?>>();
		int index = 0;
		
		if (index == ClassBuilder.getClassCounter()) {
			while(true){
				while(index < count) {
					final String className = randName();
					ClassBuilder.buildClass(className);
					classNames.add(className);
					index++;
				}
				for(String className : classNames) {
					Class<?> clazz = ClassBuilder.loadClass(className);
					classes.add(clazz);
					cleanClasses.add(clazz);
				}
				for(Class<?> cls : cleanClasses) {
					cleanDirectory(cls);
				}
				cleanClasses.clear();
				classNames.clear();
				index = 0;
			}
		}

		//ClassBuilder.resetToolPath();
	}
	
	public static void analyze(){
		try {
		JarEntryClassLoader cls = new JarEntryClassLoader("xml-person-bind.jar");
    	Set<Class<?>> classes = new HashSet<Class<?>>();
    	for(;;){
    		cls = new JarEntryClassLoader("xml-person-bind.jar");
        	Class<?> clazz1 = cls.loadClass("com.jmpClassloadin.xml.bind.Person");
        	classes.add(clazz1);
    	}
		} catch(Exception e) {
			LOG.error(e.getMessage());
		}
	}
	
	private static void cleanDirectory(Class<?> clazz) {
		URL classURL = clazz.getResource(clazz.getSimpleName() + CLASS_POSTFIX);
		boolean isDelete = new File(classURL.getPath().substring(1).replace("/", System.getProperty("file.separator"))).delete();
	}

	private static String randName() {
		Double index = 0D;
		String str = "C";
		for (;str.length() <= 16;) {
			index = Math.floor(Math.random() * 50);
			str += "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz".charAt(index.intValue());
		}
		return str;
	}

}
