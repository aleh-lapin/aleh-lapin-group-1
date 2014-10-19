package compile.runtime;

import org.apache.log4j.Logger;

public class StackFrameAnalyzer {

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

	private StackFrameAnalyzer(){

	}

	private static Object produceObject() throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}

	private static void method01(Object object) {
		long i1 = 0L, i2 = 0L, i3 = 0L, i4 = 0L, i5 = 0L;
		try {
			object = produceObject();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		method01(object);
	}

	private static int method02(Object object) {
		try {
			object = produceObject();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return 256;
	}

	private static Object method03(Object object) {
		try {
			object = produceObject();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return object;
	}

	public static void analyze(int i) {
		try {
			while(true) {
				switch(i) {
				case 1:
					method01(produceObject());
					break;
				case 2:
					int result02 = method02(produceObject());
					break;
				case 3:
					Object result03 = method03(produceObject());
					break;
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

}
