package jmp.module12.dto;

import java.io.Serializable;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties
public class Message implements Serializable {

	private static final long serialVersionUID = 246568658731606349L;

	@JsonProperty(value = "subject")
    @Type(value = String.class, name = "subject")
	private String subject;
	
	@JsonProperty(value = "body")
    @Type(value = String.class, name = "body")
	private String body;
	
	@JsonProperty(value = "postDate")
    @Type(value = Date.class, name = "postDate")
	private Date postDate;
	
	@JsonProperty(value = "messageId")
    @Type(value = String.class, name = "messageId")
	private String messageId;
	
	@JsonCreator
	public Message(){
		
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getPostDate() {
		return postDate;
	}

	@JsonDeserialize(using=JsonDateDeserializer.class)
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	
}
