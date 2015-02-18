package jmp.module14.message;

public class AbortMessage implements Message {

	@Override
	public MessageType getMessageType() {
		return MessageType.ABORT;
	}

}
