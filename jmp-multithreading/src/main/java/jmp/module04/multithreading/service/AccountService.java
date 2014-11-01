package jmp.module04.multithreading.service;

import jmp.module04.multithreading.exceptions.AccountAccessEsception;

import org.w3c.dom.Node;

public interface AccountService {
	
	Double getBallanceForAccount(String accountId) throws AccountAccessEsception;
	
	Double creditForAccount(String accountId) throws AccountAccessEsception;
	
	Double debitForAccount(String accountId) throws AccountAccessEsception;
	
	void creditForAccount(String accountId, Double value, CurrencyType type) throws AccountAccessEsception;
	
	void debitForAccount(String accountId, Double value, CurrencyType type) throws AccountAccessEsception;
	
	void exchangeBallanceForAccount(String accountId, CurrencyType type) throws AccountAccessEsception;
	
	void exchangeCreditForAccount(String accountId, CurrencyType type) throws AccountAccessEsception;
	
	void exchangeDebitForAccount(String accountId, CurrencyType type) throws AccountAccessEsception;
	
	void deleteAccount(String accountId) throws AccountAccessEsception;
	
	void insertAccount(Node account) throws AccountAccessEsception;

}
