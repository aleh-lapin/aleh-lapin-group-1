package jmp.module04.multithreading.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Node;

public abstract class Utils {

	public static String getFilePath(Class<?> clazz, String resource) {
		URL url = clazz.getResource("/" + resource);
		String path = url.getFile() != null && url.getFile().startsWith("/") ? url.getFile().substring(1) : null;
		return path;
	}
	
	public static synchronized Node readDocument(String path) {
		Node node = null;
		TransformerFactory transFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transFactory.newTransformer();
			DOMResult domResult = new DOMResult();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.transform(new StreamSource(new BufferedReader(new FileReader(path))), domResult);
			node = domResult.getNode();
		} catch (TransformerConfigurationException e) {
			node = null;
		} catch(TransformerException e) {
			node = null;
		} catch (FileNotFoundException e) {
			node = null;
		}
		return node;
	}
		
	public static synchronized Node wrieDocument(Node node, String path) {
		TransformerFactory transFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transFactory.newTransformer();
			DOMResult domResult = new DOMResult();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.transform(new DOMSource(node), new StreamResult(new BufferedWriter(new FileWriter(path))));
			node = domResult.getNode();
		} catch (TransformerConfigurationException e) {
			node = null;
		} catch(TransformerException e) {
			node = null;
		} catch (IOException e) {
			node = null;
		}
		return node;
	}

}
