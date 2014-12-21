package jmp.module11.utils;

public interface IGenerator {
	
	
	void configure();
	
	<T> T next(Class<T> clazz);
	
	<T> T next();

}
