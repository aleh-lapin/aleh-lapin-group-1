package jmp.module09.ejb.services.handlers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import jmp.module09.jpa.model.*;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.util.VersionUtil;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class UMessageBodyWriter extends JacksonJsonProvider {

	private static final Logger LOG = Logger.getLogger(UMessageBodyWriter.class);
	
	@Context
	private Providers providers;
	
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
	
	public UMessageBodyWriter() {
		this.types = new HashSet<Class<?>>(Arrays.asList(classTypes));
	}
	
	@Override
	public long getSize(Object arg0, Class<?> arg1, Type arg2,
			Annotation[] arg3, MediaType arg4) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		ObjectOutputStream dataStream = null;
		Long size = 0L;
		try {
			dataStream = new ObjectOutputStream(byteStream);
			dataStream.writeObject(arg0);
			size += byteStream.toByteArray().length;
		} catch (IOException e) {
			LOG.error("Serialization error", e);
		} finally {
			if (dataStream != null){
				try {
					dataStream.close();
				} catch (IOException e) {
					LOG.error("Close stream error", e);
				}
			}
		}
		
		return size;
	}

	@Override
	public boolean isWriteable(Class<?> arg0, Type arg1, Annotation[] arg2,
			MediaType arg3) {
		System.out.println(" ---------------- ");
		return types.contains(arg0);
	}

	@Override
	public void writeTo(Object arg0, Class<?> type, Type arg2,
			Annotation[] arg3, MediaType arg4,
			MultivaluedMap<String, Object> arg5, OutputStream arg6)
			throws IOException, WebApplicationException {
		
		ContextResolver<ObjectMapper> resolver = providers.getContextResolver(ObjectMapper.class, arg4);
		
		ObjectMapper context = resolver.getContext(type);
		
		configure(context);
		
		JsonDateSerializer dateSerializer = new JsonDateSerializer();
		
		SimpleModule dateModule =  new SimpleModule("DateSerializerModule", VersionUtil.versionFor(type)); 		
		dateModule.addSerializer(Date.class, dateSerializer); 
		
		context.registerModule(dateModule);
		
		JsonFactory jsonFactory = context.getJsonFactory();
				
		try {
			JsonGenerator jsonGenerator = jsonFactory.createJsonGenerator(arg6);
			jsonGenerator.writeObject(arg0);	
		} catch( IOException e) { 
			LOG.error("JSON parse exception", e); 
		}
		
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
