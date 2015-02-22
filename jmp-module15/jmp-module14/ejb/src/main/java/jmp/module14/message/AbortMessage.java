package jmp.module14.message;

public class AbortMessage implements Message {
	
	private static final long serialVersionUID = -6696367957877230751L;
	
	private String resourceType;
	
	@Override
	public MessageType getMessageType() {
		return MessageType.ABORT;
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
