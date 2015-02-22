package jmp.module14.message;

public class PreparationMessage implements Message {

	private static final long serialVersionUID = 4340076197992456659L;
	
	private String resourceType;
	
	@Override
	public MessageType getMessageType() {
		return MessageType.PREPARE;
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
