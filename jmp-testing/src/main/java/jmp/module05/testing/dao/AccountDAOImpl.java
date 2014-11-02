package jmp.module05.testing.dao;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import jmp.module05.testing.exceptions.DaoException;
import jmp.module05.testing.utils.SchemaLoader;
import jmp.module05.testing.utils.Utils;
import jmp.module05.testing.utils.XmlProcessor;
import org.apache.xmlbeans.XmlObject;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AccountDAOImpl implements AccountDAO {

	public void insertAccount(Node newNode) throws DaoException{
		try {
			Node document = Utils.readDocument(Utils.getFilePath(getClass(), "accounts.xml"));
			newNode = document.getFirstChild().getOwnerDocument().importNode(newNode, true);
			document.getFirstChild().appendChild(newNode);
			Utils.wrieDocument(document, Utils.getFilePath(getClass(), "accounts.xml"));
		} catch (Exception e) {
			throw new  DaoException(e);
		}
	}

	public Node updateAccount(String accountId, Node newNode) throws DaoException{
		try {
			Node oldNode = getAccount(accountId);
			Node document = oldNode.getParentNode();
			newNode = document.getOwnerDocument().importNode(newNode, true);
			document.replaceChild(newNode, oldNode);
			return Utils.wrieDocument(document, Utils.getFilePath(getClass(), "accounts.xml"));
		} catch (Exception e) {
			throw new  DaoException(e);
		}
	}

	public Node deleteAccount(String accountId) throws DaoException{
		try {
			Node document = Utils.readDocument(Utils.getFilePath(getClass(), "accounts.xml"));
			NodeList nodeList = xselect(document, ".//*[local-name()='Account'][@ID=" + accountId + "]");
			Node account = nodeList.item(0);
			if (account != null)
				account = document.getFirstChild().removeChild(account);
			Utils.wrieDocument(document, Utils.getFilePath(getClass(), "accounts.xml"));
			return account;
		} catch (Exception e) {
			throw new  DaoException(e);
		}
	}

	public Node getAccount(String accountId) throws DaoException{
		try {
			SchemaLoader schemaLoader = new SchemaLoader();
			schemaLoader.addSchema("/Account.xsd");
			XmlProcessor processor = new XmlProcessor(schemaLoader);
			Node rootNode = Utils.readDocument(Utils.getFilePath(getClass(), "accounts.xml"));
			XmlObject xobject = processor.parse(rootNode);
			NodeList nodeList = xselect(xobject, ".//*[local-name()='Account'][@ID=" + accountId + "]");
			return (nodeList.getLength() != 0) ? nodeList.item(0) : null;
		} catch (Exception e) {
			throw new  DaoException(e);
		}
	}

	private NodeList xselect(XmlObject xobject, String xPath) {
		try {
			Node root = xobject.getDomNode().getFirstChild();
			XPath xpath = XPathFactory.newInstance().newXPath();
			return (NodeList) xpath.evaluate(xPath, root, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			throw new RuntimeException("XPath evaluation error", e);
		}
	}

	private NodeList xselect(Node root, String xPath) {
		try {
			XPath xpath = XPathFactory.newInstance().newXPath();
			return (NodeList) xpath.evaluate(xPath, root, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			throw new RuntimeException("XPath evaluation error", e);
		}
	}

}
