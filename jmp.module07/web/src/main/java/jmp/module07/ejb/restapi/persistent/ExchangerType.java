package jmp.module07.ejb.restapi.persistent;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

@JsonIgnoreProperties
public class ExchangerType implements Serializable {

	private static final long serialVersionUID = -4234727321005591025L;

	@JsonProperty(value = "course")
    @Type(value = Currency[].class, name = "course")
    protected Currency[] course;
    
    @JsonProperty(value = "basicCurrency")
    @Type(value = CurrencyType.class, name = "basicCurrency")
    protected CurrencyType basiccurrency;
    
    @JsonProperty(value = "bankRef")
    @Type(value = String.class, name = "bankRef")
    protected String bankref;

    @JsonCreator
    public ExchangerType(){
    	
    }

	public Currency[] getCourse() {
		if (course == null) {
            course = new Currency[0];
        }
        return this.course;
	}

	public void setCourse(Currency[] course) {
		this.course = course;
	}

	public CurrencyType getBasiccurrency() {
		return basiccurrency;
	}

	public void setBasiccurrency(CurrencyType basiccurrency) {
		this.basiccurrency = basiccurrency;
	}

	public String getBankref() {
		return bankref;
	}

	public void setBankref(String bankref) {
		this.bankref = bankref;
	}
    
}
