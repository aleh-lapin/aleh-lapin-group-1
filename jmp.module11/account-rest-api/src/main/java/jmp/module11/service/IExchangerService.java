package jmp.module11.service;

import java.util.List;
import jmp.module11.dao.dto.Exchanger;

public interface IExchangerService {
	
	public List<Exchanger> findAll();
	
	public Exchanger findById(Integer id);
	
	public Exchanger save(Exchanger exchanger);	

}
