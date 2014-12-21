package jmp.module11.mvc.domain;

import java.io.Serializable;
import java.util.LinkedList;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

@SuppressWarnings("serial")
@JsonIgnoreProperties
public class Telephones implements Serializable {

	private static final long serialVersionUID = -3166497833823194797L;
	
	@JsonProperty(value = "telephones")
    @Type(value = Telephone[].class, name = "telephones")
    protected Telephone[] telephones;
	
	{
		new LinkedList<Telephone>() {
			{
				add(new Telephone(TelephoneType.HOME));
				add(new Telephone(TelephoneType.MOBILE));
				add(new Telephone(TelephoneType.WORK));
				add(new Telephone(TelephoneType.VO_IP));
				telephones = this.toArray(new Telephone[0]);
			}
		};
		
	}

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
