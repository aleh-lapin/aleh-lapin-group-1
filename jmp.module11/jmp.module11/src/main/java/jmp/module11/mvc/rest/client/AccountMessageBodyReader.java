package jmp.module11.mvc.rest.client;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import jmp.module11.mvc.domain.*;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.util.VersionUtil;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class AccountMessageBodyReader implements MessageBodyReader<Object>  {
	
	@Context
	private Providers providers;
	
	private Class<?>[] classTypes = {
			List.class,
			Account.class,
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
	
	
	public AccountMessageBodyReader() {
		this.types = new HashSet<Class<?>>(Arrays.asList(classTypes));
	}
	
	public boolean isReadable(Class<?> type, Type genericType, Annotation annotations[], MediaType mediaType) {
		return (types.contains(type)) ? true : false;
	}
	
	@Override
	public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String,String> httpHeaders, InputStream entityStream) throws IOException
	{
		 
		ContextResolver<ObjectMapper> resolver = providers.getContextResolver(ObjectMapper.class, mediaType);
		
		ObjectMapper context = resolver.getContext(type);
		
		configure(context);
		
		JsonDateDeserializer dateDeserializer = new JsonDateDeserializer();
		JsonUriDeserializer uriDeserializer = new JsonUriDeserializer();
				
		SimpleModule dateModule =  new SimpleModule("DateDeserializerModule", VersionUtil.versionFor(type)); 		
		dateModule.addDeserializer(Date.class, dateDeserializer); 
		
		SimpleModule uriModule =  new SimpleModule("UriDeserializerModule", VersionUtil.versionFor(type)); 		
		uriModule.addDeserializer(URI.class, uriDeserializer);
		
		context.registerModule(dateModule);
		context.registerModule(uriModule);	
		
		JsonFactory jsonFactory = context.getJsonFactory();
		
		Object result = null;
		
		try {
			JsonParser jsonParser = jsonFactory.createJsonParser(entityStream);
			result = jsonParser.readValueAs(type);		
		} catch( JsonParseException e) { 
			System.out.println(" Error " + e);
		} catch( IOException e) { 
			System.out.println(" Error " + e);
		}

	    return result;
	}
	
	private void configure(ObjectMapper ctx){
		ctx.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
		ctx.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		ctx.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ctx.configure(DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
		
		ctx.configure(SerializationConfig.Feature.WRITE_EMPTY_JSON_ARRAYS, true);
		ctx.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
		ctx.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
	}
	
}
