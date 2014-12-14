package jmp.module09.ejb.services.handlers;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import jmp.module09.jpa.model.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.SerializationConfig;

@Provider
public class UContextResolver implements ContextResolver<ObjectMapper> {

	private ObjectMapper ctx;
	private Class<?>[] classTypes = {
			Address.class,
			Employee.class,
			EmployeeStatus.class,
			Genre.class,
			Nationality.class,
			Person.class,
			Project.class,
			Telephone.class,
			TelephoneType.class,
			Unit.class,
			UnitType.class
	};

	private Set<Class<?>> types;

	public  UContextResolver( ) {
		configure();
		this.types = new HashSet<Class<?>>(Arrays.asList(classTypes));
	}

	private void configure(){
		ctx = new ObjectMapper();
		ctx.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
		ctx.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		ctx.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ctx.configure(DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
		
		ctx.configure(SerializationConfig.Feature.WRITE_EMPTY_JSON_ARRAYS, true);
		ctx.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
		ctx.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
	}

	public ObjectMapper getContext(Class<?> objectType) {
		return (types.contains(objectType)) ? ctx : null;
	}

}
