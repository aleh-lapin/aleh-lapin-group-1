package jmp.module09.ejb.services.project;

import javax.ejb.Local;
import java.util.List;

import jmp.module09.jpa.model.Project;

@Local
public interface ProjectManagerLocal {
	
    void createProject(Project project);
    
    void deleteProject(long projectId);
    
    void updateProject(long projectId, Project project);

    List<Project> list();
    
    Project getProject(long projectId);
}
