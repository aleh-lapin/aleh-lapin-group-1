package jmp.module04.multithreading.exceptions;

public class DaoException extends Exception {
	
	private static final long serialVersionUID = 4998786836252221381L;

	public DaoException(Exception e) {
		super("Cannot modify account..", e);
	}
		
}
