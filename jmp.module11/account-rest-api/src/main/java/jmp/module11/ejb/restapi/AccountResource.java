package jmp.module11.ejb.restapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jmp.module11.ejb.restapi.persistent.Account;
import jmp.module11.ejb.restapi.persistent.ExchangerType;

@Path("/accounts")
public interface AccountResource {

	
	   @POST
	   @Path("create")
	   @Consumes(MediaType.APPLICATION_JSON)
	   public Response createAccount(Account account);
	   
	   @GET
	   @Path("{id}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response getAccount(@PathParam("id") int id);
	   
	   @GET
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response getAccounts();
	   
	   @POST
	   @Path("{id}")
	   @Consumes(MediaType.APPLICATION_JSON)
	   public Response updateAccount(@PathParam("id") int id, Account account);
	   
	   @GET
	   @Path("get_exchanger")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response getExchanger();
	   
	   @POST
	   @Path("update_exchanger")
	   @Consumes(MediaType.APPLICATION_JSON)
	   public Response updateExchanger(ExchangerType exchanger);
	   
}
