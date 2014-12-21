package jmp.module11.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Lists;
import jmp.module11.dao.dto.Exchanger;
import jmp.module11.repository.IExchangerRepository;
import jmp.module11.service.IExchangerService;

@Service("exchangerService")
@Repository
@Transactional
public class ExchangerServiceImpl implements IExchangerService {

	@Autowired
	private IExchangerRepository exchangerRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(readOnly=true)
	public List<Exchanger> findAll() {
		return Lists.<Exchanger>newArrayList(exchangerRepository.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public Exchanger findById(Integer id) {
		return exchangerRepository.findOne(id);
	}

	@Override
	public Exchanger save(Exchanger exchanger) {
		return exchangerRepository.save(exchanger);
	}

}
