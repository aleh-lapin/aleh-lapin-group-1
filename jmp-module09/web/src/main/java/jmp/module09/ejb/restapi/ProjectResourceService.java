package jmp.module09.ejb.restapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import jmp.module09.ejb.services.project.ProjectManager;
import jmp.module09.jpa.model.Project;

public class ProjectResourceService implements ProjectResource {

	private Context getContext() throws NamingException {
		Hashtable<String, Object> p = new Hashtable<String, Object>();
		p.put("jboss.naming.client.ejb.context", true);
		p.put(Context.PROVIDER_URL, "remote://localhost:4447");
		p.put(InitialContext.SECURITY_PRINCIPAL, "user");
		p.put(InitialContext.SECURITY_CREDENTIALS, "vikS601.");
		//p.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT", "false");
		final Context context = new InitialContext(p);

		return context;
	}

	private ProjectManager getProjectManager() throws NamingException, IOException {
		return (ProjectManager) getContext().lookup("ejb:jmp-module09-ear/jmp-module09-ejb/ProjectManagerBean!jmp.module09.ejb.services.project.ProjectManager");
	}

	@Override
	public Response createProject(Project project) {
		try {
			ProjectManager projectManager = getProjectManager();
			projectManager.createProject(project);
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (NamingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}

	@Override
	public Response getProject(long id) {
		Project Project = null;
		try {			
			ProjectManager projectManager = getProjectManager();			
			Project = projectManager.getProject(id);
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (NamingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		GenericEntity<Project> entity = 
				new GenericEntity<Project>(Project){};
				return Response.ok(entity).build();
	}

	@Override
	public Response getProjects() {
		List<Project> projectsList = new ArrayList<Project>();
		try {
			ProjectManager projectManager = getProjectManager();
			projectsList = projectManager.list();
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (NamingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		GenericEntity<Project[]> entity = 
				new GenericEntity<Project[]>(projectsList.toArray(new Project[0])){};
				return Response.ok(entity).build();
	}

	@Override
	public Response updateProject(long id, Project project) {
		try {
			ProjectManager projectManager = getProjectManager();
			projectManager.updateProject(id, project);
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (NamingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}

	@Override
	public Response deleteProject(long id){
		try {
			ProjectManager projectManager = getProjectManager();
			projectManager.deleteProject(id);				
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (NamingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}

}
