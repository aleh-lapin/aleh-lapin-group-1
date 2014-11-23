package jmp.module07.ejb.services.account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Entity
@Table(name = "Account")
public class Account implements Serializable {
    
	private static final long serialVersionUID = -1502436103746082391L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@NotNull
    @NotEmpty
    @Column(columnDefinition = "TEXT", name = "account_definition")
    private String accountDefinition;

    public Account() {
    }

    public Account(String accountDefinition) {
        this.accountDefinition = accountDefinition;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountDefinition() {
		return accountDefinition;
	}

	public void setAccountDefinition(String accountDefinition) {
		this.accountDefinition = accountDefinition;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (accountDefinition != null ? !accountDefinition.equals(account.accountDefinition) : account.accountDefinition != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (accountDefinition != null ? accountDefinition.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountDefinition='" + accountDefinition + '\'' +
                '}';
    }
}
