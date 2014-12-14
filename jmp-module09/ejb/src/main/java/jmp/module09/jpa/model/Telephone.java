package jmp.module09.jpa.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

@Entity
@Table(name = "Telephone")
@JsonIgnoreProperties(value = {"address"})
public class Telephone implements Serializable {

	private static final long serialVersionUID = -7669848655222293592L;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
	protected Address address;

	@NotNull
	@Size(min = 5, max = 12)
	@Digits(fraction = 0, integer = 12)
	@JsonProperty(value = "value")
	@Type(value = String.class, name = "value")
	protected String value;

	@Enumerated(EnumType.STRING)
	@JsonProperty(value = "telephoneType")
	@Type(value = TelephoneType.class, name = "telephoneType")
	protected TelephoneType telephoneType;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "id")
	@Type(value = Long.class, name = "id")
	protected Long id = 0L;

	@JsonCreator
	public Telephone(){

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public TelephoneType getTelephoneType() {
		return telephoneType;
	}

	public void setTelephoneType(TelephoneType value) {
		this.telephoneType = value;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
