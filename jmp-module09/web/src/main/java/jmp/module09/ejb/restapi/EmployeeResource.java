package jmp.module09.ejb.restapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jmp.module09.jpa.model.Employee;

@Path("/employees")
public interface EmployeeResource {

	   @POST
	   @Path("create")
	   @Consumes(MediaType.APPLICATION_JSON)
	   public Response createEmployee(Employee employee);
	   
	   @GET
	   @Path("{id}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response getEmployee(@PathParam("id") long id);
	   
	   @GET
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response getEmployees();
	   
	   @POST
	   @Path("{id}")
	   @Consumes(MediaType.APPLICATION_JSON)
	   public Response updateEmployee(@PathParam("id") long id, Employee employee);
	   
	   @DELETE
	   @Path("{id}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response deleteEmployee(@PathParam("id") long id);
	   
}
