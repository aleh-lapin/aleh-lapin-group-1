package jmp.module07.ejb.services.exchanger;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Entity
@Table(name = "Exchanger")
public class Exchanger implements Serializable {
	
	private static final long serialVersionUID = -8980715099284191254L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotEmpty
    @Column(columnDefinition = "TEXT", name = "account_definition")
    private String exchangerDefinition;

    public Exchanger() {
    }

    public Exchanger(String exchangerDefinition) {
        this.exchangerDefinition = exchangerDefinition;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExchangerDefinition() {
		return exchangerDefinition;
	}

	public void setExchangerDefinition(String exchangerDefinition) {
		this.exchangerDefinition = exchangerDefinition;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exchanger)) return false;

        Exchanger exchanger = (Exchanger) o;

        if (id != exchanger.id) return false;
        if (exchangerDefinition != null ? 
        		!exchangerDefinition.equals(exchanger.exchangerDefinition) : 
        			exchanger.exchangerDefinition != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (exchangerDefinition != null ? exchangerDefinition.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Exchanger{" +
                "id=" + id +
                ", exchangerDefinition='" + exchangerDefinition + '\'' +
                '}';
    }
}
