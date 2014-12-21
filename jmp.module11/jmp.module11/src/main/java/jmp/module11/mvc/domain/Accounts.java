package jmp.module11.mvc.domain;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

@JsonIgnoreProperties
public class Accounts implements Serializable {

	private static final long serialVersionUID = 4888710480527247790L;
	
	@JsonProperty(value = "accounts")
    @Type(value = Account[].class, name = "accounts")
    protected Account[] accounts;

    public Account[] getAccounts() {
        if (accounts == null) {
        	accounts = new Account[0];
        }
        return this.accounts;
    }

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
   
}
