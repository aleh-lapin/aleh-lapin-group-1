package jmp.module14.transaction;

import jmp.module14.data.Resource;

public interface Transaction {
	
	enum TransactionStatus {
		PRISTINE, ABORTED, FINISHED, PROCCESSED, COMMITED;
	}
	
	void commit();
	void rollback();
	void registerResource(Resource resource);
	TransactionStatus getStatus();
	long getTimeout();

}
