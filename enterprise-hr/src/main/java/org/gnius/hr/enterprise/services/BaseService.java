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
import org.gnius.hr.enterprise.interfaces.BaseRep;
import org.gnius.hr.enterprise.model.base.Comune;
import org.gnius.hr.enterprise.model.base.Provincia;
import org.gnius.hr.enterprise.model.base.Regione;
import org.gnius.hr.enterprise.model.base.Stato;
import org.gnius.hr.enterprise.model.base.StatoFederato;
import org.gnius.hr.enterprise.model.base.TitoloStudio;
import org.gnius.hr.enterprise.model.common.Search;

@Path("api/v1/base")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class BaseService {

	@Inject
	@RestClient
	BaseRep baseRep;

	// =========================================
	// ==== STATO =============================
	@GET
	@Path("/stato")
	public Response getAllStato() {
		return baseRep.getAllStato();
	}

	@POST
	@Path("/stato/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchStato(Search<Stato> search) {
		return baseRep.searchStato(search);
	}

	@GET
	@Path("/stato/{id}")
	@Produces("application/json")
	public Response getByIdStato(@PathParam("id") String id) {
		return baseRep.getByIdStato(id);
	}

	@POST
	@Path("/stato")
	public Response createStato(Stato entity) {
		return baseRep.createStato(entity);
	}

	@PUT
//	    @Path("/stato/{id}")
	@Path("/stato")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateStato(/* @BeanParam */ Stato entity) { // , @PathParam("id") String id) {
		return baseRep.updateStato(entity); // , id);
	}

	@DELETE
	@Path("/stato/{id}")
	public Response deleteStato(@PathParam("id") String id) {
		return baseRep.deleteStato(id);
	}

	// =========================================
	// ==== STATOFEDERATO =============================
	@GET
	@Path("/statofederato")
	public Response getAllStatoFederato() {
		return baseRep.getAllStatoFederato();
	}

	@POST
	@Path("/statofederato/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchStatoFederato(Search<StatoFederato> search) {
		return baseRep.searchStatoFederato(search);
	}

	@GET
	@Path("/statofederato/{id}")
	@Produces("application/json")
	public Response getByIdStatoFederato(@PathParam("id") String id) {
		return baseRep.getByIdStatoFederato(id);
	}

	@POST
	@Path("/statofederato")
	public Response createStatoFederato(StatoFederato entity) {
		return baseRep.createStatoFederato(entity);
	}

	@PUT
//	    @Path("/stato/{id}")
	@Path("/statofederato")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateStatoFederato(/* @BeanParam */ StatoFederato entity) { // , @PathParam("id") String id) {
		return baseRep.updateStatoFederato(entity); // , id);
	}

	@DELETE
	@Path("/statofederato/{id}")
	public Response deleteStatoFederato(@PathParam("id") String id) {
		return baseRep.deleteStatoFederato(id);
	}

	// =========================================
	// ==== REGIONE =============================
	@GET
	@Path("/regione")
	public Response getAllRegione() {
		return baseRep.getAllRegione();
	}

	@POST
	@Path("/regione/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchRegione(Search<Regione> search) {
		return baseRep.searchRegione(search);
	}

	@GET
	@Path("/regione/{id}")
	@Produces("application/json")
	public Response getByIdRegione(@PathParam("id") String id) {
		return baseRep.getByIdRegione(id);
	}

	@POST
	@Path("/regione")
	public Response createRegione(Regione entity) {
		return baseRep.createRegione(entity);
	}

	@PUT
	@Path("/regione")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateRegione(Regione entity) { // , @PathParam("id") String id) {
		return baseRep.updateRegione(entity); // , id);
	}

	@DELETE
	@Path("/regione/{id}")
	public Response deleteRegione(@PathParam("id") String id) {
		return baseRep.deleteRegione(id);
	}

	
	// =========================================
	// ==== PROVINCIA =============================
	@GET
	@Path("/provincia")
	public Response getAllProvincia() {
		return baseRep.getAllProvincia();
	}

	@POST
	@Path("/provincia/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchProvincia(Search<Provincia> search) {
		return baseRep.searchProvincia(search);
	}

	@GET
	@Path("/provincia/{id}")
	@Produces("application/json")
	public Response getByIdProvincia(@PathParam("id") String id) {
		return baseRep.getByIdProvincia(id);
	}

	@POST
	@Path("/provincia")
	public Response createProvincia(Provincia entity) {
		return baseRep.createProvincia(entity);
	}

	@PUT
	@Path("/provincia")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateProvincia(Provincia entity) { // , @PathParam("id") String id) {
		return baseRep.updateProvincia(entity); // , id);
	}

	@DELETE
	@Path("/provincia/{id}")
	public Response deleteProvincia(@PathParam("id") String id) {
		return baseRep.deleteProvincia(id);
	}


	// =========================================
	// ==== COMUNE =============================
	@GET
	@Path("/comune")
	public Response getAllComune() {
		return baseRep.getAllComune();
	}

	@POST
	@Path("/comune/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchComune(Search<Comune> search) {
		return baseRep.searchComune(search);
	}

	@GET
	@Path("/comune/{id}")
	@Produces("application/json")
	public Response getByIdComune(@PathParam("id") String id) {
		return baseRep.getByIdComune(id);
	}

	@POST
	@Path("/comune")
	public Response createComune(Comune entity) {
		return baseRep.createComune(entity);
	}

	@PUT
	@Path("/comune")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateComune(Comune entity) { // , @PathParam("id") String id) {
		return baseRep.updateComune(entity); // , id);
	}

	@DELETE
	@Path("/comune/{id}")
	public Response deleteComune(@PathParam("id") String id) {
		return baseRep.deleteComune(id);
	}
	
	// =========================================
	// ==== TITOLO STUDIO =============================
	@GET
	@Path("/titolostudio")
	public Response getAllTitoloStudio() {
		return baseRep.getAllTitoloStudio();
	}

	@POST
	@Path("/titolostudio/search")
	@Produces("application/json")
	@Consumes("application/json")
	public Response searchTitoloStudio(Search<TitoloStudio> search) {
		return baseRep.searchTitoloStudio(search);
	}

	@GET
	@Path("/titolostudio/{id}")
	@Produces("application/json")
	public Response getByIdTitoloStudio(@PathParam("id") String id) {
		return baseRep.getByIdTitoloStudio(id);
	}

	@POST
	@Path("/titolostudio")
	public Response createTitoloStudio(TitoloStudio entity) {
		return baseRep.createTitoloStudio(entity);
	}

	@PUT
	@Path("/titolostudio")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateTitoloStudio(TitoloStudio entity) { // , @PathParam("id") String id) {
		return baseRep.updateTitoloStudio(entity); // , id);
	}

	@DELETE
	@Path("/titolostudio/{id}")
	public Response deleteTitoloStudio(@PathParam("id") String id) {
		return baseRep.deleteTitoloStudio(id);
	}
	
}
