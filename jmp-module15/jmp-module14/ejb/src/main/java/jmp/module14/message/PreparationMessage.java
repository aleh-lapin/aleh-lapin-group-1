package jmp.module14.message;

public class PreparationMessage implements Message {

	@Override
	public MessageType getMessageType() {
		return MessageType.PREPARE;
	}

}
