package jmp.module14.message;

public class CommitMessage  implements Message {

	@Override
	public MessageType getMessageType() {
		return MessageType.COMMIT;
	}

}
