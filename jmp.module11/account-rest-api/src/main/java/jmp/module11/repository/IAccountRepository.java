package jmp.module11.repository;

import jmp.module11.dao.dto.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepository extends CrudRepository<Account, Integer> {

}
