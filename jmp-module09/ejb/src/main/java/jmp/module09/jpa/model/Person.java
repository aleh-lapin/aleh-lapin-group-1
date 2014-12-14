package jmp.module09.jpa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
//import jmp.module07.ejb.restapi.JsonDateDeserializer;
//import jmp.module07.ejb.restapi.JsonDateSerializer;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Person")
@JsonIgnoreProperties({"employee"})
public class Person implements Serializable {
	
	private static final long serialVersionUID = 3320720568852587513L;

	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	@JsonProperty(value = "firstName")
    @Type(value = String.class, name = "firstName")
    protected String firstName;
    
	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    @JsonProperty(value = "surName")
    @Type(value = String.class, name = "surName")
    protected String surName;
    
	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    @JsonProperty(value = "lastName")
    @Type(value = String.class, name = "lastName")
    protected String lastName;
    
	@Temporal(TemporalType.DATE)
    @JsonProperty(value = "birthDate")
    @Type(value = Date.class, name = "birthDate")
    protected Date birthDate = new Date();
    
    @JsonProperty(value = "workPlace")
    @Type(value = String.class, name = "workPlace")
    protected String workPlace;
    
    @Enumerated(EnumType.STRING)
    @JsonProperty(value = "genre")
    @Type(value = Genre.class, name = "genre")
    protected Genre genre;
    
    @Enumerated(EnumType.STRING)
    @JsonProperty(value = "nationality")
    @Type(value = Nationality.class, name = "nationality")
    protected Nationality nationality;
    
    
    @OneToMany(mappedBy="person", cascade={CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval=true, fetch = FetchType.EAGER)
    @JsonProperty(value = "addresses")
    @Type(value = Set.class, name = "addresses")
    protected Set<Address> addresses = new HashSet<Address>();
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "id")
    @Type(value = Long.class, name = "id")
    @Column(name="PERSON_ID", insertable = true, updatable=false, unique=true, nullable=false)
    protected Long id = 0L;
    
    @OneToOne(optional=false, mappedBy="person")
    protected Employee employee;
    
    @NotNull
    @NotEmpty
    @Email
    @JsonProperty(value = "email")
    @Type(value = String.class, name = "email")
    private String email;
    
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

	//@JsonSerialize(using=JsonDateSerializer.class)
	public Date getBirthDate() {
		return birthDate;
	}

	//@JsonDeserialize(using=JsonDateDeserializer.class)
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getWorkPlace() {
        return this.workPlace;
	}

	public void setWorkPlace(String workPlace) {
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

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
		for(Address address : addresses) {
			address.setPerson(this);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
		    
}
