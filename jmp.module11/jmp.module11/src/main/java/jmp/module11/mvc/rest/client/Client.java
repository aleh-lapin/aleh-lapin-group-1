package jmp.module11.mvc.rest.client;

import java.util.List;
import jmp.module11.mvc.domain.Account;
import jmp.module11.mvc.domain.ExchangerType;


public interface Client {
	
	public int createAccount(Account account) ;
	
	public int updateAccount(Account account);
	
	public List<Account> getAccounts();
	
	public Account getAccount(int accountId);
	
	public ExchangerType getExchanger();
	
	public int updateExchanger(ExchangerType exchanger);
	
	public javax.ws.rs.client.Client getClient();

}
