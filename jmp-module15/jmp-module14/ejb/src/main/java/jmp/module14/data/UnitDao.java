package jmp.module14.data;

import java.util.Collection;

public interface UnitDao<T> {
	
	void insert(T object);
	T read(String id);
	T update(T object);
	void delete(T object);
	Collection<T> list();


}
