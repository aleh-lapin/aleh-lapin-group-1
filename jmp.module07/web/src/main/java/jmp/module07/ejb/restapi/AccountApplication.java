package jmp.module07.ejb.restapi;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import org.apache.log4j.Logger;

public class AccountApplication extends Application  {
	
	public AccountApplication() {

	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<Class<?>>();
//		set.add(AccountContextResolver.class);
//		set.add(AccountMessageBodyReader.class);
//		set.add(AccountMessageBodyWriter.class);
//		set.add(AccountResourceService.class);
		
		return set;
	}

	public Set<Object> getSingletons() {
		HashSet<Object> set = new HashSet<Object>();
		set.add(new AccountContextResolver());
		set.add(new AccountMessageBodyReader());
		set.add(new AccountMessageBodyWriter());
		set.add(new AccountResourceService());
		return set;
	}

}
