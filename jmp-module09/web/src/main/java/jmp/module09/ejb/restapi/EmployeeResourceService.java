package jmp.module09.ejb.restapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import jmp.module09.ejb.services.employee.EmployeeManager;
import jmp.module09.ejb.services.project.ProjectManager;
import jmp.module09.ejb.services.unit.UnitManager;
import jmp.module09.jpa.model.Address;
import jmp.module09.jpa.model.Employee;
import jmp.module09.jpa.model.EmployeeStatus;
import jmp.module09.jpa.model.Genre;
import jmp.module09.jpa.model.Nationality;
import jmp.module09.jpa.model.Person;
import jmp.module09.jpa.model.Project;
import jmp.module09.jpa.model.Telephone;
import jmp.module09.jpa.model.TelephoneType;
import jmp.module09.jpa.model.Unit;

public class EmployeeResourceService implements EmployeeResource {

	private Context getContext() throws NamingException {
		Hashtable<String, Object> p = new Hashtable<String, Object>();
		p.put("jboss.naming.client.ejb.context", true);
		p.put(Context.PROVIDER_URL, "remote://localhost:4447");
		p.put(InitialContext.SECURITY_PRINCIPAL, "user");
		p.put(InitialContext.SECURITY_CREDENTIALS, "vikS601.");
		//p.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", "false");
		final Context context = new InitialContext(p);

		return context;
	}

	private EmployeeManager getEmployeeManager() throws NamingException, IOException {
		return (EmployeeManager) getContext().lookup("ejb:jmp-module09-ear/jmp-module09-ejb/EmployeeManagerBean!jmp.module09.ejb.services.employee.EmployeeManager");
	}
	
	private UnitManager getUnitManager() throws NamingException, IOException {
		return (UnitManager) getContext().lookup("ejb:jmp-module09-ear/jmp-module09-ejb/UnitManagerBean!jmp.module09.ejb.services.unit.UnitManager");
	}
	
	private ProjectManager getProjectManager() throws NamingException, IOException {
		return (ProjectManager) getContext().lookup("ejb:jmp-module09-ear/jmp-module09-ejb/ProjectManagerBean!jmp.module09.ejb.services.project.ProjectManager");
	}

	@Override
	public Response createEmployee(Employee employee) {
		try {
									
			EmployeeManager employeeManager = getEmployeeManager();
			employeeManager.createEmployee(employee);
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (NamingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}

	@Override
	public Response getEmployee(long id) {
		Employee employee = null;
		try {
			
//			final Telephone tel1 = new Telephone();
//			tel1.setTelephoneType(TelephoneType.HOME);
//			tel1.setValue("125566545");
//			
//			final Telephone tel2 = new Telephone();
//			tel2.setTelephoneType(TelephoneType.MOBILE);
//			tel2.setValue("375125655");
//			
//			final Telephone tel3 = new Telephone();
//			tel3.setTelephoneType(TelephoneType.HOME);
//			tel3.setValue("125566545");
//			
//			final Telephone tel4 = new Telephone();
//			tel4.setTelephoneType(TelephoneType.VO_IP);
//			tel4.setValue("12556");
//			
//			Set<Telephone> telephones = new HashSet<Telephone>();
//				telephones.add(tel1);
//				telephones.add(tel2);
//				telephones.add(tel3);
//				telephones.add(tel4);
//			
//			final Address address = new Address();
//			address.setCity("City1");
//			address.setCountry("Contry1");
//			address.setDistrict("District1");
//			address.setTelephones(telephones);
//			
//			Set<Address> addresses = new HashSet<Address>();
//			addresses.add(address);
//				
//			Person person = new Person();
//			person.setAddresses(addresses);
//			person.setBirthDate(new Date());
//			person.setEmail("admin@admin.com");
//			person.setFirstName("Person");
//			person.setLastName("Person lastname");
//			person.setSurName("Person surname");
//			person.setGenre(Genre.M);
//			person.setNationality(Nationality.BE);
//			person.setWorkPlace("GSKTB GA");
//			
//			Employee emp = new Employee();
//			emp.setEmployeeStatus(EmployeeStatus.FULL_TIME);
//			emp.setLastUpdatedDate(new Date());
//			emp.setPerson(person);
			
//			employeeManager.createEmployee(emp);
			
			EmployeeManager employeeManager = getEmployeeManager();
			
			employee = 
					employeeManager.getEmployee(id);
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (NamingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		GenericEntity<Employee> entity = 
				new GenericEntity<Employee>(employee){};
				return Response.ok(entity).build();
	}

	@Override
	public Response getEmployees() {
		List<Employee> employeesList = new ArrayList<Employee>();
		try {
			
//			UnitManager unitManager = getUnitManager();
//			ProjectManager projectManager = getProjectManager();
//			
//			Unit u = unitManager.getUnit(1L);
//			Project p = projectManager.getProject(1L);
//			
			EmployeeManager employeeManager = getEmployeeManager();
//			
//			Employee e = employeeManager.getEmployee(1L);
//			e.setUnit(u);
//			e.getProjects().add(p);
//			
//			employeeManager.updateEmployee(1L, e);
			
			employeesList = employeeManager.list();
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (NamingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		GenericEntity<Employee[]> entity = 
				new GenericEntity<Employee[]>(employeesList.toArray(new Employee[0])){};
				return Response.ok(entity).build();
	}

	@Override
	public Response updateEmployee(long id, Employee employee) {
		try {
			EmployeeManager employeeManager = getEmployeeManager();
			employeeManager.updateEmployee(id, employee);
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (NamingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}

	@Override
	public Response deleteEmployee(long id){
		try {
			EmployeeManager employeeManager = getEmployeeManager();
			employeeManager.deleteEmployee(id);				
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (NamingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}

}
