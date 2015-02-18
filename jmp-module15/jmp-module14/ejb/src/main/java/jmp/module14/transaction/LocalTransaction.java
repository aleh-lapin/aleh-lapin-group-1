package jmp.module14.transaction;

import java.util.Observable;
import java.util.Observer;

import jmp.module14.data.Resource;
import jmp.module14.message.Message;

public class LocalTransaction implements Transaction, Observer {
	
	private TransactionStatus status = TransactionStatus.PRISTINE;
	
	private Resource resource;
	
	private long timeout;
	
	private Thread localThread;
	
	public LocalTransaction(TransactionStatus status) {
		this.status = status;
	}

	@Override
	public void commit() {
		status = TransactionStatus.COMMITED;
		resource.commit();
	}

	@Override
	public void rollback() {
		status = TransactionStatus.ABORTED;
		resource.recover();
	}

	@Override
	public void registerResource(Resource resource) {
		this.resource = resource;
	}

	@Override
	public TransactionStatus getStatus() {
		return status;	
	}

	@Override
	public long getTimeout() {
		return timeout;
	}

	@Override
	public void update(Observable observe, Object arg) {
		Message message = (Message)arg;
		switch(message.getMessageType()){
			case PREPARE:
				localThread = new Thread() {
					@Override
					public void run(){
						while(getStatus().equals(TransactionStatus.PROCCESSED)) {
							try {
								System.out.println(" status " + resource.getState());
								Thread.sleep(100);
								switch(resource.getState())
								{
									case COMMITED:
										status = TransactionStatus.COMMITED;
										break;
									case RECOVERED:
										status = TransactionStatus.ABORTED;
										break;
									default: break;
								}
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				};
				break;
			case ABORT:
				System.out.println(" revert ");
				resource.recover();
				break;
			case COMMIT:
				if (localThread != null)
					localThread.start();
				break;
			default:
				break;
		}
		
	}

}
