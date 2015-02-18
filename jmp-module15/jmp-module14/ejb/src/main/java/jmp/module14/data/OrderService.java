package jmp.module14.data;

import java.util.Collection;
import javax.ejb.Local;
import jmp.module14.model.Member;
import jmp.module14.model.Ticket;

@Local
public interface OrderService {
	
	void order(String ticketId, Long amount);
	Collection<Ticket> getTickets();
	Member getMember();
	Ticket getTicket(String ticketId);

}
