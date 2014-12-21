package jmp.module11.mvc.rest.client;

import java.io.IOException;
import java.net.URI;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;


public class JsonUriDeserializer extends JsonDeserializer<URI> {
	 @Override
	 public URI deserialize(JsonParser jsonparser,
	            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

	    String uriString = jsonparser.getText();	        
	    try {
	        return URI.create(uriString);
	    } catch (Exception e) {
	         throw new RuntimeException(e);
	    }
	}
}
