package jmp.module09.ejb.services.handlers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class JsonDateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jsonparser,
            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = jsonparser.getText();
        Date d = new Date();
        try {
            d = format.parse(date);
        } catch (ParseException e) {
        	try {
				d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch (ParseException e1) {
				throw new RuntimeException(e1);
			}
        }
        return d;
    }
}
