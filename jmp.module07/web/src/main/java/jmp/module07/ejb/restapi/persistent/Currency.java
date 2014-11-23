package jmp.module07.ejb.restapi.persistent;

import java.io.Serializable;
import java.math.BigDecimal;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

@JsonIgnoreProperties
public class Currency implements Serializable {

	private static final long serialVersionUID = 5664007809050447486L;

	@JsonProperty(value = "value")
    @Type(value = BigDecimal.class, name = "value")
    protected BigDecimal value;
    
    @JsonProperty(value = "curr")
    @Type(value = CurrencyType.class, name = "curr")
    protected CurrencyType curr;

    @JsonCreator
    public Currency(){
    	
    }
    
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public CurrencyType getCurr() {
        return curr;
    }

    public void setCurr(CurrencyType value) {
        this.curr = value;
    }

}
