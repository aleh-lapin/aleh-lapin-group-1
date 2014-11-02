package jmp.module05.testing;

import org.w3c.dom.Node;

import jmp.module05.testing.dao.AccountDAO;
import jmp.module05.testing.dao.AccountDAOImpl;
import jmp.module05.testing.exceptions.DaoException;
import jmp.module05.testing.service.AccountServiceImpl;
import jmp.module05.testing.service.Exchanger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Exchanger exchanger = new Exchanger();
        AccountDAO accountDao = new AccountDAOImpl();
        AccountServiceImpl accountService = new AccountServiceImpl();
		accountService.setAccountDAO(accountDao);
		accountService.setExchanger(exchanger);
		
		try {
			Node account = accountDao.deleteAccount("11");
			account.getClass();
			System.out.println(account.getAttributes().getNamedItem("ID").getNodeValue());
			account = accountDao.getAccount("11");
			account.getClass();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
    }
}
