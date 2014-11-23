package jmp.module07.ejb.services.account;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface AccountManager {
	
    void createAccount(String accountDefinition);
    
    void deleteAccount(int accountId);
    
    void updateAccount(int accountId, String accountDefinition);

    List<Account> list();
    
    Account getAccount(int id);
}

