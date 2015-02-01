package jmp.module12.ejb.restapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/subscribers")
public interface MessageResource {
	   
	   @GET
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response getSubscribers();
	   
	   @GET
	   @Path("create")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response createSubscriber();
	   
}
