package org.gnius.hr.enterprise.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.gnius.hr.enterprise.interfaces.HrRep;
import org.gnius.hr.enterprise.model.common.Search;
import org.gnius.hr.enterprise.model.hr.Persona;

@Path("api/v1/hr")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class HrService {

	@Inject
	@RestClient
	HrRep hrRep;
	
	// =========================================
	// ==== STATO =============================
	@GET
	@Path("/persona")
	public Response getAllPersona() {
		return hrRep.getAllPersona();
	}

	@POST
	@Path("/persona/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchPersona(Search<Persona> search) {
		return hrRep.searchPersona(search);
	}

	@GET
	@Path("/persona/{id}")
	@Produces("application/json")
	public Response getByIdPersona(@PathParam("id") String id) {
		return hrRep.getByIdPersona(id);
	}

	@POST
	@Path("/persona")
	public Response createPersona(Persona entity) {
		return hrRep.createPersona(entity);
	}

	@PUT
//	    @Path("/persona/{id}")
	@Path("/persona")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updatePersona(/* @BeanParam */ Persona entity) { // , @PathParam("id") String id) {
		return hrRep.updatePersona(entity); // , id);
	}

	@DELETE
	@Path("/persona/{id}")
	public Response deletePersona(@PathParam("id") String id) {
		return hrRep.deletePersona(id);
	}
	
}
