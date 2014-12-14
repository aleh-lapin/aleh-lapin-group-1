package jmp.module09.jpa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

@Entity
@Table(name = "Unit")
@JsonIgnoreProperties("employees")
@NamedQuery(name="Unit.findByIdWithDetails",
query="select u from Unit u where u.id = :unitId"
)
public class Unit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@JsonProperty(value = "unitType")
	@Type(value = UnitType.class, name = "unitType")
	protected UnitType unitType;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "id")
    @Type(value = Long.class, name = "id")
    protected Long id = 0L;
	
	@OneToMany(mappedBy="unit", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonProperty(value = "employees")
    @Type(value = Set.class, name = "employees")
    protected Set<Employee> employees = new HashSet<Employee>();

	@JsonCreator
	public Unit(){

	}

	public UnitType getUnitType() {
		return unitType;
	}

	public void setUnitType(UnitType unitType) {
		this.unitType = unitType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
		for(Employee employee : employees) {
			employee.setUnit(this);
		}
	}
			
}
