package jmp.module14.data;

import java.util.Collection;

public interface IRepository<T> {
	
	void pushEntity(T element);
	T obtainEntity(String expression);
	T modifyEntity(T element);
	void destroyEntity(T element);
	Collection<T> watchEntities();

}
