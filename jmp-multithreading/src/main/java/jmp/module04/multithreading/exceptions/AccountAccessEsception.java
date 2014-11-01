package jmp.module04.multithreading.exceptions;

public class AccountAccessEsception extends Exception {
	
	private static final long serialVersionUID = 4998786836252221381L;

	public AccountAccessEsception(Exception e) {
		super("Cannot access this account..", e);
	}

}
