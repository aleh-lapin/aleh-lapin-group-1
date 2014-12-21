package jmp.module11.ejb.restapi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;


public class JsonDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = format.format(date);
		jsonGenerator.writeString(dateString);
	}

}
