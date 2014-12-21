package jmp.module11.mvc.domain;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

@JsonIgnoreProperties
public class Address implements Serializable {

	private static final long serialVersionUID = -5415665499402064167L;

	@JsonProperty(value = "country")
    @Type(value = String.class, name = "country")
    protected String country;
    
    @JsonProperty(value = "city")
    @Type(value = String.class, name = "city")
    protected String city;
    
    @JsonProperty(value = "district")
    @Type(value = String.class, name = "district")
    protected String district;
    
    @JsonProperty(value = "telephones")
    @Type(value = Telephones.class, name = "telephones")
    protected Telephones telephones;

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

    public Telephones getTelephones() {
        return telephones;
    }

    public void setTelephones(Telephones value) {
        this.telephones = value;
    }

}
