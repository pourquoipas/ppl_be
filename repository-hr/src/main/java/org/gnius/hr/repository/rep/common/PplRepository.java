package org.gnius.hr.repository.rep.common;

import java.util.List;

import javax.json.Json;
import javax.transaction.Transactional;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.gnius.hr.repository.model.common.BasePanacheEntity;
import org.gnius.hr.repository.model.common.Search;

@Produces("application/json")
@Consumes("application/json")
public interface PplRepository<T extends BasePanacheEntity> {

    @GET
    public /* List<T> */ Response getAll();

    @GET
    @Path("{id}")
    public Response /* T */ getById(@PathParam("id") String id);

    @POST
    @Transactional
    public Response create(T entity);    
    
    @PUT
//    @Path("{id}")
    @Transactional
    public Response /* T */ update( /* @BeanParam  */ T entity); // , @PathParam("id") String id);
    
    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") String id);

    @Provider
    public static class ErrorMapper implements ExceptionMapper<Exception> {

    	@Override
	    public Response toResponse(Exception exception) {
	        int code = 500;
	        if (exception instanceof WebApplicationException) {
	            code = ((WebApplicationException) exception).getResponse().getStatus();
	        }
	        return Response.status(code)
	                .entity(Json.createObjectBuilder().add("error", exception.getMessage()).add("code", code).build())
	                .build();
	    }
    }
    
    @POST
    @Path("/search")
    public Response createSearch(Search<T> entity);    
    
}
