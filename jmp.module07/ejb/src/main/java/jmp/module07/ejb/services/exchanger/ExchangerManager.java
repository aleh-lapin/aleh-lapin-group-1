package jmp.module07.ejb.services.exchanger;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ExchangerManager {

	void createExchanger(String name);

	void deleteExchanger(int exchangerId);

	void updateExchanger(int exchangerId, String exchangerDefinition);

	List<Exchanger> list();

	Exchanger getExchanger(int id);

}

