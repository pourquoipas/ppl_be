package org.gnius.hr.enterprise.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.gnius.hr.enterprise.model.common.Search;
import org.gnius.hr.enterprise.model.hr.Persona;

@Path("/v1")
@RegisterRestClient
@Produces("application/json")
@Consumes("application/json")
public interface HrRep {

	// ======================================
	// ==== PERSONA =========================

	@GET
	@Path("/persona")
	@Produces("application/json")
	public Response getAllPersona();

	@POST
	@Path("/persona/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchPersona(Search<Persona> search);

	@GET
	@Path("/persona/{id}")
	@Produces("application/json")
	public Response getByIdPersona(@PathParam("id") String id);

	@POST
	@Path("/persona")
	public Response createPersona(Persona entity);

	@PUT
	@Path("/persona")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updatePersona(Persona entity);

	@DELETE
	@Path("/persona/{id}")
	public Response deletePersona(@PathParam("id") String id);

}
