package jmp.module11.service;

import java.util.List;
import jmp.module11.dao.dto.Account;

public interface IAccountService {
	
	public List<Account> findAll();
	
	public Account findById(Integer id);
	
	public Account save(Account account);	

}
