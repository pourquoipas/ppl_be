package org.gnius.hr.repository.rep.base.table;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

import org.gnius.hr.repository.model.base.table.Stato;
import org.gnius.hr.repository.model.base.table.StatoFederato;
import org.gnius.hr.repository.rep.common.AbstractTableRepository;
import org.gnius.hr.repository.rep.common.TableRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@Path("v1/statofederato")
@ApplicationScoped
public class StatoFederatoRep extends AbstractTableRepository<StatoFederato> implements TableRepository<StatoFederato>{

	@Override
	public StatoFederato findById(String id) {
		// TODO Auto-generated method stub
		return StatoFederato.findById(id);
	}

	@Override
	public List<StatoFederato> listAll() {
		// TODO Auto-generated method stub
		return StatoFederato.listAll();
	}

	@Override
	public void updateValues(StatoFederato persisted, StatoFederato provided) {
		super.updateValues(persisted, provided);
		persisted.statoId = provided.statoId;
		if (provided.stato != null)
			persisted.stato = provided.stato;
	}

	@Override
	public PanacheQuery<StatoFederato> find(String find, Map<String, Object> params) {
		return StatoFederato.find(find, params);
	}

	@Override
	public PanacheQuery<StatoFederato> findAll() {
		return StatoFederato.findAll();
	}
	@Inject StatoRep statoRep;
	
	@Override
	public StatoFederato autoInit(StatoFederato entity) {
		StatoFederato rv = super.autoInit(entity);
		if (rv.statoId != null) {
			rv.stato = Stato.findAsTable(rv.statoId);
		}
		return rv;
	}

}
