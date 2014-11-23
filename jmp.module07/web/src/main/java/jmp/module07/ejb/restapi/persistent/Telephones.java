package jmp.module07.ejb.restapi.persistent;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

@JsonIgnoreProperties
public class Telephones implements Serializable {

	private static final long serialVersionUID = -3166497833823194797L;
	
	@JsonProperty(value = "telephones")
    @Type(value = Telephone[].class, name = "telephones")
    protected Telephone[] telephones;

	@JsonCreator
    public Telephones(){
    	
    }

	public Telephone[] getTelephones() {
		return telephones;
	}

	public void setTelephones(Telephone[] telephones) {
		this.telephones = telephones;
	}
	
}
