package jmp.module09.jpa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

@Entity
@Table(name = "Address")
@JsonIgnoreProperties({"person"})
public class Address implements Serializable {

	private static final long serialVersionUID = -5415665499402064167L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "id")
	@Type(value = Long.class, name = "id")
	@Column(name="ADDRESS_ID", insertable = true, updatable=false, unique=true, nullable=false)
	protected Long id = 0L;
	
	@JsonProperty(value = "country")
    @Type(value = String.class, name = "country")
    protected String country;
    
    @JsonProperty(value = "city")
    @Type(value = String.class, name = "city")
    protected String city;
    
    @JsonProperty(value = "district")
    @Type(value = String.class, name = "district")
    protected String district;
    
    @OneToMany(mappedBy = "address", cascade= CascadeType.PERSIST, orphanRemoval=true, fetch = FetchType.EAGER)
    @JsonProperty(value = "telephones")
    @Type(value = Set.class, name = "telephones")
    protected Set<Telephone> telephones;
    
    @ManyToOne(optional=true, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="PERSON_ID", referencedColumnName = "PERSON_ID")
    @JsonProperty(value = "person")
    @Type(value = Person.class, name = "person")
    protected Person person;

    @JsonCreator
    public Address(){
    	
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String value) {
        this.district = value;
    }

    public Set<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(Set<Telephone> telephones) {
		this.telephones = telephones;
		for(Telephone telephone : telephones){
			telephone.setAddress(this);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
