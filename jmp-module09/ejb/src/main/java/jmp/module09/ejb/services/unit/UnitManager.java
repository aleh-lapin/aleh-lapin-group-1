package jmp.module09.ejb.services.unit;

import javax.ejb.Remote;
import java.util.List;

import jmp.module09.jpa.model.Unit;

@Remote
public interface UnitManager {
	
    void createUnit(Unit unit);
    
    void deleteUnit(long unitId);
    
    void updateUnit(long unitId, Unit unit);

    List<Unit> list();
    
    Unit getUnit(long unitId);
}

