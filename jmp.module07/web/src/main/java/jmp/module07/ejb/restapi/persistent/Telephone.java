package jmp.module07.ejb.restapi.persistent;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

@JsonIgnoreProperties
public class Telephone implements Serializable {
	
	private static final long serialVersionUID = -7669848655222293592L;

	@JsonProperty(value = "value")
    @Type(value = String.class, name = "value")
    protected String value;
    
    @JsonProperty(value = "telephoneType")
    @Type(value = TelephoneType.class, name = "telephoneType")
    protected TelephoneType telephoneType;

    @JsonCreator
    public Telephone(){
    	
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

}
