package jmp.module14.data;

import java.util.Collection;

public interface ResourceManager {
	
	void bindResource(Resource resource, boolean useXAProtocol);
	Collection<Resource> enlistResource();
	Resource getResource(Class<?> type);
	IRepository getRepository(Class<?> type);

}
