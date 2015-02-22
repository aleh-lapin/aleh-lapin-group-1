package jmp.module14.message;

public class CommitMessage  implements Message {
	
	private static final long serialVersionUID = -1112179444714727533L;
	
	private String resourceType;

	@Override
	public MessageType getMessageType() {
		return MessageType.COMMIT;
	}

	@Override
	public String getResourceType() {
		return resourceType;
	}
	
	@Override
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

}
