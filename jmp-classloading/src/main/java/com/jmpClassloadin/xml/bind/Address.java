package com.jmpClassloadin.xml.bind;

import java.io.InputStream;
import java.util.Arrays;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

import com.jmpClassloadin.xml.bind.address.Telephone;

public class Address extends XmlEntity {
	
	private static final String XML_INSTANCE = "address.xml";
	
	private String country;
	
	private String city;
	
	private String district;
	
	private Telephone[] telephones;
	
	public Address() throws XmlException {
		populateAddress();
	}
	
	protected XmlObject initConfig(String xml) throws XmlException {
		InputStream stream = com.jmpClassloadin.xml.bind.Address.class.getClassLoader().getResourceAsStream(xml);
		String xmlInstance = retrieveXmlInstance(stream);
		 
		com.jmpClassloadin.xml.bind.address.AddressDocument objectDocument = 
				com.jmpClassloadin.xml.bind.address.AddressDocument.Factory.parse(xmlInstance);
		return objectDocument.getAddress();
	}

	private void populateAddress() throws XmlException {
		com.jmpClassloadin.xml.bind.address.AddressDocument.Address address =
				(com.jmpClassloadin.xml.bind.address.AddressDocument.Address)initConfig(XML_INSTANCE);
		this.country = address.getCountry();
		this.city = address.getCity();
		this.district = address.getDistrict();
		this.telephones = address.getTelephones().getTelephoneArray();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Telephone[] getTelephones() {
		return telephones;
	}

	public void setTelephones(Telephone[] telephones) {
		this.telephones = telephones;
	}

	public static String getXmlInstance() {
		return XML_INSTANCE;
	}

	@Override
	public String toString() {
		return String.format(
				"Address [country=%s, city=%s, district=%s, telephones=%s]",
				country, city, district, Arrays.toString(telephones));
	}
	
}
