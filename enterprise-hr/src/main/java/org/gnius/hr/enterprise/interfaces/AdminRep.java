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
import org.gnius.hr.enterprise.model.admin.Societa;
import org.gnius.hr.enterprise.model.common.Search;

@Path("/v1")
@RegisterRestClient
@Produces("application/json")
@Consumes("application/json")
public interface AdminRep {

// ====================================== 
// ==== SOCIETA =========================	
	
	@GET
	@Path("/societa")
	@Produces("application/json")
	public Response getAllSocieta();
	
	@POST
	@Path("/societa/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchSocieta(Search<Societa> search);
	
    @GET
    @Path("/societa/{id}")
    @Produces("application/json")
    public Response getByIdSocieta(@PathParam("id") String id);

    @POST
    @Path("/societa")
    public Response createSocieta(/* @BeanParam*/ Societa entity);    
    
    @PUT
//    @Path("societa/{id}")
    @Path("/societa")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateSocieta(/* @BeanParam */ Societa entity); // , @PathParam("id") String id);
    
    @DELETE
    @Path("/societa/{id}")
    public Response deleteSocieta(@PathParam("id") String id);
	
}
