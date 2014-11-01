package jmp.module04.multithreading.dao;

import jmp.module04.multithreading.exceptions.DaoException;

import org.w3c.dom.Node;

public interface AccountDAO {
	
	void insertAccount(Node newNode) throws DaoException;
	Node updateAccount(String accountId, Node value) throws DaoException;
	Node deleteAccount(String accountId) throws DaoException;
	Node getAccount(String accountId) throws DaoException;

}
