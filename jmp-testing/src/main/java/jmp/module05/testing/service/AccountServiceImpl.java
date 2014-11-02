package jmp.module05.testing.service;

import java.math.BigDecimal;
import java.util.Calendar;
import org.w3c.dom.Node;
import jmp.module05.testing.dao.AccountDAO;
import jmp.module05.testing.dao.AccountDAOImpl;
import jmp.module05.testing.exceptions.AccountAccessEsception;
import jmp.module05.testing.exceptions.DaoException;
import jmp.module05.testing.utils.SchemaLoader;
import jmp.module05.testing.utils.XmlProcessor;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAO = new AccountDAOImpl();

	private Exchanger exchanger = new Exchanger();

	private final SchemaLoader schemaLoader;

	private final XmlProcessor processor;

	public AccountServiceImpl(){
		schemaLoader = new SchemaLoader(); 
		schemaLoader.addSchema("/Account.xsd");
		processor = new XmlProcessor(schemaLoader);
	}

	private com.jmpClassloadin.xml.bind.accounts.Account account(String accountId)  throws DaoException {
		com.jmpClassloadin.xml.bind.accounts.Account accountObject = null;
		Node account = accountDAO.getAccount(accountId);		
		com.jmpClassloadin.xml.bind.accounts.AccountsDocument doc = (com.jmpClassloadin.xml.bind.accounts.AccountsDocument)
				processor.parse(account.getParentNode()).changeType(
						com.jmpClassloadin.xml.bind.accounts.AccountsDocument.type);
		com.jmpClassloadin.xml.bind.accounts.Account[] accounts = doc.getAccounts().getAccountArray();

		for(com.jmpClassloadin.xml.bind.accounts.Account act : accounts) {
			if (accountId.equalsIgnoreCase(""+act.getID())) {
				accountObject = act;
				break;
			}
		}
		accountObject.setLastUpdatedDate(Calendar.getInstance());
		return accountObject;
	}

	public Double getBallanceForAccount(String accountId) throws AccountAccessEsception {
		Double ballance = null;
		com.jmpClassloadin.xml.bind.accounts.Account accountObject;
		try {
			accountObject = account(accountId);
		} catch (DaoException e) {
			throw new AccountAccessEsception(e);
		}
		ballance = accountObject.getCredit().getBigDecimalValue().doubleValue() - 
				accountObject.getDebit().getBigDecimalValue().doubleValue();
		return ballance;
	}

	public Double creditForAccount(String accountId) throws AccountAccessEsception {
		Double credit = null;
		com.jmpClassloadin.xml.bind.accounts.Account accountObject;
		try {
			accountObject = account(accountId);
		} catch (DaoException e) {
			throw new AccountAccessEsception(e);
		}
		credit = accountObject.getCredit().getBigDecimalValue().doubleValue();
		return credit;
	}

	public Double debitForAccount(String accountId) throws AccountAccessEsception {
		Double debit = null;
		com.jmpClassloadin.xml.bind.accounts.Account accountObject;
		try {
			accountObject = account(accountId);
		} catch (DaoException e) {
			throw new AccountAccessEsception(e);
		}
		debit = accountObject.getDebit().getBigDecimalValue().doubleValue();
		return debit;
	}

	public void creditForAccount(String accountId, Double value,
			CurrencyType type) throws AccountAccessEsception {
		com.jmpClassloadin.xml.bind.accounts.Account accountObject;
		try {
			accountObject = account(accountId);
		} catch (DaoException e1) {
			throw new AccountAccessEsception(e1);
		}
		CurrencyType currType = CurrencyType.valueOf(accountObject.getCredit().getCurr().toString());
		Double currCredit = 0D;
		if (!type.equals(currType)) {
			double currentCourse = exchanger.getCourse(currType.getType());
			double convertedCourse = exchanger.getCourse(type.getType());
			double ratio = currentCourse / convertedCourse;
			currCredit = creditForAccount(accountId) * ratio;
			currCredit += (value != null) ? value : 0D;
			currCredit /= ratio;
		} else {
			currCredit += (value != null) ? value : 0D;
		}
		accountObject.getCredit().setBigDecimalValue(BigDecimal.valueOf(currCredit));
		try {
			accountDAO.updateAccount(accountId, accountObject.getDomNode());
		} catch (DaoException e) {
			throw new AccountAccessEsception(e);
		}
	}

	public void debitForAccount(String accountId, Double value,
			CurrencyType type) throws AccountAccessEsception {
		com.jmpClassloadin.xml.bind.accounts.Account accountObject;
		try {
			accountObject = account(accountId);
		} catch (DaoException e1) {
			throw new AccountAccessEsception(e1);
		}
		CurrencyType currType = CurrencyType.valueOf(accountObject.getCredit().getCurr().toString());
		Double currDebit = 0D;
		if (!type.equals(currType)) {
			double currentCourse = exchanger.getCourse(currType.getType());
			double convertedCourse = exchanger.getCourse(type.getType());
			double ratio = currentCourse / convertedCourse;
			currDebit = debitForAccount(accountId) * ratio;
			currDebit += (value != null) ? value : 0D;
			currDebit /= ratio;
		} else {
			currDebit += (value != null) ? value : 0D;
		}
		accountObject.getDebit().setBigDecimalValue(BigDecimal.valueOf(currDebit));
		try {
			accountDAO.updateAccount(accountId, accountObject.getDomNode());
		} catch (DaoException e) {
			throw new AccountAccessEsception(e);
		}
	}

	public void exchangeBallanceForAccount(String accountId, CurrencyType type) throws AccountAccessEsception {
		exchangeCreditForAccount(accountId, type);
		exchangeDebitForAccount(accountId, type);
		com.jmpClassloadin.xml.bind.accounts.Account accountObject;
		try {
			accountObject = account(accountId);
		} catch (DaoException e1) {
			throw new AccountAccessEsception(e1);
		}
		Double ballance = getBallanceForAccount(accountId);
		accountObject.getBallance().setBigDecimalValue(BigDecimal.valueOf(ballance));
		try {
			accountDAO.updateAccount(accountId, accountObject.getDomNode());
		} catch (DaoException e) {
			throw new AccountAccessEsception(e);
		}
	}

	public void exchangeCreditForAccount(String accountId, CurrencyType type) throws AccountAccessEsception {
		com.jmpClassloadin.xml.bind.accounts.Account accountObject;
		try {
			accountObject = account(accountId);
		} catch (DaoException e1) {
			throw new AccountAccessEsception(e1);
		}
		CurrencyType currType = CurrencyType.valueOf(accountObject.getCredit().getCurr().toString());
		Double currCredit = 0D;
		if (!type.equals(currType)) {
			double currentCourse = exchanger.getCourse(currType.getType());
			double convertedCourse = exchanger.getCourse(type.getType());
			double ratio = currentCourse / convertedCourse;
			currCredit = creditForAccount(accountId) * ratio;
		} else {
			currCredit = creditForAccount(accountId);
		}
		accountObject.getCredit().setCurr(
				com.jmpClassloadin.xml.bind.currency.CurrencyType.Enum.forString(
						type.getType()));
		accountObject.getCredit().setBigDecimalValue(BigDecimal.valueOf(currCredit));
		try {
			accountDAO.updateAccount(accountId, accountObject.getDomNode());
		} catch (DaoException e) {
			throw new AccountAccessEsception(e);
		}
	}

	public void exchangeDebitForAccount(String accountId, CurrencyType type) throws AccountAccessEsception {
		com.jmpClassloadin.xml.bind.accounts.Account accountObject;
		try {
			accountObject = account(accountId);
		} catch (DaoException e1) {
			throw new AccountAccessEsception(e1);
		}
		CurrencyType currType = CurrencyType.valueOf(accountObject.getCredit().getCurr().toString());
		Double currDebit = 0D;
		if (!type.equals(currType)) {
			double currentCourse = exchanger.getCourse(currType.getType());
			double convertedCourse = exchanger.getCourse(type.getType());
			double ratio = currentCourse / convertedCourse;
			currDebit = creditForAccount(accountId) * ratio;
		} else {
			currDebit = creditForAccount(accountId);
		}
		accountObject.getDebit().setCurr(
				com.jmpClassloadin.xml.bind.currency.CurrencyType.Enum.forString(
						type.getType()));
		accountObject.getDebit().setBigDecimalValue(BigDecimal.valueOf(currDebit));
		try {
			accountDAO.updateAccount(accountId, accountObject.getDomNode());
		} catch (DaoException e) {
			throw new AccountAccessEsception(e);
		}
	}

	public void deleteAccount(String accountId) throws AccountAccessEsception {
		try {
			accountDAO.deleteAccount(accountId);
		} catch (DaoException e) {
			throw new AccountAccessEsception(e);
		}
	}

	public void insertAccount(Node account) throws AccountAccessEsception {
		try {
			accountDAO.insertAccount(account);
		} catch (DaoException e) {
			throw new AccountAccessEsception(e);
		}
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public Exchanger getExchanger() {
		return exchanger;
	}

	public void setExchanger(Exchanger exchanger) {
		this.exchanger = exchanger;
	}

}
