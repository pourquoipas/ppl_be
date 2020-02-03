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
import org.gnius.hr.enterprise.interfaces.AdminRep;
import org.gnius.hr.enterprise.model.admin.Societa;
import org.gnius.hr.enterprise.model.common.Search;

@Path("api/v1/admin")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class AdminService {
	
    @Inject
    @RestClient
    AdminRep adminRep;
	
// =========================================
// ==== SOCIETA =============================    
	@GET
	@Path("/societa")
	public Response getAllSocieta() {
		return adminRep.getAllSocieta();
	}
	
	@POST
	@Path("/societa/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchSocieta(Search<Societa> search) {
		return adminRep.searchSocieta(search);
	}
	
    @GET
    @Path("/societa/{id}")
    @Produces("application/json")
    public Response getByIdSocieta(@PathParam("id") String id) {
    	return adminRep.getByIdSocieta(id);
    }

    @POST
    @Path("/societa")
    public Response createSocieta(Societa entity) {
    	return adminRep.createSocieta(entity);
    }
    
    @PUT
//    @Path("/societa/{id}")
    @Path("/societa")
    @Produces("application/json")
    @Consumes("application/json")    
    public Response updateSocieta(/* @BeanParam */ Societa entity) { //, @PathParam("id") String id) {
    	return adminRep.updateSocieta(entity); // , id);
    }
    
    @DELETE
    @Path("/societa/{id}")
    public Response deleteSocieta(@PathParam("id") String id) {
    	return adminRep.deleteSocieta(id);
    }
	

}
