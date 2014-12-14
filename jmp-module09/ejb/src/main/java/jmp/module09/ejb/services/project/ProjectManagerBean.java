package jmp.module09.ejb.services.project;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jmp.module09.jpa.model.Project;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProjectManagerBean implements ProjectManager, ProjectManagerLocal {
   
	@PersistenceContext
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createProject(Project project) {
        em.persist(project);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteProject(long projectId) {
    	Query query = em.createQuery("delete from Project p where p.id = :projectId");
    	query.setParameter("projectId", projectId);
    	query.executeUpdate();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateProject(long projectId, Project project) {
    	Project currProject = em.find(Project.class, projectId);
    	if (currProject ==null) {
    		throw new IllegalArgumentException("Non-existant employee identity");
    	}
    	em.merge(project);
    }

    @SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Project> list() {
		Query query = em.createQuery("from Project p");
        List<Project> list = new ArrayList<Project>();
        list = query.getResultList();
        return (list != null) ? list : Collections.<Project>emptyList();
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Project getProject(long projectId) {
    	Project project = em.createNamedQuery("Project.findByIdWithDetails", Project.class)
    		.setParameter("projectId", projectId).getSingleResult();
        return project;
    }
}
