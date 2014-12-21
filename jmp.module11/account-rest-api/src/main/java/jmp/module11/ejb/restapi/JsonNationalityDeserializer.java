package jmp.module11.ejb.restapi;

import java.io.IOException;
import jmp.module11.ejb.restapi.persistent.Nationality;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class JsonNationalityDeserializer extends JsonDeserializer<Nationality> {
	 @Override
	 public Nationality deserialize(JsonParser jsonparser,
	            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

	    String nationalityString = jsonparser.getText();	        
	    try {
	        return Nationality.valueOf(nationalityString.toUpperCase());
	    } catch (Exception e) {
	         throw new RuntimeException(e);
	    }
	}
}
