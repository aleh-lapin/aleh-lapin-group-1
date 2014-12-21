package jmp.module11.dao.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Exchanger")
public class Exchanger implements Serializable {
	
	private static final long serialVersionUID = -8980715099284191254L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotEmpty
    @Column(columnDefinition = "TEXT", name = "account_definition")
    private String exchangerDefinition;
    
 	private String createdBy;
 	private Date createdDate;	
 	private String lastModifiedBy;
 	private Date lastModifiedDate;
 	
 	private int version;

    public Exchanger() {
    }

    public Exchanger(String exchangerDefinition) {
        this.exchangerDefinition = exchangerDefinition;
    }
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExchangerDefinition() {
		return exchangerDefinition;
	}

	public void setExchangerDefinition(String exchangerDefinition) {
		this.exchangerDefinition = exchangerDefinition;
	}
	
	@Version
	@Column(name = "VERSION")
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name="CREATED_DATE")
	@Temporal(TemporalType.DATE)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name="LAST_MODIFIED_BY")
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Column(name="LAST_MODIFIED_DATE")
	@Temporal(TemporalType.DATE)
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Transient
	public boolean isNew() {
		if (id == null) {
			return true;
		} else {
			return false;
		}
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
		return String
				.format("Exchanger [id=%s, exchangerDefinition=%s, createdBy=%s, createdDate=%s, lastModifiedBy=%s, lastModifiedDate=%s]",
						id, exchangerDefinition, createdBy, createdDate,
						lastModifiedBy, lastModifiedDate);
	}
    
}
