package jmp.module07.ejb.restapi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import jmp.module07.ejb.restapi.persistent.Account;
import jmp.module07.ejb.restapi.persistent.Currency;
import jmp.module07.ejb.restapi.persistent.CurrencyType;
import jmp.module07.ejb.restapi.persistent.ExchangerType;
import jmp.module07.ejb.services.account.AccountManager;
import jmp.module07.ejb.services.exchanger.ExchangerManager;

public class AccountResourceService implements AccountResource {


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

	private AccountManager getAccountManager() throws NamingException, IOException {
		return (AccountManager) getContext().lookup("ejb:jmp.module07-ear/jmp.module07-ejb/AccountManagerBean!jmp.module07.ejb.services.account.AccountManager");
	}
	
	private ExchangerManager getExchangerManager() throws NamingException, IOException {
		return (ExchangerManager) getContext().lookup("ejb:jmp.module07-ear/jmp.module07-ejb/ExchangerManagerBean!jmp.module07.ejb.services.exchanger.ExchangerManager");
	}

	@Override
	public Response createAccount(Account account) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			AccountManager accountManager = getAccountManager();
			String accountDefinition = null;
			accountDefinition = objectMapper.writeValueAsString(account);
			accountManager.createAccount(accountDefinition);
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
	public Response getAccount(int id) {
		ObjectMapper objectMapper = new ObjectMapper();
		Account account = null;
		try {
			AccountManager accountManager = getAccountManager();
			jmp.module07.ejb.services.account.Account accountEntity = 
					accountManager.getAccount(id);
			account = objectMapper.readValue(accountEntity.getAccountDefinition(), Account.class);
			account.setID(accountEntity.getId());
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (NamingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		GenericEntity<Account> entity = 
				new GenericEntity<Account>(account){};
				return Response.ok(entity).build();
	}

	@Override
	public Response getAccounts() {

		ObjectMapper objectMapper = new ObjectMapper();
		List<Account> accountsList = new ArrayList<Account>();
		try {
			AccountManager accountManager = getAccountManager();
			List<jmp.module07.ejb.services.account.Account> accounts = accountManager.list();

			for(jmp.module07.ejb.services.account.Account acc : accounts) {
				Account account;

				account = objectMapper.readValue(acc.getAccountDefinition(), Account.class);
				account.setID(acc.getId());
				accountsList.add(account);
			}
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (NamingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		GenericEntity<Account[]> entity = 
				new GenericEntity<Account[]>(accountsList.toArray(new Account[0])){};
				return Response.ok(entity).build();

	}

	@Override
	public Response updateAccount(int id, Account account) {
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			AccountManager accountManager = getAccountManager();
			String accountDefinition = null;
			accountDefinition = objectMapper.writeValueAsString(account);
			accountManager.updateAccount(id, accountDefinition);

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
	public Response getExchanger(){
		ObjectMapper objectMapper = new ObjectMapper();
		ExchangerType exchanger = null;
		try {
			ExchangerManager exchangerManager = getExchangerManager();
			jmp.module07.ejb.services.exchanger.Exchanger exchangerEntity = 
					exchangerManager.getExchanger(1);
			exchanger = objectMapper.readValue(exchangerEntity.getExchangerDefinition(), ExchangerType.class);				
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (NamingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
				
		GenericEntity<ExchangerType> entity = 
				new GenericEntity<ExchangerType>(exchanger){};
				return Response.ok(entity).build();
	}


	public Response updateExchanger(ExchangerType exchanger){
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			ExchangerManager exchangerManager = getExchangerManager();
			String exchangerDefinition = null;
			exchangerDefinition = objectMapper.writeValueAsString(exchanger);
			exchangerManager.updateExchanger(1, exchangerDefinition);
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
