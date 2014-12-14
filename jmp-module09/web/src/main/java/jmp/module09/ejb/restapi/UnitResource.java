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
import jmp.module09.jpa.model.Unit;

@Path("/units")
public interface UnitResource {

	   @POST
	   @Path("create")
	   @Consumes(MediaType.APPLICATION_JSON)
	   public Response createUnit(Unit unit);
	   
	   @GET
	   @Path("{id}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response getUnit(@PathParam("id") long id);
	   
	   @GET
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response getUnits();
	   
	   @POST
	   @Path("{id}")
	   @Consumes(MediaType.APPLICATION_JSON)
	   public Response updateUnit(@PathParam("id") long id, Unit unit);
	   
	   @DELETE
	   @Path("{id}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response deleteUnit(@PathParam("id") long id);
	   
}
