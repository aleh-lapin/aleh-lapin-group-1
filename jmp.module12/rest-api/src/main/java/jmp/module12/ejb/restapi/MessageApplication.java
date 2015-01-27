package jmp.module12.ejb.restapi;

//import java.util.HashSet;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class MessageApplication extends ResourceConfig  {

	private static final Logger LOG = Logger.getLogger(MessageApplication.class);
	
	public MessageApplication() {
		register(RequestContextFilter.class);
		register(MessageContextResolver.class);
		register(MessageMessageBodyReader.class);
		register(MessageMessageBodyWriter.class);
		register(MessageResourceService.class);
	}

//	public Set<Class<?>> getClasses() {
//		Set<Class<?>> set = new HashSet<Class<?>>();
//		set.add(AccountContextResolver.class);
//		set.add(AccountMessageBodyReader.class);
//		set.add(AccountMessageBodyWriter.class);
//		set.add(AccountResource.class);
//		return set;
//	}

	/*public Set<Object> getSingletons() {
		HashSet<Object> set = new HashSet<Object>();
		try {
			InitialContext ctx = new InitialContext();
			Object accountService = ctx.lookup(
					"java:global/account-rest-api/AccountResourceService!jmp.module07.ejb.restapi.AccountResource");
			set.add(accountService);
		} catch (Exception ex) {
			LOG.error("Deployment error", ex);
		}
		return set;
	}*/

}
