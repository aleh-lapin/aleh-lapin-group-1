package jmp.module14.model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class UnitAdapter extends XmlAdapter<Element, Unit>  {

	private JAXBContext ctx;
	
	private DocumentBuilder docBuilder;
	
	private ClassLoader ctxLoader;
	
	public UnitAdapter() {
		ctxLoader = Thread.currentThread().getContextClassLoader();
	}
	
	public UnitAdapter(JAXBContext ctx) {
		this();
		this.ctx = ctx;
	}
	
	protected JAXBContext getJaxbContext(Class<?> type) {
		if (type != null && ctx == null) {
			try {
				ctx = JAXBContext.newInstance(type);
			} catch (JAXBException e) {
				ctx = null;
			}
		}
		return ctx;
	}
	
	protected DocumentBuilder getDocumentBuilder(){
		if (docBuilder == null) {
			try {
				docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				docBuilder = null;
			}
		}
		return docBuilder;
	}
		
	@Override
	public Element marshal(Unit v) throws Exception {
		
		final QName fullName = new QName(v.getName());
		final Object value = v.getValue();
		final Class<?> type = value.getClass();
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JAXBElement jaxbEl = new JAXBElement(fullName, type, value);
		Document root = getDocumentBuilder().newDocument();
		
		Marshaller marshaller = getJaxbContext(type).createMarshaller();
		marshaller.marshal(jaxbEl, root);
		Element element = root.getDocumentElement();

		element.setAttribute("type", type.getName());
		element.setAttribute("identity", v.getId().toString());
		
		return element;
	}

	@Override
	public Unit unmarshal(Element v) throws Exception {
		
		if (v == null) {
			return null;
		}
		Class<?> type = ctxLoader.loadClass(v.getAttribute("type"));
		Source source = new DOMSource(v);
		Unmarshaller unmarshaller = getJaxbContext(type).createUnmarshaller();
		
		JAXBElement<?> jaxbElement = unmarshaller.unmarshal(source, type);
		
		Unit unit = new Unit();
		unit.setName(v.getLocalName());
		unit.setValue(jaxbElement.getValue());
		
		return unit;
	}

	
	
}
