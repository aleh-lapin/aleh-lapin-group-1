package jmp.module09.ejb.services.handlers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class JsonDateSerializer extends JsonSerializer<Date> {

	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		System.out.println(" ---------------- " + date);
		String dateString = null;
		try{
			dateString = format.format(date);
		} catch(Exception e) {
			dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
		}
		jsonGenerator.writeString(dateString);
	}

}
