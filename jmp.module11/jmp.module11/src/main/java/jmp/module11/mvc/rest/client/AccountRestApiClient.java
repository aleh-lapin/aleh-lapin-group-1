package jmp.module11.mvc.rest.client;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import jmp.module11.mvc.domain.Account;
import jmp.module11.mvc.domain.ExchangerType;

@Service("client")
@Scope(value="prototype")
public class AccountRestApiClient implements Client {
	
	private static final String BASE_URI = "http://localhost:8080/account-rest-api/webapi/";
	
	public AccountRestApiClient(){
		
	}
	
	public static void main (String[] args) {
		Client client = new AccountRestApiClient();
		System.out.println(" --- " + client.getAccount(1));
	}

	public int createAccount(Account account) {
		WebTarget webResource = getClient().target(BASE_URI);
		webResource = webResource.path("accounts").path("create");
		Response response = post(webResource, account);
		return response.getStatus();
	}
	
	public int updateAccount(Account account) {
		WebTarget webResource = getClient().target(BASE_URI);
		webResource = webResource.path("accounts").path(Integer.toString(account.getId()));
		Response response = post(webResource, account);
		return response.getStatus();
	}
	
	public List<Account> getAccounts() {
		List<Account> accounts = null;
		GenericType<List<Account>> resultsType = new GenericType<List<Account>>(){};
		WebTarget webResource = getClient().target(BASE_URI);
		webResource = webResource.path("accounts");
		Response response = get(webResource);
		accounts = response.readEntity(resultsType);
		return (accounts != null) ? accounts : Collections.<Account>emptyList();
	}
	
	public Account getAccount(int accountId) {
		Account account = null;
		GenericType<Account> resultsType = new GenericType<Account>(){};
		WebTarget webResource = getClient().target(BASE_URI);
		webResource = webResource.path("accounts").path(Integer.toString(accountId));
		Response response = get(webResource);
		account = response.readEntity(resultsType);
		return account;
	}
	
	public ExchangerType getExchanger() {
		ExchangerType exchanger = null; 
		GenericType<ExchangerType> resultsType = new GenericType<ExchangerType>(){};
		WebTarget webResource = getClient().target(BASE_URI);
		webResource = webResource.path("accounts").path("get_exchanger");
		Response response = get(webResource);
		exchanger = response.readEntity(resultsType);
		return exchanger;
	}
	
	public int updateExchanger(ExchangerType exchanger) {
		WebTarget webResource = getClient().target(BASE_URI);
		webResource = webResource.path("accounts").path("update_exchanger");
		Response response = post(webResource, exchanger);
		return response.getStatus();
	}
	
	public javax.ws.rs.client.Client getClient() {

		ClientConfig cc = new ClientConfig(); 
        
        cc.register(AccountContextResolver.class);
        cc.register(AccountMessageBodyWriter.class);
        cc.register(AccountMessageBodyReader.class);

        cc.property(ClientProperties.JSON_PROCESSING_FEATURE_DISABLE, Boolean.FALSE);
        cc.property(ClientProperties.FOLLOW_REDIRECTS, false); 
        cc.property(ClientProperties.READ_TIMEOUT, 120000); 
        cc.property(ClientProperties.CONNECT_TIMEOUT, 120000);
        javax.ws.rs.client.Client client = ClientBuilder.newClient(cc);
		return client;
	}

	private Response get(WebTarget resource) {

		Response result = null;
		Invocation.Builder endPoint = null;

		try {
			endPoint = resource.request(MediaType.APPLICATION_JSON_TYPE)
					.header(HttpHeaders.ACCEPT_CHARSET, "utf-8");
			result = endPoint.get();        	
		} catch (ClientErrorException e) { 
			int statusCode = e.getResponse().getStatus();
			if ( statusCode == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()
					|| statusCode == Response.Status.GATEWAY_TIMEOUT.getStatusCode()
					|| statusCode == Response.Status.FORBIDDEN.getStatusCode()
					|| statusCode == Response.Status.SERVICE_UNAVAILABLE.getStatusCode()) {
				throw new RuntimeException(e.getMessage());	        		
			} else if (statusCode == Response.Status.UNAUTHORIZED.getStatusCode()
					|| statusCode == Response.Status.METHOD_NOT_ALLOWED .getStatusCode()
					|| statusCode == Response.Status.NOT_ACCEPTABLE.getStatusCode() 
					|| statusCode == Response.Status.NOT_FOUND.getStatusCode()
					|| statusCode == Response.Status.BAD_REQUEST.getStatusCode()) {
				throw new RuntimeException(e.getCause());
			}
		} catch (Exception e) { 
			throw new RuntimeException(e);
		} 
		return result;
	}
	
	private Response post(WebTarget resource, Object body) {

		Response result = null;
		Invocation.Builder endPoint = null;

		try {
			endPoint = resource.request(MediaType.APPLICATION_JSON_TYPE)
					.header(HttpHeaders.ACCEPT_CHARSET, "utf-8");
			result = endPoint.post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));        	
		} catch (ClientErrorException e) { 
			int statusCode = e.getResponse().getStatus();
			if ( statusCode == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()
					|| statusCode == Response.Status.GATEWAY_TIMEOUT.getStatusCode()
					|| statusCode == Response.Status.FORBIDDEN.getStatusCode()
					|| statusCode == Response.Status.SERVICE_UNAVAILABLE.getStatusCode()) {
				throw new RuntimeException(e.getMessage());	        		
			} else if (statusCode == Response.Status.UNAUTHORIZED.getStatusCode()
					|| statusCode == Response.Status.METHOD_NOT_ALLOWED .getStatusCode()
					|| statusCode == Response.Status.NOT_ACCEPTABLE.getStatusCode() 
					|| statusCode == Response.Status.NOT_FOUND.getStatusCode()
					|| statusCode == Response.Status.BAD_REQUEST.getStatusCode()) {
				throw new RuntimeException(e.getCause());
			}
		} catch (Exception e) { 
			throw new RuntimeException(e);
		} 
		return result;
	}

}
