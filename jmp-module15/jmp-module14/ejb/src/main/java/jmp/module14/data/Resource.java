package jmp.module14.data;

public interface Resource {
	
	enum ResourceState {
		PREPARED, COMMITED, RECOVERED;
	}
	
	String getName();
	void prepare();
	void commit();
	void recover();
	ResourceState getState();
	void setState(ResourceState state);
	
	
}
