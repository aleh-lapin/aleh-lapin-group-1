package jmp.module11.ejb.restapi;

import java.io.IOException;
import jmp.module11.ejb.restapi.persistent.TelephoneType;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class JsonTelephoneTypeDeserializer extends JsonDeserializer<TelephoneType> {
	 @Override
	 public TelephoneType deserialize(JsonParser jsonparser,
	            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

	    String telephoneTypeString = jsonparser.getText();	        
	    try {
	        return TelephoneType.fromValue(telephoneTypeString);
	    } catch (Exception e) {
	    	return TelephoneType.valueOf(telephoneTypeString);
	    }
	}
}
