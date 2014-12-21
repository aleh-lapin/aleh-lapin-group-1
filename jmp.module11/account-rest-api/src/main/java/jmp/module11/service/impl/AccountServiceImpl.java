package jmp.module11.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jmp.module11.dao.dto.Account;
import jmp.module11.repository.IAccountRepository;
import jmp.module11.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Lists;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Service("accountService")
@Repository
@Transactional
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(readOnly=true)
	public List<Account> findAll() {
		return Lists.<Account>newArrayList(accountRepository.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public Account findById(Integer id) {
		return accountRepository.findOne(id);
	}

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

}
