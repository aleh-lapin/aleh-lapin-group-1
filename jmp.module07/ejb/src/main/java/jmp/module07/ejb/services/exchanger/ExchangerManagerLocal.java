package jmp.module07.ejb.services.exchanger;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ExchangerManagerLocal {
	
	void createExchanger(String name);

	void deleteExchanger(int exchangerId);

	void updateExchanger(int exchangerId, String exchangerDefinition);

	List<Exchanger> list();
	
	Exchanger getExchanger(int id);
	
}
