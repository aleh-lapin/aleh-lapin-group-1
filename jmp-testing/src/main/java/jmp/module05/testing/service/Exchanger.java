package jmp.module05.testing.service;

import java.util.HashMap;
import java.util.Map;
import jmp.module05.testing.utils.SchemaLoader;
import jmp.module05.testing.utils.Utils;
import jmp.module05.testing.utils.XmlProcessor;

public class Exchanger {
	
	private final Map<String, Double> courses = new HashMap<String, Double>();
	private final String baseCurr;
	private final String refference;
	private final com.jmpClassloadin.xml.bind.exchanger.ExchangerDocument document;
	
	public Exchanger(){
		SchemaLoader schemaLoader = new SchemaLoader();
		schemaLoader.addSchema("/Exchanger.xsd");
		XmlProcessor processor = new XmlProcessor(schemaLoader);
		document = 
				(com.jmpClassloadin.xml.bind.exchanger.ExchangerDocument)processor.parse(
						Utils.readDocument(Utils.getFilePath(getClass(), "exchanger.xml"))).changeType(com.jmpClassloadin.xml.bind.exchanger.ExchangerDocument.type);
		com.jmpClassloadin.xml.bind.exchanger.ExchangerType exchanger = document.getExchanger();
		baseCurr = exchanger.getBASICCURRENCY().toString();
		refference = exchanger.getBANKREF();
		for(com.jmpClassloadin.xml.bind.currency.Currency currency : exchanger.getCourseArray()) {
			courses.put(currency.getCurr().toString(), currency.getBigDecimalValue().doubleValue());
		}
		courses.put(baseCurr, 1D);
	}

	public Double getCourse(String type) {
		return courses.get(type);
	}

	public String getBaseCurr() {
		return baseCurr;
	}

	public String getRefference() {
		return refference;
	}

	public com.jmpClassloadin.xml.bind.exchanger.ExchangerDocument getDocument() {
		return document;
	}
		
}
