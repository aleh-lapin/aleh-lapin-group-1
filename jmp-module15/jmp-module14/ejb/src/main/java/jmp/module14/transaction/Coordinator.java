package jmp.module14.transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import jmp.module14.message.AbortMessage;
import jmp.module14.message.CommitMessage;
import jmp.module14.message.PreparationMessage;
import jmp.module14.transaction.Transaction.TransactionStatus;

public class Coordinator extends Observable {
	
	private static final int INIT_DELAY = 500;
	
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	public Coordinator() {
		
	}
	
	public void addTransaction(Transaction transaction) {
		synchronized(transactions){
			transactions.add(transaction);
			addObserver((Observer)transaction);
		}
	}
	
	public void prepare() {
		setChanged();
		notifyObservers(new PreparationMessage());
	}
	
	public void commit() {
		TransactionStatus status = null;
		setChanged();
		notifyObservers(new CommitMessage());
		synchronized(transactions){
			while(transactions.size() > 0) {
				Iterator<Transaction> iterator = transactions.iterator();
				while(iterator.hasNext()) {
					status = iterator.next().getStatus();
					if (status.equals(TransactionStatus.ABORTED)) {
						abort();
						transactions.clear();
						deleteObservers();
						break;
					} else if (status.equals(TransactionStatus.COMMITED)) {
						iterator.remove();;
					}
				}
			}
		}
	}
	
	public void abort() {
		setChanged();
		notifyObservers(new AbortMessage());
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
		
}
