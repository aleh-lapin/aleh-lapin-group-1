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
import jmp.module09.jpa.model.Project;

@Path("/projects")
public interface ProjectResource {

	   @POST
	   @Path("create")
	   @Consumes(MediaType.APPLICATION_JSON)
	   public Response createProject(Project project);
	   
	   @GET
	   @Path("{id}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response getProject(@PathParam("id") long id);
	   
	   @GET
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response getProjects();
	   
	   @POST
	   @Path("{id}")
	   @Consumes(MediaType.APPLICATION_JSON)
	   public Response updateProject(@PathParam("id") long id, Project project);
	   
	   @DELETE
	   @Path("{id}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response deleteProject(@PathParam("id") long id);
	   
}
