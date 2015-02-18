package jmp.module14.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import jmp.module14.model.Member;
import jmp.module14.model.Order;
import jmp.module14.model.Order.OrderStatus;
import jmp.module14.model.Ticket;
import jmp.module14.transaction.CompositeTransaction;
import jmp.module14.transaction.Transaction;
import jmp.module14.transaction.TransactionManager;
import jmp.module14.transaction.TransactionManagerImpl;

@Stateless
public class OrderServiceImpl implements OrderService {
	
	private ResourceManager resourceManager;
	private TransactionManager transactionManager;
	private IRepository orderRepository;
	private IRepository  ticketRepository;
	private IRepository memberRepository;
	
	public OrderServiceImpl() {
		this.resourceManager = new ResourceManagerImpl();
		this.transactionManager = new TransactionManagerImpl(true, resourceManager);
		this.orderRepository = resourceManager.getRepository(OrderRepository.class);
		this.ticketRepository = resourceManager.getRepository(TicketRepository.class);
		this.memberRepository = resourceManager.getRepository(MemberRepository.class);
	}
	
	@PostConstruct
	public void init() {
		Ticket t1 = new Ticket();
		t1.setAmount(20);
		t1.setPrice(20.0D);
		t1.setSeat("");
		t1.setDescription("First ticket description");
		Ticket t2 = new Ticket();
		t2.setAmount(60);
		t2.setPrice(35.0D);
		t2.setSeat("");
		t2.setDescription("Second ticket description");
		Ticket [] tickets = {t1, t2};
		for(Ticket ticket : tickets) {
			ticketRepository.pushEntity(ticket);
		}
		Member m1 = new Member();
		m1.setBallance(200.0D);
		m1.setEmail("admin@admin.com");
		m1.setName("Person1");
		m1.setOrderCount(0L);
		m1.setPhoneNumber("3578670");
		memberRepository.pushEntity(m1);
	}
	
	public void order(String ticketId, Long amount) {
		
		Double ballance = 0D;		
		Member member = (Member)memberRepository.obtainEntity("1");
		Ticket ticket = (Ticket)ticketRepository.obtainEntity(ticketId);
		Double totalCost = (amount != null && (ticket.getAmount() - amount) >= 0) ? ticket.getPrice() * amount : 0D;
		
		if (totalCost > 0 && (ballance = (member.getBallance() - totalCost)) >= 0) {
			CompositeTransaction transaction = new CompositeTransaction();
			Order order = new Order();
			order.setAmount(totalCost);
			order.setOrderDate(new Date());
			order.setStatus(OrderStatus.ACCEPTED);
			List<Long> orders = new ArrayList<Long>();
			orders.add(ticket.getIdentity());
			Map<Class<?>, List<Long>> units = new HashMap<Class<?>, List<Long>>();
			units.put(Ticket.class, orders);
			order.setUnits(units);
			Transaction t1 = transactionManager.begin(OrderRepository.class);
			orderRepository.pushEntity(order);
			
			long orderCount = member.getOrderCount();
			member.setOrderCount(++orderCount);
			member.setBallance(ballance);
			Transaction t2 = transactionManager.begin(MemberRepository.class);
			memberRepository.modifyEntity(member);
			
			int newAmount = ticket.getAmount() - amount.intValue();
			ticket.setAmount(newAmount);
			Transaction t3 = transactionManager.begin(TicketRepository.class);
			ticketRepository.modifyEntity(ticket);
			
			transaction.startTransaction(t1, t2, t3);
			
		}
		
		
		
		System.out.println(((Member)memberRepository.obtainEntity("1")).getPhoneNumber());
		
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Ticket> getTickets() {
		return (Collection<Ticket>)ticketRepository.watchEntities();
	}
	
	public Member getMember() {
		return (Member)memberRepository.obtainEntity("1");
	}
	
	public Ticket getTicket(String ticketId) {
		return (Ticket)ticketRepository.obtainEntity(ticketId);
	}
	
//	public static void main(String[] args) {
//		OrderServiceImpl orderService = new OrderServiceImpl();
//		orderService.order("1", 2L);
//	}

}
