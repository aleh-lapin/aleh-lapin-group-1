package jmp.module01.classloading;

import java.io.IOException;
import java.util.Scanner;
import org.apache.log4j.Logger;
import jmp.module01.classloading.classloader.JarEntryClassLoader;

public class App 
{
	private static final Logger LOG = Logger.getLogger(App.class);

	private static final String CONSOLE_MESSAGE = " Please, enter jar file name.";

	public static void main( String[] args )
	{	
		LOG.info(CONSOLE_MESSAGE);
		Scanner scanner = new Scanner(System.in);
		String readString = scanner.nextLine();
		while(readString !=null )
		{
			LOG.info(readString);
			if(readString.equals(""))
				LOG.info(CONSOLE_MESSAGE);
			if(scanner.hasNextLine()) {
				readString = scanner.nextLine();
				try {
					JarEntryClassLoader loader = new JarEntryClassLoader(readString);
					Class<?> clazz = loader.loadClass("com.jmpClassloadin.xml.bind.Person");
					Object person = clazz.newInstance();
					LOG.info(" Loaded class " + person);
				} catch (IOException e) {
					fatal(e.getLocalizedMessage());
				} catch (ClassNotFoundException e) {
					fatal(e.getLocalizedMessage());
				} catch (InstantiationException e) {
					fatal(e.getLocalizedMessage());
				} catch (IllegalAccessException e) {
					fatal(e.getLocalizedMessage());
				}
			} else {
				readString = null;
			}
		}
		if (scanner != null) {
			scanner.close();
		}
	}

	private static void fatal(String s) {
		LOG.error(s);
		System.exit(1);
	}

}
