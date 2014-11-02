package jmp.module05.testing;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import jmp.module05.testing.dao.AccountDAO;
import jmp.module05.testing.dao.AccountDAOImpl;
import jmp.module05.testing.exceptions.DaoException;
import jmp.module05.testing.service.AccountService;
import jmp.module05.testing.service.AccountServiceImpl;
import jmp.module05.testing.service.Exchanger;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

@RunWith(JUnit4.class)
public class AppTest 
{

	private Exchanger exchanger;

	private AccountDAO accountDao;

	private AccountServiceImpl accountService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void init() {
		exchanger = new Exchanger();
		accountDao = new AccountDAOImpl();
		accountService = new AccountServiceImpl();
		accountService.setAccountDAO(accountDao);
		accountService.setExchanger(exchanger);
	}

	@Test
	public void selectTest() throws DaoException
	{
		final String accountId = "11";
		Node account = accountDao.getAccount(accountId);
		assertThat(account, is(checkAccountNode(accountId)));
	}

	public Matcher<Node> checkAccountNode(final String accountId) {
		return new BaseMatcher<Node>() {
			public boolean matches(Object candidate) {
				if (!(candidate instanceof Node)) {
					return false;
				}

				NamedNodeMap attrs = ((Node) candidate).getAttributes();
				
				return "Account".equals(((Node) candidate).getLocalName()) &&
						attrs.getNamedItem("ID") != null 
						&& accountId.equals(attrs.getNamedItem("ID").getNodeValue());
			}

			public void describeTo(Description desc) {
				desc.appendText("Incorrect account selection ");
			}
		};
	}
	
	@Test
	public void deleteTest() throws DaoException, NullPointerException
	{
		thrown.expect(NullPointerException.class);
		final String accountId = "12";
		Node account = accountDao.deleteAccount(accountId);
		assertThat(account, is(checkAccountNode(accountId)));
		account = accountDao.getAccount(accountId);
		account.getAttributes();
	}

}
