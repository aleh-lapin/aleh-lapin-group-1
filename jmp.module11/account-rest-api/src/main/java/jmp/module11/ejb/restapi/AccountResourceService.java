package jmp.module11.ejb.restapi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import jmp.module11.ejb.restapi.persistent.Account;
import jmp.module11.ejb.restapi.persistent.Currency;
import jmp.module11.ejb.restapi.persistent.CurrencyType;
import jmp.module11.ejb.restapi.persistent.ExchangerType;
import jmp.module11.service.IAccountService;
import jmp.module11.service.IExchangerService;

public class AccountResourceService implements AccountResource {

	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private IExchangerService exchangerService;
	
	@Override
	public Response createAccount(Account account) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String accountDefinition = null;
			accountDefinition = objectMapper.writeValueAsString(account);
			accountService.save(new jmp.module11.dao.dto.Account(accountDefinition));
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}

	@Override
	public Response getAccount(int id) {
		ObjectMapper objectMapper = new ObjectMapper();
		Account account = null;
		try {
			jmp.module11.dao.dto.Account accountEntity = 
					accountService.findById(id);
			account = objectMapper.readValue(accountEntity.getAccountDefinition(), Account.class);
			account.setID(accountEntity.getId());
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
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
			List<jmp.module11.dao.dto.Account> accounts = accountService.findAll();

			for(jmp.module11.dao.dto.Account acc : accounts) {
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
		}
		GenericEntity<Account[]> entity = 
				new GenericEntity<Account[]>(accountsList.toArray(new Account[0])){};
				return Response.ok(entity).build();
	}
	
	private Map<CurrencyType, Double> getCourses() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<CurrencyType, Double> courses = new HashMap<CurrencyType, Double>();
		ExchangerType exchanger = null;
		CurrencyType basicCurrency = null;
		jmp.module11.dao.dto.Exchanger dtoExchanger = 
				exchangerService.findById(1);
		exchanger = objectMapper.readValue(dtoExchanger.getExchangerDefinition(), ExchangerType.class);
		basicCurrency = exchanger.getBasiccurrency();
		for(Currency c : exchanger.getCourse()) {
			if (!basicCurrency.equals(c.getCurr())) {
				courses.put(c.getCurr(), c.getValue().doubleValue());
			}
		}
		courses.put(basicCurrency, 1D);
		return courses;
	}

	@Override
	public Response updateAccount(int id, Account account) {
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			String accountDefinition = null;
			int accountId = account.getID();
			
			if (accountId > 0) {
				Account newAccount = null;
				jmp.module11.dao.dto.Account prevAccount = accountService.findById(accountId);
				if (prevAccount != null) {
					Account acc = objectMapper.readValue(prevAccount.getAccountDefinition(), Account.class);
					Map<CurrencyType, Double> courses = getCourses();
					newAccount = compareAndGet(account, acc, courses);
					
				}
				accountDefinition = objectMapper.writeValueAsString((newAccount != null) ? newAccount :account);
				jmp.module11.dao.dto.Account dtoAccount = new jmp.module11.dao.dto.Account(accountDefinition);
				dtoAccount.setId(accountId);
				accountService.save(dtoAccount);
			}

		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}
	
	private Account compareAndGet(Account newAccount, Account oldAccount, Map<CurrencyType, Double> courses) {
		Double baseNCredit = newAccount.getCredit().getValue().doubleValue() * courses.get(newAccount.getCredit().getCurr());
		Double baseOCredit = oldAccount.getCredit().getValue().doubleValue() * courses.get(oldAccount.getCredit().getCurr());
		
		Double baseNDebit = newAccount.getDebit().getValue().doubleValue() * courses.get(newAccount.getDebit().getCurr());
		Double baseODebit = oldAccount.getDebit().getValue().doubleValue() * courses.get(oldAccount.getDebit().getCurr());
		
		Double baseBallance = (baseODebit - baseNCredit) / (1 / courses.get(newAccount.getBallance().getCurr()));
		
		newAccount.getBallance().setValue(BigDecimal.valueOf(baseBallance));
		
		if (newAccount.getCredit().getCurr().equals(oldAccount.getCredit().getCurr())) {
			baseNCredit = baseNCredit * (1 / courses.get(oldAccount.getCredit().getCurr()));
			newAccount.getCredit().setValue(BigDecimal.valueOf(baseNCredit));
		} else {
			baseNCredit = baseNCredit * (1 / courses.get(newAccount.getCredit().getCurr()));
			newAccount.getCredit().setValue(BigDecimal.valueOf(baseNCredit));
		}
		
		if (newAccount.getDebit().getCurr().equals(oldAccount.getDebit().getCurr())) {
			baseNDebit = baseNDebit * (1 / courses.get(oldAccount.getDebit().getCurr()));
			newAccount.getDebit().setValue(BigDecimal.valueOf(baseNDebit));
		} else {
			baseNDebit = baseNDebit * (1 / courses.get(newAccount.getDebit().getCurr()));
			newAccount.getDebit().setValue(BigDecimal.valueOf(baseNDebit));
		}
		return newAccount;
	}

	@Override
	public Response getExchanger(){
		ObjectMapper objectMapper = new ObjectMapper();
		ExchangerType exchanger = null;
		try {
			jmp.module11.dao.dto.Exchanger dtoExchanger = 
					exchangerService.findById(1);
			exchanger = objectMapper.readValue(dtoExchanger.getExchangerDefinition(), ExchangerType.class);
			exchanger.setLastDateUpdated(dtoExchanger.getLastModifiedDate());
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}				
		GenericEntity<ExchangerType> entity = 
				new GenericEntity<ExchangerType>(exchanger){};
				return Response.ok(entity).build();
	}

	public Response updateExchanger(ExchangerType exchanger){
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String exchangerDefinition = null;
			exchangerDefinition = objectMapper.writeValueAsString(exchanger);
			jmp.module11.dao.dto.Exchanger dtoExchanger = new jmp.module11.dao.dto.Exchanger(exchangerDefinition);
			dtoExchanger.setLastModifiedDate(new Date());
			dtoExchanger.setId(1);
			exchangerService.save(dtoExchanger);
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} 
		return Response.ok().build();
	}

}
