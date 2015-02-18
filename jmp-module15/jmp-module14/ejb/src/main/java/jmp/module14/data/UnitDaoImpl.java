package jmp.module14.data;

import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.SynchronousQueue;

import jmp.module14.model.Elements;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import jmp.module14.model.Repository;
import jmp.module14.model.Ticket;
import jmp.module14.model.Unit;
import jmp.module14.model.UnitAdapter;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;





import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class UnitDaoImpl<T> implements UnitDao<T> {

	private Repository repository;

	private Document document;

	private XPath xpath;

	private JAXBContext ctx;

	private Class<?>[] ctxClasses;

	private Queue<CacheItem> cache = new ConcurrentLinkedQueue<CacheItem>();

	public UnitDaoImpl(Class<?>[] classes){

		ctxClasses = new Class<?>[classes.length + 3];
		if (classes.length > 0) {
			ctxClasses[0] = Repository.class;
			ctxClasses[1] = UnitWrapper.class;
			ctxClasses[2] = Elements.class;
			System.arraycopy(classes, 0, ctxClasses, 3, classes.length);
		}
		try {
			this.repository = new Repository(); 
			this.repository.setRepositoryName(getClass().getSimpleName());
			this.ctx = JAXBContext.newInstance(ctxClasses);

			this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			this.xpath = XPathFactory.newInstance().newXPath();
		} catch (JAXBException e) {
			this.ctx = null;
		} catch (ParserConfigurationException e) {
			this.document = null;
		}
	}

	private Marshaller getMarshaller() throws JAXBException {
		UnitAdapter adapter = new UnitAdapter(getCtx());
		Marshaller marshaller = getCtx().createMarshaller();
		marshaller.setAdapter(adapter);
		return marshaller;
	}

	private Unmarshaller getUnmarshaller() throws JAXBException {
		UnitAdapter adapter = new UnitAdapter(getCtx());
		Unmarshaller unmarshaller = getCtx().createUnmarshaller();
		unmarshaller.setAdapter(adapter);
		return unmarshaller;
	}

	public boolean cacheItem() {

		Repository repClone = null;
		try {
			StringWriter writer = new StringWriter();
			Result result = new StreamResult(writer);
			getMarshaller().marshal(repository, result);
			InputSource source = new InputSource(new StringReader(writer.toString()));
			repClone = (Repository)getUnmarshaller().unmarshal(source);
		} catch (JAXBException e) {
			System.out.println(e);
			throw new RuntimeException(e.getMessage());
		}
		return cache.offer(new CacheItem(repClone, (Document)document.cloneNode(true)));
	}

	protected void restoreCacheItem() {
		CacheItem item = cache.poll();
		repository = item.getRepository();
		document = item.getDocument();
	}

	protected void clearCache() {
		synchronized (cache) {
			//cache.clear();
		}
	}

	public Document getDocument() {
		if (document == null) {
			throw new IllegalStateException("Cannot obtain context.");
		}
		return document;
	}

	public JAXBContext getCtx() {
		if (ctx == null) {
			throw new IllegalStateException("Cannot obtain context.");
		}
		return ctx;
	}

	private void reloadDocument() {
		try {
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			getMarshaller().marshal(repository, getDocument());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private Element getDocumentElement() {
		if (document == null) {
			throw new IllegalStateException("Cannot obtain document element.");
		}
		return document.getDocumentElement();
	}

	private Unit buildUnit(T object) {
		Class<?> entityClass = object.getClass();
		try {
			Method identity = entityClass.getDeclaredMethod("getIdentity", null);
			identity.setAccessible(true);
			Unit unit = new Unit();
			unit.setName(object.getClass()
					.getSimpleName().toLowerCase());
			unit.setValue(object);
			unit.setId((Long)identity.invoke(object, null));
			return unit;
		} catch (Exception e) {
			throw new RuntimeException("Cannot retrieve id.");
		} 

	}

	private Node selectSingleNode(String id) {
		if (xpath == null) {
			throw new IllegalStateException("Cannot obtain xpath evaluator.");
		}
		try {
			Node node = (Node)xpath.evaluate("//*[@identity=" + id + "]", getDocument(), XPathConstants.NODE);
			return (node != null) ? node : null;
		} catch (XPathExpressionException e) {
			throw new RuntimeException("Cannot translate xpath expression.");
		}
	}

	private NodeList selectMultiNodes() {
		if (xpath == null) {
			throw new IllegalStateException("Cannot obtain xpath evaluator.");
		}
		try {
			NodeList nodes = (NodeList)xpath.evaluate("//" + ctxClasses[3].getSimpleName().toLowerCase(), getDocument(), XPathConstants.NODESET);
			return (nodes != null && (nodes.getLength() > 0)) ? nodes : null;
		} catch (XPathExpressionException e) {
			throw new RuntimeException("Cannot translate xpath expression.");
		}
	}

	@Override
	public void insert(T object) {
		Unit unit = buildUnit(object);
		if (unit != null) {
			if (repository.getUnits().size() < 1) {
				repository.getUnits().add(unit);
				reloadDocument();
			} else {
				getDocument().getElementsByTagName("units").item(0).appendChild(buildNode(object));
			}
		} else {
			throw new IllegalStateException("Cannot instantiate unit object.");
		}
	}

	private Node buildNode(T object) {
		Unit unit = buildUnit(object);
		Node newNode = getDocument().createElement("wrapper");
		DOMResult result = new DOMResult(newNode);
		try {
			Elements elements = new Elements();
			elements.getElements().add(unit);
			getMarshaller().marshal(elements, result);
			newNode = result.getNode().getFirstChild().getChildNodes().item(0);
			return newNode;
		} catch (Exception e) {
			throw new IllegalStateException("Cannot instantiate unit object.");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T read(String id) {
		Node node = selectSingleNode(id);
		try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			node = doc.importNode(node, true);
			doc.appendChild(node);
			Source source = new DOMSource(doc);
			return (T)getUnmarshaller().unmarshal(source);
		} catch (Exception e) {
			throw new RuntimeException("Cannot deserialize unit.");
		}
	}

	@Override
	public T update(T object) {
		Node newNode = buildNode(object);
		T prevValue = read(((Element)newNode).getAttribute("identity"));
		NodeList units = getDocument().getElementsByTagName("units").item(0).getChildNodes();
		System.out.println();
		for(int i = 0, count = units.getLength(); i < count; i++) {
			if (((Element)newNode).getAttribute("identity")
					.equals(((Element)units.item(i)).getAttribute("identity"))) {
				getDocument().getElementsByTagName("units").item(0).replaceChild(newNode, units.item(i));
			}
		}
		return prevValue;
	}

	@Override
	public void delete(T object) {
		
		Node node = buildNode(object);
		NodeList units = getDocument().getElementsByTagName("units").item(0).getChildNodes();
		for(int i = 0, count = units.getLength(); i < count; i++) {
			if (((Element)node).isEqualNode((Element)units.item(i))) {
				getDocument().getElementsByTagName("units").item(0).removeChild(units.item(i));
				break;
			}
		}
//		Unit unit = buildUnit(object);
//		List<Unit> units = repository.getUnits();
//		ListIterator<Unit> iterator = units.listIterator();
//		while(iterator.hasNext()) {
//			if (unit.getId().equals(iterator.next().getId())) {
//				iterator.remove();
//				break;
//			}
//		}
//		reloadDocument();
	}

	@Override
	public Collection<T> list() {
		NodeList list = selectMultiNodes();
		Node node = null;
		try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element root = doc.createElement("units");
			Node rootNode = doc.appendChild(root);
			if (list != null) {
				for (int i = 0, count = list.getLength(); i < count; i++) {
					node = doc.importNode(list.item(i), true);
					rootNode.appendChild(node);
				}		
				Source source = new DOMSource(doc);
				UnitWrapper<T> wrapper = (UnitWrapper<T>)getUnmarshaller().unmarshal(source, UnitWrapper.class).getValue();
				return wrapper.getList();
			}
			return Collections.emptyList();
		} catch (Exception e) {
			throw new RuntimeException("Cannot deserialize unit.");
		}
	}

	@XmlRootElement
	private static class UnitWrapper<E> {

		private List<E> list = new ArrayList<E>();

		@XmlAnyElement(lax=true)
		public List<E> getList() {
			return list;
		}

		public void setList(List<E> list) {
			this.list = list;
		}

	}

	private static final class CacheItem {

		private final Repository repository;

		private final Document document;

		public CacheItem(Repository repository, Document document) {
			super();
			this.repository = repository;
			this.document = document;
		}

		public Repository getRepository() {
			return repository;
		}

		public Document getDocument() {
			return document;
		}

	}

}
