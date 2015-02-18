package jmp.module14.transaction;

import jmp.module14.data.MemberRepository;
import jmp.module14.data.OrderRepository;
import jmp.module14.data.Resource;
import jmp.module14.data.ResourceManager;
import jmp.module14.data.TicketRepository;
import jmp.module14.transaction.Transaction.TransactionStatus;

public class TransactionManagerImpl implements TransactionManager {
	
	private ResourceManager resourceManager;
	
	public TransactionManagerImpl(boolean useXAProtocol, ResourceManager resourceManager){
		this.resourceManager = resourceManager;
		this.resourceManager.bindResource(new OrderRepository(), useXAProtocol);
		this.resourceManager.bindResource(new TicketRepository(), useXAProtocol);
		this.resourceManager.bindResource(new MemberRepository(), useXAProtocol);
	}

	@Override
	public Transaction begin(@SuppressWarnings("rawtypes") Class type) {
		Transaction transaction = new LocalTransaction(TransactionStatus.PROCCESSED);
		Resource resource = resourceManager.getResource(type);
		transaction.registerResource(resource);
		return transaction;
	}


}
