package jmp.module14.transaction;

public interface TransactionManager {
	
	Transaction begin(Class<?> type);

}
