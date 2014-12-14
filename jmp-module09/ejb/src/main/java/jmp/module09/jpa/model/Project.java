package jmp.module09.jpa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

@Entity
@Table(name = "Project")
@NamedQuery(name="Project.findByIdWithDetails",
query="select p from Project p where p.id = :projectId"
)
@JsonIgnoreProperties("employees")
public class Project implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "id")
	@Type(value = Long.class, name = "id")
	protected Long id = 0L;
	
	@JsonProperty(value = "name")
	@Type(value = String.class, name = "name")
	private String projectName;
	
	@ManyToMany
	@JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "PROJECT_ID"),
	inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
	private Set<Employee> employees = new HashSet<Employee>();
	
	@JsonCreator
	public Project(){
		
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
