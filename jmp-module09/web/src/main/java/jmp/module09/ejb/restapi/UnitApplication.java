package jmp.module09.ejb.restapi;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import jmp.module09.ejb.services.handlers.UContextResolver;
import jmp.module09.ejb.services.handlers.UMessageBodyReader;
import jmp.module09.ejb.services.handlers.UMessageBodyWriter;

public class UnitApplication extends Application  {
	
	public UnitApplication() {

	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		return set;
	}

	public Set<Object> getSingletons() {
		HashSet<Object> set = new HashSet<Object>();
		set.add(new UContextResolver());
		set.add(new UMessageBodyReader());
		set.add(new UMessageBodyWriter());
		set.add(new UnitResourceService());
		set.add(new ProjectResourceService());
		set.add(new EmployeeResourceService());
		return set;
	}

}
