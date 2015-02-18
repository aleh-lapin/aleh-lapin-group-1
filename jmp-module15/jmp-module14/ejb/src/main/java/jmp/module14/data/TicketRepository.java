package jmp.module14.data;

import java.util.Collection;

import jmp.module14.data.Resource.ResourceState;
import jmp.module14.model.Ticket;

public class TicketRepository extends UnitDaoImpl<Ticket> implements IRepository<Ticket>, Resource {
	
	private ResourceState state;
	
	public TicketRepository () {
		super(new Class<?>[]{Ticket.class, Ticket[].class});
//		Ticket t1 = new Ticket();
//		t1.setAmount(20);
//		t1.setPrice(20.0D);
//		t1.setSeat("2E");
//		t1.setDescription("First ticket description");
//		Ticket t2 = new Ticket();
//		t2.setAmount(60);
//		t2.setPrice(35.0D);
//		t2.setSeat("3E");
//		t2.setDescription("Second ticket description");
//		Ticket [] tickets = {t1, t2};
//		for(Ticket ticket : tickets) {
//			this.pushEntity(ticket);
//		}
	}
	
	public static void main(String[] args) {
		System.out.println(1);
		IRepository<Ticket> repository = new TicketRepository();
		Ticket t1 = new Ticket();
		t1.setAmount(20);
		t1.setPrice(20.0D);
		t1.setSeat("2E");
		t1.setDescription("First ticket description");
		Ticket t2 = new Ticket();
		t2.setAmount(60);
		t2.setPrice(35.0D);
		t2.setSeat("3E");
		t2.setDescription("Second ticket description");
		Ticket [] tickets = {t2, t1};
		for(Ticket ticket : tickets) {
			repository.pushEntity(ticket);
		}
		
		
		
		Ticket t3 = repository.obtainEntity("2");
		
		System.out.println(1 + t3.getDescription());
		t3.setDescription("new");
		repository.modifyEntity(t3);
		
		
		Ticket t4 = repository.obtainEntity("2");
		repository.destroyEntity(t2);
//		
		System.out.println(1 + t4.getDescription());
		
		//repository.destroyEntity(t3);
		for(Ticket t : repository.watchEntities()) {
			System.out.println(t.getDescription());
		}
	}

	@Override
	public void pushEntity(Ticket element) {
		insert(element);
	}

	@Override
	public Ticket obtainEntity(String expression) {
		return read(expression);
	}

	@Override
	public Ticket modifyEntity(Ticket element) {
		return update(element);
	}

	@Override
	public void destroyEntity(Ticket element) {
		delete(element);
	}

	@Override
	public Collection<Ticket> watchEntities() {
		return list();
	}

	@Override
	public String getName() {
		return getClass().getSimpleName();
	}

	@Override
	public void prepare() {
		state = ResourceState.PREPARED;
		cacheItem();
	}

	@Override
	public void commit() {
		state = ResourceState.COMMITED;
		clearCache();
	}

	@Override
	public void recover() {
		state = ResourceState.RECOVERED;
		restoreCacheItem();
	}

	@Override
	public ResourceState getState() {
		return state;
	}
	
	@Override
	public void setState(ResourceState state) {
		this.state = state;		
	}

}
