package jmp.module07.ejb.services.exchanger;

//import javax.annotation.security.DeclareRoles;
//import javax.annotation.security.RolesAllowed;
import javax.ejb.*;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

import jmp.module07.ejb.services.account.Account;

//@ApplicationScoped
@Stateless
//@DeclareRoles("bean")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ExchangerManagerBean implements ExchangerManager, ExchangerManagerLocal {
	
	@PersistenceContext
    private EntityManager em;

   // @RolesAllowed("bean")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createExchanger(String exchangerDefinition) {
    	Exchanger exchanger = new Exchanger(exchangerDefinition);
        em.persist(exchanger);
    }
    
   // @RolesAllowed("bean")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteExchanger(int exchangerId) {
    	Query query = em.createQuery("delete from Exchanger a where a.id = :exchangerId");
    	query.setParameter("exchangerId", exchangerId);
    	query.executeUpdate();
    }
    
   // @RolesAllowed("bean")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateExchanger(int exchangerId, String exchangerDefinition) {
    	Query query = em.createQuery("update Exchanger a set a.exchangerDefinition = :exchangerDefinition" +
    			" where a.id = :exchangerId");
    	query.setParameter("exchangerId", exchangerId);
    	query.setParameter("exchangerDefinition", exchangerDefinition);
    	query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    //@RolesAllowed("bean")
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Exchanger> list() {
        Query query = em.createQuery("from Exchanger");
        return query.getResultList();
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Exchanger getExchanger(int id) {
    	CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Exchanger> criteria = cb.createQuery(Exchanger.class);
        Root<Exchanger> exchanger = criteria.from(Exchanger.class);
        criteria.select(exchanger).where(cb.equal(exchanger.get("id"), id));
        return em.createQuery(criteria).getSingleResult();
    }
}
