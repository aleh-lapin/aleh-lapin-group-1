package compile.runtime;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class HeapAnalyzer {

	private static final Logger LOG = Logger.getLogger(StackFrameAnalyzer.class);
	private static JarEntryClassLoader cls;
	private static Class<?> clazz;

	static {
		try {
			cls = new JarEntryClassLoader("xml-person-bind.jar");
			clazz = cls.loadClass("com.jmpClassloadin.xml.bind.Person");
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

	private HeapAnalyzer(){

	}
	
	public static void analyze(){
		try {
	    	List<Object> objects = new ArrayList<Object>();
	    	for(;;){
	        	objects.add(clazz.newInstance());
	    	}
		} catch(Exception e) {
			LOG.error(e.getMessage());
		}
	}

}
