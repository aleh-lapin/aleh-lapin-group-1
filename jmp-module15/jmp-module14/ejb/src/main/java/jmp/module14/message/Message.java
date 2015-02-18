package jmp.module14.message;

public interface Message {
	
	enum MessageType {
		PREPARE, COMMIT, ABORT;
	}
	
	MessageType getMessageType();

}
