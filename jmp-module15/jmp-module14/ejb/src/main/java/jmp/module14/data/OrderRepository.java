package jmp.module14.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jmp.module14.data.Resource.ResourceState;
import jmp.module14.model.Order;
import jmp.module14.model.Ticket;
import jmp.module14.model.Order.OrderStatus;


public class OrderRepository extends UnitDaoImpl<Order> implements IRepository<Order>, Resource {

	private ResourceState state;
	
	public OrderRepository () {
		super(new Class<?>[]{Order.class, Order[].class});
	}
	
	public static void main(String[] args) {
		System.out.println(1);
		
		Ticket t1 = new Ticket();
		t1.setAmount(20);
		t1.setPrice(20.0D);
		t1.setSeat("45E");
		t1.setDescription("description");
		
		List<Long> orders = new ArrayList<Long>();
		orders.add(t1.getIdentity());
		Map<Class<?>, List<Long>> units = new HashMap<Class<?>, List<Long>>();
		units.put(Ticket.class, orders);
		
		
		Order o1 = new Order();

		o1.setOrderDate(new Date());
		o1.setStatus(OrderStatus.ACCEPTED);
		o1.setUnits(units);
		
		IRepository<Order> repository = new OrderRepository();
		repository.pushEntity(o1);
		Order t2 = repository.obtainEntity("1");
		System.out.println(t2.getStatus());
		//repository.destroyEntity(t2);
		for(Order t : repository.watchEntities()) {
			System.out.println(2+ "" + t.getStatus());
		}
		
	}

	@Override
	public void pushEntity(Order element) {
		insert(element);
	}

	@Override
	public Order obtainEntity(String expression) {
		return read(expression);
	}

	@Override
	public Order modifyEntity(Order element) {
		return update(element);
	}

	@Override
	public void destroyEntity(Order element) {
		delete(element);
	}

	@Override
	public Collection<Order> watchEntities() {
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
