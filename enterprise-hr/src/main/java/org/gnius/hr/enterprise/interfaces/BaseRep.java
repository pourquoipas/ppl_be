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
import org.gnius.hr.enterprise.model.base.Comune;
import org.gnius.hr.enterprise.model.base.Provincia;
import org.gnius.hr.enterprise.model.base.Regione;
import org.gnius.hr.enterprise.model.base.Stato;
import org.gnius.hr.enterprise.model.base.StatoFederato;
import org.gnius.hr.enterprise.model.base.TitoloStudio;
import org.gnius.hr.enterprise.model.common.Search;

@Path("/v1")
@RegisterRestClient
@Produces("application/json")
@Consumes("application/json")
public interface BaseRep {
	// ======================================
	// ==== STATO ===========================

	@GET
	@Path("/stato")
	@Produces("application/json")
	public Response getAllStato();

	@POST
	@Path("/stato/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchStato(Search<Stato> search);

	@GET
	@Path("/stato/{id}")
	@Produces("application/json")
	public Response getByIdStato(@PathParam("id") String id);

	@POST
	@Path("/stato")
	public Response createStato(/* @BeanParam */ Stato entity);

	@PUT
//	    @Path("societa/{id}")
	@Path("/stato")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateStato(/* @BeanParam */ Stato entity); // , @PathParam("id") String id);

	@DELETE
	@Path("/stato/{id}")
	public Response deleteStato(@PathParam("id") String id);

	// ======================================
	// ==== STATOFEDERATO ===================

	@GET
	@Path("/statofederato")
	@Produces("application/json")
	public Response getAllStatoFederato();

	@POST
	@Path("/statofederato/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchStatoFederato(Search<StatoFederato> search);

	@GET
	@Path("/statofederato/{id}")
	@Produces("application/json")
	public Response getByIdStatoFederato(@PathParam("id") String id);

	@POST
	@Path("/statofederato")
	public Response createStatoFederato(/* @BeanParam */ StatoFederato entity);

	@PUT
	@Path("/statofederato")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateStatoFederato(/* @BeanParam */ StatoFederato entity); // , @PathParam("id") String id);

	@DELETE
	@Path("/statofederato/{id}")
	public Response deleteStatoFederato(@PathParam("id") String id);
	
	// ======================================
	// ==== REGIONE ===================

	@GET
	@Path("/regione")
	@Produces("application/json")
	public Response getAllRegione();

	@POST
	@Path("/regione/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchRegione(Search<Regione> search);

	@GET
	@Path("/regione/{id}")
	@Produces("application/json")
	public Response getByIdRegione(@PathParam("id") String id);

	@POST
	@Path("/regione")
	public Response createRegione(/* @BeanParam */ Regione entity);

	@PUT
	@Path("/regione")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateRegione(/* @BeanParam */ Regione entity); // , @PathParam("id") String id);

	@DELETE
	@Path("/regione/{id}")
	public Response deleteRegione(@PathParam("id") String id);
	
	// ======================================
	// ==== PROVINCIA ===================

	@GET
	@Path("/provincia")
	@Produces("application/json")
	public Response getAllProvincia();

	@POST
	@Path("/provincia/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchProvincia(Search<Provincia> search);

	@GET
	@Path("/provincia/{id}")
	@Produces("application/json")
	public Response getByIdProvincia(@PathParam("id") String id);

	@POST
	@Path("/provincia")
	public Response createProvincia(/* @BeanParam */ Provincia entity);

	@PUT
	@Path("/provincia")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateProvincia(/* @BeanParam */ Provincia entity); // , @PathParam("id") String id);

	@DELETE
	@Path("/provincia/{id}")
	public Response deleteProvincia(@PathParam("id") String id);
	
	// ======================================
	// ==== COMUNE ===================

	@GET
	@Path("/comune")
	@Produces("application/json")
	public Response getAllComune();

	@POST
	@Path("/comune/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchComune(Search<Comune> search);

	@GET
	@Path("/comune/{id}")
	@Produces("application/json")
	public Response getByIdComune(@PathParam("id") String id);

	@POST
	@Path("/comune")
	public Response createComune(/* @BeanParam */ Comune entity);

	@PUT
	@Path("/comune")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateComune(/* @BeanParam */ Comune entity); // , @PathParam("id") String id);

	@DELETE
	@Path("/comune/{id}")
	public Response deleteComune(@PathParam("id") String id);
	
	// ======================================
	// ==== TITOLO STUDIO ===================

	@GET
	@Path("/titolostudio")
	@Produces("application/json")
	public Response getAllTitoloStudio();

	@POST
	@Path("/titolostudio/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchTitoloStudio(Search<TitoloStudio> search);

	@GET
	@Path("/titolostudio/{id}")
	@Produces("application/json")
	public Response getByIdTitoloStudio(@PathParam("id") String id);

	@POST
	@Path("/titolostudio")
	public Response createTitoloStudio(TitoloStudio entity);

	@PUT
	@Path("/titolostudio")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateTitoloStudio(TitoloStudio entity); 

	@DELETE
	@Path("/titolostudio/{id}")
	public Response deleteTitoloStudio(@PathParam("id") String id);
	
}
