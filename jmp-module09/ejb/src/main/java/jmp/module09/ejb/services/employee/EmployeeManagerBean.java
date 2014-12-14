package jmp.module09.ejb.services.employee;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jmp.module09.jpa.model.Address;
import jmp.module09.jpa.model.Employee;
import jmp.module09.jpa.model.EmployeeStatus;
import jmp.module09.jpa.model.Genre;
import jmp.module09.jpa.model.Nationality;
import jmp.module09.jpa.model.Person;
import jmp.module09.jpa.model.Telephone;
import jmp.module09.jpa.model.TelephoneType;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EmployeeManagerBean implements EmployeeManager, EmployeeManagerLocal {
   
	@PersistenceContext
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createEmployee(Employee employee) {
    			
//		for(Address addr : employee.getPerson().getAddresses()) {
//			addr.setTelephones(addr.getTelephones());
//		}
//		
//		Set<Address> addresses = employee.getPerson().getAddresses();
			
		Person person = new Person();
		person.setAddresses(employee.getPerson().getAddresses());
		person.setBirthDate(employee.getPerson().getBirthDate());
		person.setEmail(employee.getPerson().getEmail());
		person.setFirstName(employee.getPerson().getFirstName());
		person.setLastName(employee.getPerson().getLastName());
		person.setSurName(employee.getPerson().getSurName());
		person.setGenre(employee.getPerson().getGenre());
		person.setNationality(employee.getPerson().getNationality());
		person.setWorkPlace(employee.getPerson().getWorkPlace());
		
		Employee emp = new Employee();
		emp.setEmployeeStatus(employee.getEmployeeStatus());
		emp.setLastUpdatedDate(new Date());
		emp.setPerson(person);
        em.persist(employee);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteEmployee(long employeeId) {
    	Query query = em.createQuery("delete from Employee e where e.id = :employeeId");
    	query.setParameter("employeeId", employeeId);
    	query.executeUpdate();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateEmployee(long employeeId, Employee employee) {
    	Employee currEmployee = em.find(Employee.class, employeeId);
    	if (currEmployee ==null) {
    		throw new IllegalArgumentException("Non-existant employee identity");
    	}
    	currEmployee.setEmployeeStatus(employee.getEmployeeStatus());
    	currEmployee.setLastUpdatedDate(employee.getLastUpdatedDate());
    	currEmployee.setProjects(employee.getProjects());
    	currEmployee.setUnit(employee.getUnit());
    	Person curPerson = currEmployee.getPerson();
    	curPerson.setBirthDate(employee.getPerson().getBirthDate());
    	curPerson.setEmail(employee.getPerson().getEmail());
    	curPerson.setFirstName(employee.getPerson().getFirstName());
    	curPerson.setLastName(employee.getPerson().getLastName());
    	curPerson.setSurName(employee.getPerson().getSurName());
    	curPerson.setGenre(employee.getPerson().getGenre());
    	curPerson.setNationality(employee.getPerson().getNationality());
    	curPerson.setWorkPlace(employee.getPerson().getWorkPlace());
    	for(Address address : curPerson.getAddresses()) {
    		for(Address subSddress : employee.getPerson().getAddresses()) {
        		if (address.getId().equals(subSddress.getId())) {
        			address.setCity(subSddress.getCity());
        			address.setCountry(subSddress.getCountry());
        			address.setDistrict(subSddress.getDistrict());
        			for(Telephone tel : address.getTelephones()) {
        				for(Telephone subTel : subSddress.getTelephones()) {
            				if (tel.getTelephoneType().equals(subTel.getTelephoneType())) {
            					tel.setValue(subTel.getValue());
            				}
            			}
        			}
        		}
        	}
    	}
    	
    	em.merge(currEmployee);
    }

    @SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Employee> list() {
		Query query = em.createQuery("from Employee e");
        List<Employee> list = new ArrayList<Employee>();
        list = query.getResultList();
        return (list != null) ? list : Collections.<Employee>emptyList();
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Employee getEmployee(long employeeId) {
    	Employee employee = em.createNamedQuery("Employee.findByIdWithDetails", Employee.class)
    		.setParameter("employeeId", employeeId).getSingleResult();
        return employee;
    }
}
