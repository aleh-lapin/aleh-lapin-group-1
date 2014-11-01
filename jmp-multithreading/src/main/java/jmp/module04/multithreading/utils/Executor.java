package jmp.module04.multithreading.utils;

import java.util.Timer;

import org.apache.log4j.Logger;

import jmp.module04.multithreading.dao.AccountDAO;
import jmp.module04.multithreading.dao.AccountDAOImpl;
import jmp.module04.multithreading.service.AccountServiceImpl;
import jmp.module04.multithreading.service.CurrencyType;
import jmp.module04.multithreading.service.Exchanger;
import jmp.module04.multithreading.utils.ExchangeTask;

public class Executor {

	private static final Logger LOG = Logger.getLogger(Executor.class);
	
	private AccountDAO accountDao = new AccountDAOImpl();

	private Timer timer;
	
	private Exchanger exchanger = new Exchanger();
	private AccountServiceImpl accountService = new AccountServiceImpl();

	{
		accountService.setAccountDAO(accountDao);
		accountService.setExchanger(exchanger);
	}
	
	public Executor(){
		ExchangeTask exchangeTask = new ExchangeTask();
    	exchangeTask.setExchanger(exchanger);
    	timer = new Timer();
    	timer.schedule(exchangeTask, 0, 500);
	}
	
	public void execute(String accountId, Double value, String t){
		LOG.info(" Current thread " + Thread.currentThread());
		CurrencyType type = CurrencyType.valueOf(t);
		try {
			LOG.info(" Current credit " + accountService.creditForAccount(accountId));
			LOG.info(" Current debit " + accountService.debitForAccount(accountId));
			LOG.info(" Current ballance " + accountService.getBallanceForAccount(accountId));
			accountService.creditForAccount(accountId, value, type);
			accountService.debitForAccount(accountId, value, type);
			accountService.exchangeCreditForAccount(accountId, type);
			accountService.exchangeDebitForAccount(accountId, type);
			accountService.exchangeBallanceForAccount(accountId, type);
			LOG.info(" New credit " + accountService.creditForAccount(accountId));
			LOG.info(" New debit " + accountService.debitForAccount(accountId));
			LOG.info(" New ballance " + accountService.getBallanceForAccount(accountId));		
		} catch (Exception e) {
			LOG.equals(e);
		}
	}
	
	public void close(){
		timer.cancel();
	}

}
