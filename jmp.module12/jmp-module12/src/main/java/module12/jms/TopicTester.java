package module12.jms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import jmp.module12.dto.Message;

public class TopicTester {
	
	private TopicConnection tConnect = null;    
	private TopicSession tSession = null;
	private Topic topic = null;
	private Context ic = null;

	public void test(Map<String, String> parameters) throws Exception
	{
		String destinationName = "TestTopic";

		TopicConnectionFactory cf = null;

		try {         
			ic = getInitialContext();
			cf = (TopicConnectionFactory)ic.lookup("jms/RemoteConnectionFactory");
			topic = (Topic)ic.lookup(destinationName);
			tConnect = cf.createTopicConnection("pavel", "vikS601.");
			tSession = (TopicSession)tConnect.createSession(false, Session.AUTO_ACKNOWLEDGE);
			TopicPublisher publisher = tSession.createPublisher(topic);
			tConnect.start();
			Message messageEnvelope = new Message();
			messageEnvelope.setBody(parameters.get("body"));
			messageEnvelope.setSubject(parameters.get("subject"));
			ObjectMessage message = tSession.createObjectMessage();
			message.setObject(messageEnvelope);
			message.setStringProperty("subscriberName", parameters.get("subscriberName"));
			publisher.publish(message);
			System.out.println("Message sent!");

		} catch(JMSException e) {
			  e.printStackTrace(); 
			  System.exit(1);
		}
	}
	
	public void exit() {      
		try {
			if (tConnect != null) {
				tConnect.close();
			}
			ic.close();
		}
		catch(JMSException jmse) {
			System.out.println("Could not close connection " + tConnect +" exception was " + jmse);
		} catch (NamingException ce) {
			System.out.println("Could not close context " + ic +" exception was " + ce);
		}
		System.exit(0);
	}

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		try {
			Map<String, String> parameters = new HashMap<String, String>(){
				{
					put("subject", null);
					put("body", null);
					put("subscriberName", null);
				}
			};
			TopicTester tester = new TopicTester();
			try {
				BufferedReader stdin = new BufferedReader
						(new InputStreamReader(System.in));
				System.out.println ("TopicTester Application Started");
				System.out.println ("Press enter to quit application");
				while (true) {
					for(String parameter : parameters.keySet()) {
						System.out.println ("Enter: " + parameter);
						System.out.print("> ");    
						String param = stdin.readLine();
						if (param == null || param.trim().length() <= 0) {
							tester.exit();
						} else {
							parameters.put(parameter, param.trim());
						}
					}
					tester.test(parameters);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Context getInitialContext( )
			throws javax.naming.NamingException {
		Hashtable<String, String> p = new Hashtable<String, String>();
		p.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jboss.naming.remote.client.InitialContextFactory");
		p.put(Context.PROVIDER_URL, "remote://localhost:4447");
		p.put(InitialContext.SECURITY_PRINCIPAL, "pavel");
		p.put(InitialContext.SECURITY_CREDENTIALS, "vikS601.");
		return new javax.naming.InitialContext(p);
	}

}
