package jmp.module11.mvc.rest.client;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import jmp.module11.mvc.domain.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.SerializationConfig;

@Provider
public class AccountContextResolver implements ContextResolver<ObjectMapper> {

	private ObjectMapper ctx;
	private Class<?>[] classTypes = {
			Account.class,
			List.class,
			Accounts.class,
			Address.class,
			Currency.class,
			CurrencyType.class,
			ExchangerType.class,
			Genre.class,
			Nationality.class,
			Person.class,
			Telephone.class,
			Telephones.class,
			Account[].class,
			Currency[].class,
			String[].class,
			Telephone[].class,
			TelephoneType.class
	};

	private Set<Class<?>> types;

	public  AccountContextResolver( ) {
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
