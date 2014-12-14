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
import jmp.module09.ejb.services.unit.UnitManager;
import jmp.module09.jpa.model.Unit;
import jmp.module09.jpa.model.UnitType;

public class UnitResourceService implements UnitResource {


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

	private UnitManager getUnitManager() throws NamingException, IOException {
		return (UnitManager) getContext().lookup("ejb:jmp-module09-ear/jmp-module09-ejb/UnitManagerBean!jmp.module09.ejb.services.unit.UnitManager");
	}

	@Override
	public Response createUnit(Unit unit) {
		try {
						
			UnitManager unitManager = getUnitManager();
			unitManager.createUnit(unit);
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
	public Response getUnit(long id) {
		Unit unit = null;
		try {		
			UnitManager unitManager = getUnitManager();
			unit = unitManager.getUnit(id);
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (NamingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		GenericEntity<Unit> entity = 
				new GenericEntity<Unit>(unit){};
				return Response.ok(entity).build();
	}

	@Override
	public Response getUnits() {
		List<Unit> unitsList = new ArrayList<Unit>();
		try {
			UnitManager unitManager = getUnitManager();
			unitsList = unitManager.list();
		} catch (JsonParseException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (JsonMappingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		} catch (NamingException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		GenericEntity<Unit[]> entity = 
				new GenericEntity<Unit[]>(unitsList.toArray(new Unit[0])){};
				return Response.ok(entity).build();
	}

	@Override
	public Response updateUnit(long id, Unit unit) {
		try {
			UnitManager unitManager = getUnitManager();
			unitManager.updateUnit(id, unit);
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
	public Response deleteUnit(long id){
		try {
			UnitManager unitManager = getUnitManager();
			unitManager.deleteUnit(id);				
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
