package jmp.module14.transaction;

public class CompositeTransaction {
		
	private Coordinator coordinator;
	
	public CompositeTransaction() {
		coordinator = new Coordinator();
	}
	
	public void startTransaction(Transaction... transactions) {
		for(Transaction transaction : transactions) {
			coordinator.addTransaction(transaction);
		}
		coordinator.prepare();
		coordinator.commit();
	}
	
}
