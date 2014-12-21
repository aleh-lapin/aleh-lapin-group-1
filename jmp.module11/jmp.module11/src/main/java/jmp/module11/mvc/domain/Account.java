package jmp.module11.mvc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jmp.module11.mvc.rest.client.JsonDateDeserializer;
import jmp.module11.mvc.rest.client.JsonDateSerializer;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(value = {"active"})
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "person")
    @Type(value = Person.class, name = "person")
    protected Person person;
    
    @JsonProperty(value = "credit")
    @Type(value = Currency.class, name = "credit")
    protected Currency credit;
    
    @JsonProperty(value = "debit")
    @Type(value = Currency.class, name = "debit")
    protected Currency debit;
    
    @JsonProperty(value = "ballance")
    @Type(value = Currency.class, name = "ballance")
    protected Currency ballance = new Currency();
    
    @JsonProperty(value = "lastUpdatedDate")
    @Type(value = Date.class, name = "lastUpdatedDate")
    protected Date lastUpdatedDate = new Date();
    
    protected boolean active;
    
    @JsonProperty(value = "id")
    @Type(value = Long.class, name = "id")
    protected int id = 0;
    
    {
    	ballance.setCurr(CurrencyType.RU);
    	ballance.setValue(BigDecimal.valueOf(0D));
    }

    @JsonCreator
    public Account(){
    	
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = value;
    }

    public Currency getCredit() {
        return credit;
    }

    public void setCredit(Currency value) {
        this.credit = value;
    }

    public Currency getDebit() {
        return debit;
    }

    public void setDebit(Currency value) {
        this.debit = value;
    }

    public Currency getBallance() {
        return ballance;
    }

    
    public void setBallance(Currency value) {
        this.ballance = value;
    }

    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }
    
    @JsonDeserialize(using=JsonDateDeserializer.class)
    public void setLastUpdatedDate(Date value) {
        this.lastUpdatedDate = value;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean value) {
        this.active = value;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
