package jmp.module11.ejb.restapi.persistent;

import java.io.Serializable;
import java.util.Date;
import jmp.module11.ejb.restapi.JsonNationalityDeserializer;
import jmp.module11.ejb.restapi.JsonDateDeserializer;
import jmp.module11.ejb.restapi.JsonDateSerializer;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties
public class Person implements Serializable {
	
	private static final long serialVersionUID = 3320720568852587513L;

	@JsonProperty(value = "firstName")
    @Type(value = String.class, name = "firstName")
    protected String firstName;
    
    @JsonProperty(value = "surName")
    @Type(value = String.class, name = "surName")
    protected String surName;
    
    @JsonProperty(value = "lastName")
    @Type(value = String.class, name = "lastName")
    protected String lastName;
    
    @JsonProperty(value = "birthDate")
    @Type(value = Date.class, name = "birthDate")
    protected Date birthDate = new Date();
    
    @JsonProperty(value = "workPlace")
    @Type(value = String[].class, name = "workPlace")
    protected String[] workPlace;
    
    @JsonProperty(value = "genre")
    @Type(value = Genre.class, name = "genre")
    protected Genre genre;
    
    @JsonProperty(value = "nationality")
    @Type(value = Nationality.class, name = "nationality")
    protected Nationality nationality;
    
    @JsonProperty(value = "address")
    @Type(value = Address.class, name = "address")
    protected Address address;
    
    @JsonProperty(value = "id")
    @Type(value = Long.class, name = "id")
    protected Long id = 0L;

    @JsonCreator
    public Person(){
    	
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

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getBirthDate() {
		return birthDate;
	}

	@JsonDeserialize(using=JsonDateDeserializer.class)
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String[] getWorkPlace() {
		if (workPlace == null) {
            workPlace = new String[0];
        }
        return this.workPlace;
	}

	public void setWorkPlace(String[] workPlace) {
		this.workPlace = workPlace;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Nationality getNationality() {
		return nationality;
	}

	@JsonDeserialize(using=JsonNationalityDeserializer.class)
	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
}
