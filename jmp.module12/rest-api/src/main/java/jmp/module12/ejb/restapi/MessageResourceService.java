package jmp.module12.ejb.restapi;

import java.util.List;
import javax.jms.JMSException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import jmp.module12.dto.Subscriber;
import jmp.module12.service.IMessageService;

public class MessageResourceService implements MessageResource {

	@Autowired
	private IMessageService messageService;
		
	@Override
	public Response getSubscribers() {
		List<Subscriber> subscribers = messageService.getSubscribers();
		GenericEntity<Subscriber[]> entity = 
				new GenericEntity<Subscriber[]>(subscribers.toArray(new Subscriber[0])){};
				return Response.ok(entity).build();
	}
	
	@Override
	public Response createSubscriber() {
		try {
			messageService.createSubscriber();
		} catch (JMSException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}

	public IMessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}
	
}
