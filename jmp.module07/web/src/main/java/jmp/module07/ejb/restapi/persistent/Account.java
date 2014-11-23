package jmp.module07.ejb.restapi.persistent;

import java.io.Serializable;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import jmp.module07.ejb.restapi.JsonDateDeserializer;
import jmp.module07.ejb.restapi.JsonDateSerializer;

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
    protected Currency ballance;
    
    @JsonProperty(value = "lastUpdatedDate")
    @Type(value = Date.class, name = "lastUpdatedDate")
    protected Date lastUpdatedDate = new Date();
    
    protected boolean active;
    
    @JsonProperty(value = "id")
    @Type(value = Long.class, name = "id")
    protected Long id = 0L;

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

    public long getID() {
        return id;
    }

    public void setID(long value) {
        this.id = value;
    }

}
