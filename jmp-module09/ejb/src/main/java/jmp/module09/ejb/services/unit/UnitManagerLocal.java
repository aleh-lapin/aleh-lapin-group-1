package jmp.module09.ejb.services.unit;

import javax.ejb.Local;
import java.util.List;

import jmp.module09.jpa.model.Unit;

@Local
public interface UnitManagerLocal {

	void createUnit(Unit unit);

	void deleteUnit(long unitId);

	void updateUnit(long unitId, Unit unit);

	List<Unit> list();

	Unit getUnit(long unitId);
}
