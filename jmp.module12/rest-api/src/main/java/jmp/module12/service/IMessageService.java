package jmp.module12.service;

import java.util.List;

import javax.jms.JMSException;

import jmp.module12.dto.Subscriber;

public interface IMessageService {
	
	void createSubscriber() throws JMSException;
	
	List<Subscriber> getSubscribers() ;

}
