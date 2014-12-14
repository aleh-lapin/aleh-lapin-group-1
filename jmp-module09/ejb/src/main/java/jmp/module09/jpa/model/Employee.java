package jmp.module09.jpa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
//import jmp.module09.ejb.restapi.JsonDateDeserializer;
//import jmp.module07.ejb.restapi.JsonDateSerializer;

@Entity
@Table(name = "Employee")
@NamedQuery(name="Employee.findByIdWithDetails",
query="select e from Employee e where e.id = :employeeId"
)
@JsonIgnoreProperties(value = {"active"})
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne(optional=true, fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinColumn(
        name="PERSON_ID", unique=true, nullable=false, updatable=true)
	@JsonProperty(value = "person")
    @Type(value = Person.class, name = "person")
    protected Person person;
       
    @Enumerated(EnumType.STRING)
    @JsonProperty(value = "employeeStatus")
    @Type(value = EmployeeStatus.class, name = "employeeStatus")
    protected EmployeeStatus employeeStatus;
    
    @Temporal(TemporalType.DATE)
    @JsonProperty(value = "lastUpdatedDate")
    @Type(value = Date.class, name = "lastUpdatedDate")
    protected Date lastUpdatedDate = new Date();
    
    protected boolean active;
    
    @ManyToOne(optional=true, fetch=FetchType.EAGER)
	@JoinColumn(name="UNIT_ID")
    @JsonProperty(value = "unit")
    @Type(value = Unit.class, name = "unit")
    protected Unit unit;
    
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
	inverseJoinColumns = @JoinColumn(name = "PROJECT_ID"))
    protected Set<Project> projects = new HashSet<Project>();
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "id")
    @Type(value = Long.class, name = "id")
    protected Long id = 0L;

    @JsonCreator
    public Employee(){
    	
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = value;
    }

    //@JsonSerialize(using=JsonDateSerializer.class)
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }
    
    //@JsonDeserialize(using=JsonDateDeserializer.class)
    public void setLastUpdatedDate(Date value) {
        this.lastUpdatedDate = value;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean value) {
        this.active = value;
    }
    
    public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public EmployeeStatus getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
