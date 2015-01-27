package jmp.module12.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

@JsonIgnoreProperties
public class Subscriber implements Serializable {
	
	private static final long serialVersionUID = -1446173043733104811L;

	@JsonProperty(value = "name")
    @Type(value = String.class, name = "name")
	private String name;
	
	@JsonProperty(value = "messages")
    @Type(value = List.class, name = "messages")
	private List<Message> messages = new ArrayList<Message>();
	
	@JsonCreator
	public Subscriber() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
