package jmp.module14.message;

import java.io.Serializable;

public interface Message extends Serializable {
	
	enum MessageType {
		PREPARE, COMMIT, ABORT;
	}
	
	MessageType getMessageType();
	String getResourceType();
	void setResourceType(String resourceType);

}
