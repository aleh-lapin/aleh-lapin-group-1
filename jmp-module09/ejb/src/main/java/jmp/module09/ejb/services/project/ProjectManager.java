package jmp.module09.ejb.services.project;

import javax.ejb.Remote;
import java.util.List;

import jmp.module09.jpa.model.Project;

@Remote
public interface ProjectManager {
	
void createProject(Project project);
    
    void deleteProject(long projectId);
    
    void updateProject(long projectId, Project project);

    List<Project> list();
    
    Project getProject(long projectId);
}

