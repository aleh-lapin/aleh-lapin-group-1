package com.jmpClassloadin.xml.bind;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

public abstract class XmlEntity {
	
	protected abstract XmlObject initConfig(String xml) throws XmlException;

	protected static String retrieveXmlInstance(InputStream stream) {
		String replacedProperties;
		try {
			replacedProperties = populateContent(stream);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return replacedProperties;
	}


	private static String populateContent(InputStream stream)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		byte[] buff = new byte[1024];
		int num = -1;
		while ((num = stream.read(buff)) > -1) {
			sb.append(new String(buff, 0, num));
		}
		return sb.toString();
	}
	
	public abstract String toString();

}
