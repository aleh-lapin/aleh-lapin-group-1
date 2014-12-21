package jmp.module11.repository;

import org.springframework.data.repository.CrudRepository;
import jmp.module11.dao.dto.Exchanger;

public interface IExchangerRepository extends CrudRepository<Exchanger, Integer> {

}
