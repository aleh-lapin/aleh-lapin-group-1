package jmp.module07.ejb.services.account;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
//import javax.annotation.security.RolesAllowed;
import javax.ejb.*;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

//@ApplicationScoped
@Stateless
//@LocalBean
//@DeclareRoles("bean")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AccountManagerBean implements AccountManager, AccountManagerLocal {
   
	@PersistenceContext
    private EntityManager em;

    //@RolesAllowed("bean")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createAccount(String accountDefinition) {
    	Account account = new Account(accountDefinition);
        em.persist(account);
    }
    
   // @RolesAllowed("bean")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteAccount(int accountId) {
    	Query query = em.createQuery("delete from Account a where a.id = :accountId");
    	query.setParameter("accountId", accountId);
    	query.executeUpdate();
    }
    
   // @RolesAllowed("bean")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateAccount(int accountId, String accountDefinition) {
    	Query query = em.createQuery("update Account a set a.accountDefinition = :accountDefinition" +
    			" where a.id = :accountId");
    	query.setParameter("accountId", accountId);
    	query.setParameter("accountDefinition", accountDefinition);
    	query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
   // @RolesAllowed("bean")
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Account> list() {
        Query query = em.createQuery("from Account");
        List<Account> list = new ArrayList<Account>();
        list.add(new Account());
        //query.getResultList();
        return  query.getResultList();
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Account getAccount(int id) {
    	CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Account> criteria = cb.createQuery(Account.class);
        Root<Account> account = criteria.from(Account.class);
        criteria.select(account).where(cb.equal(account.get("id"), id));
        return em.createQuery(criteria).getSingleResult();
    }
}
