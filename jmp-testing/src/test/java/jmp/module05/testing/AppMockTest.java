package jmp.module05.testing;

import static org.junit.Assert.*;
import jmp.module05.testing.service.CurrencyType;
import jmp.module05.testing.dao.AccountDAO;
import jmp.module05.testing.dao.AccountDAOImpl;
import jmp.module05.testing.exceptions.DaoException;
import jmp.module05.testing.service.AccountService;
import jmp.module05.testing.service.AccountServiceImpl;
import jmp.module05.testing.service.Exchanger;
import org.jmock.Expectations;                              
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;                
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;
import org.junit.runner.RunWith;

@SuppressWarnings("deprecation")
@RunWith( JMock.class ) 
public class AppMockTest {

	private Exchanger exchanger;

	private AccountDAO accountDao;

	private AccountServiceImpl accountService;


	//	 private Mockery context = new JUnit4Mockery();             
	//	                   
	//	    @Before
	//	    public void setUp()
	//	    {
	//	    	accountService = context.mock( AccountService.class );    
	//	    }

	private Mockery context = new JUnit4Mockery()             
	{                                                               
		{                                                           
			setImposteriser( ClassImposteriser.INSTANCE );          
		}                                                           
	};  
	
	@Before
    public void doBefore() {
		 accountDao = new AccountDAOImpl();
		 exchanger = new Exchanger();
		 accountService = new AccountServiceImpl();
		 accountService.setExchanger(exchanger);
    }

	@Test
	public void testGetAccount() throws Exception
	{

		final AccountDAOImpl  accountDao= context.mock( AccountDAOImpl.class );  

		context.checking( new Expectations()
		{
			{
				//oneOf( accountService ).creditForAccount("10", new Double(200), CurrencyType.EU);
				oneOf( accountDao ).getAccount("10");
				will( returnValue( getNode() ) );                            
			}
		} );
		accountService.setAccountDAO(accountDao);
		double credit = accountService.creditForAccount("10");
		assertEquals( 10000D, credit , .01); 
	}
	
	private Node getNode() throws DaoException {
		return accountDao.getAccount("10");
	}


}
