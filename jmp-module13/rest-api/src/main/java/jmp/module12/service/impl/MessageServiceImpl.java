package jmp.module12.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import jmp.module12.dto.Subscriber;
import jmp.module12.service.IMessageService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jms.TopicConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Service("messageService")
public class MessageServiceImpl implements IMessageService {

	private static final Logger LOG = Logger.getLogger(MessageServiceImpl.class);

	private static AtomicLong counter = new AtomicLong(0);

	private static Map<String, Subscriber> subscribers = new ConcurrentHashMap<String, Subscriber>();

	private static Map<String, TopicSession> topicSubscribers = new ConcurrentHashMap<String, TopicSession>();

	private TopicConnection connection;

	private TopicConnectionFactory connectionFactory;

	private Topic topic;
	
	public Context getInitialContext()
			throws NamingException {
		Hashtable<String, String> p = new Hashtable<String, String>();
		p.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jboss.naming.remote.client.InitialContextFactory");
		p.put(Context.PROVIDER_URL, "remote://localhost:4447");
		p.put(InitialContext.SECURITY_PRINCIPAL, "pavel");
		p.put(InitialContext.SECURITY_CREDENTIALS, "vikS601.");
		return new javax.naming.InitialContext(p);
	} 

	@PostConstruct
	public void init() throws JMSException, NamingException {
		Context context = getInitialContext();
		connectionFactory = (TopicConnectionFactory)context.lookup("jms/RemoteConnectionFactory");
		topic = (Topic)context.lookup("TestTopic");
		connection = (TopicConnection)connectionFactory.createTopicConnection("pavel", "vikS601.");
		connection.setClientID("clientId");
	}

	public void createSubscriber() throws JMSException {

		TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		String subscriberName = "Subscriber#" + counter.incrementAndGet();
		String selector = "subscriberName = '" + subscriberName + "'";
		TopicSubscriber subscriber = session.createDurableSubscriber(topic, subscriberName, selector, false);
		subscriber.setMessageListener(new MessageServiceListener());
		Subscriber s = new Subscriber();
		s.setName(subscriberName);
		subscribers.put(subscriberName, s);
		connection.start();

	}

	public List<Subscriber> getSubscribers() {
		List<Subscriber> subscribersList = new ArrayList<Subscriber>();
		subscribersList.addAll(subscribers.values());
		return subscribersList;
	}

	public void exit() {
		try {
			for(Map.Entry<String, TopicSession> entry : topicSubscribers.entrySet()) {
				entry.getValue().unsubscribe(entry.getKey());
			}
			connection.close();
		} catch (JMSException jmse) {
			LOG.error(jmse);
		}
	}

	private static class MessageServiceListener implements MessageListener {

		@Override
		public void onMessage(Message message) {
			ObjectMessage objectMessage = (ObjectMessage)message;

			String subscriberName = null;
			try {
				subscriberName = objectMessage.getStringProperty("subscriberName");
			} catch (JMSException e) {
				LOG.error("Cannot obtain subscriber name property.", e);
			}
			Subscriber subscriber = subscribers.get((subscriberName != null) ? subscriberName : "");
			if (subscriber != null){
				jmp.module12.dto.Message m;
				try {
					m = (jmp.module12.dto.Message)objectMessage.getObject();
					m.setMessageId(objectMessage.getJMSMessageID());
					m.setPostDate(new Date(objectMessage.getJMSTimestamp()));
					subscriber.getMessages().add(m);
				} catch (JMSException e) {
					LOG.error("Cannot cast message object.", e);
				}
			}
		}

	}

	public TopicConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(TopicConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
