package jmp.module07.ejb.services.account;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AccountManagerLocal {
	
    void createAccount(String accountDefinition);
    
    void deleteAccount(int accountId);
    
    void updateAccount(int accountId, String accountDefinition);

    List<Account> list();
    
    Account getAccount(int id);
}
