package jmp.module09.ejb.services.unit;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jmp.module09.jpa.model.Unit;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UnitManagerBean implements UnitManager, UnitManagerLocal {
   
	@PersistenceContext
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createUnit(Unit unit) {
        em.persist(unit);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteUnit(long unitId) {
    	Query query = em.createQuery("delete from Unit u where u.id = :unitId");
    	query.setParameter("unitId", unitId);
    	query.executeUpdate();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateUnit(long unitId, Unit unit) {
    	Unit currUnit = em.find(Unit.class, unitId);
    	if (currUnit ==null) {
    		throw new IllegalArgumentException("Non-existant unit identity");
    	}
    	em.merge(unit);
    }

	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Unit> list() {
        Query query = em.createQuery("from Unit u");
        List<Unit> list = new ArrayList<Unit>();
        list = query.getResultList();
        return (list != null) ? list : Collections.<Unit>emptyList();
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Unit getUnit(long unitId) {
    	Unit unit = em.createNamedQuery("Unit.findByIdWithDetails", Unit.class)
    		.setParameter("unitId", unitId).getSingleResult();
        return unit;
    }
}
