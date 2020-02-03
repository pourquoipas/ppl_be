package org.gnius.hr.repository.rep.common;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.gnius.hr.repository.model.common.BasePanacheEntity;
import org.gnius.hr.repository.model.common.Page;
import org.gnius.hr.repository.model.common.Search;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

public abstract class AbstractPplRepository<T extends BasePanacheEntity> implements PplRepository<T> {

	public static final int UNPROCESSABLE_ENTITY = 422;

	public abstract T findById(String id);

	public abstract List<T> listAll();

	public abstract void updateValues(T persisted, T provided);
	
	public abstract PanacheQuery<T> preparaQuery(Search<T> search);

	@Override
	public Response getAll() {
		return Response.ok(autoInit(listAll())).build();
	}

	@Override
	public Response getById(String id) {
		T entity = findById(id);
		if (entity == null) {
			throw new WebApplicationException("Entity with id of " + id + " does not exist.",
					Response.Status.NOT_FOUND);
		}
		return Response.ok(autoInit(entity)).build();
	}

	@Transactional
	@Override
	public Response create(T entity) {
		if (entity.uuid != null) {
			throw new WebApplicationException("Id was invalidly set on request.", UNPROCESSABLE_ENTITY);
		}
		entity.persist();
		return Response.ok(autoInit(entity)).status(201).build();
	}

	@Override
	@Transactional
	public Response update(T entity) { // , String id) {

		T persisted = findById(entity.uuid);
		if (persisted == null) {
			throw new WebApplicationException("Entity with id of " + entity.uuid + " does not exist.",
					Response.Status.NOT_FOUND);
		}
		updateValues(persisted, entity);

		// TODO Missing update ??

		return Response.ok(autoInit(persisted)).build();
	}

	@Transactional
	@Override
	public Response delete(String id) {

		T entity = findById(id);
		if (entity == null) {
			throw new WebApplicationException("Entity with id of " + id + " does not exist.",
					Response.Status.NOT_FOUND);
		}
		entity.delete();
		return Response.status(204).build();
	}
	
	
	@Override
	public Response createSearch(Search<T> entity) {
		List<T> l_t = null;
		PanacheQuery<T> query = preparaQuery(entity);
		Long conteggio = query.count();
		if (entity.page!= null && entity.page.pageSize > 0 && entity.page.page >= 0) {
			l_t = query.page(entity.page.page, entity.page.pageSize).list();
		} else {
			l_t = query.list();
		}
		// N.B. perchè il frontend possa vedere un header devo mettere l'header Access-Control-Expose-Headers
		// Che abbia come valore l'elenco degli header accessibili separati da virgola.
		return Response.ok(autoInit(l_t))
				.status(201)
				.header("Access-Control-Expose-Headers", "totalResults")
				.header("totalResults", conteggio)
				.build();
	}
	
	/** autoInit viene richiamata per inizializzare eventualo campi transient automaticamente ad ogni chiamata
	 * delle funzioni predefinite.<br>
	 * @param entity
	 * @return
	 */
	public T autoInit(T entity) {
		return entity;
	}
	/** autoInit viene richiamata per inizializzare eventualo campi transient automaticamente ad ogni chiamata
	 * delle funzioni predefinite.<br>
	 * @param list_entity
	 * @return
	 */
	public List<T> autoInit(List<T> list_entity) {
		if (list_entity != null) {
			list_entity.stream().forEach(e -> autoInit(e));
		}
		return list_entity;
	}
}
