package com.jmpClassloadin.xml.bind;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Calendar;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

public class Person extends XmlEntity {

	private static final String XML_INSTANCE = "person.xml";

	private long id;

	private String firstName;

	private String surName;

	private String lastName;

	private Calendar birthDate;

	private String[] workPlaces;

	private com.jmpClassloadin.xml.bind.person.Genre.Enum genre;

	private com.jmpClassloadin.xml.bind.person.Nationality.Enum nationality;
	
	private com.jmpClassloadin.xml.bind.Address address;
	
	public Person() throws XmlException {
		populatePerson();
	}
	
	protected XmlObject initConfig(String xml) throws XmlException {
		InputStream stream = com.jmpClassloadin.xml.bind.Person.class.getClassLoader().getResourceAsStream(xml);
		String xmlInstance = retrieveXmlInstance(stream);
		 
		com.jmpClassloadin.xml.bind.person.PersonDocument objectDocument = 
				com.jmpClassloadin.xml.bind.person.PersonDocument.Factory.parse(xmlInstance);
		return objectDocument.getPerson();
	}

	private void populatePerson() throws XmlException {
		com.jmpClassloadin.xml.bind.person.PersonDocument.Person person = 
				(com.jmpClassloadin.xml.bind.person.PersonDocument.Person)initConfig(XML_INSTANCE);
		this.id = person.getID();
		this.firstName = person.getFirstName();
		this.surName = person.getSurName();
		this.lastName = person.getLastName();
		this.birthDate = person.getBirthDate();
		this.workPlaces = person.getWorkPlaceArray();
		this.genre = person.getGenre();
		this.nationality = person.getNationality();
		this.address = new com.jmpClassloadin.xml.bind.Address();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String[] getWorkPlaces() {
		return workPlaces;
	}

	public void setWorkPlaces(String[] workPlaces) {
		this.workPlaces = workPlaces;
	}

	public com.jmpClassloadin.xml.bind.person.Genre.Enum getGenre() {
		return genre;
	}

	public void setGenre(com.jmpClassloadin.xml.bind.person.Genre.Enum genre) {
		this.genre = genre;
	}

	public com.jmpClassloadin.xml.bind.person.Nationality.Enum getNationality() {
		return nationality;
	}

	public void setNationality(
			com.jmpClassloadin.xml.bind.person.Nationality.Enum nationality) {
		this.nationality = nationality;
	}

	public static String getXmlInstance() {
		return XML_INSTANCE;
	}

	@Override
	public String toString() {
		return String
				.format("Person [id=%s, firstName=%s, surName=%s, lastName=%s, birthDate=%s, workPlaces=%s, genre=%s, nationality=%s, address=%s]",
						id, firstName, surName, lastName, birthDate,
						Arrays.toString(workPlaces), genre, nationality, address);
	}
	
	
}
