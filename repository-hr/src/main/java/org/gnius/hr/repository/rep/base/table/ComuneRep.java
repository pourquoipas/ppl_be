package org.gnius.hr.repository.rep.base.table;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;

import org.gnius.hr.repository.model.base.table.Comune;
import org.gnius.hr.repository.model.base.table.Provincia;
import org.gnius.hr.repository.model.base.table.Regione;
import org.gnius.hr.repository.model.base.table.Stato;
import org.gnius.hr.repository.model.base.table.StatoFederato;
import org.gnius.hr.repository.rep.common.AbstractTableRepository;
import org.gnius.hr.repository.rep.common.TableRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@Path("v1/comune")
@ApplicationScoped
public class ComuneRep extends AbstractTableRepository<Comune> implements TableRepository<Comune>{

	@Override
	public Comune findById(String id) {
		return Comune.findById(id);
	}

	@Override
	public List<Comune> listAll() {
		return Comune.listAll();
	}

	@Override
	public void updateValues(Comune persisted, Comune provided) {
		super.updateValues(persisted, provided);
		persisted.statoId = provided.statoId;
		if (provided.stato != null)
			persisted.stato = provided.stato;
		
		persisted.statofederatoId = provided.statofederatoId;
		if (provided.statofederato != null)
			persisted.statofederato = provided.statofederato;
		
		persisted.regioneId = provided.regioneId;
		if (provided.regione != null)
			persisted.regione = provided.regione;
		
		persisted.provinciaId = provided.provinciaId;
		if (provided.provincia != null)
			persisted.provincia = provided.provincia;
	}

	@Override
	public PanacheQuery<Comune> find(String find, Map<String, Object> params) {
		return Comune.find(find, params);
	}

	@Override
	public PanacheQuery<Comune> findAll() {
		return Comune.findAll();
	}
	
	@Override
	public Comune autoInit(Comune entity) {
		Comune rv = super.autoInit(entity);
		if (rv.statoId != null) {
			rv.stato = Stato.findAsTable(rv.statoId);
		}
		if (rv.statofederatoId != null) {
			rv.statofederato = StatoFederato.findAsTable(rv.statofederatoId);
		}
		if (rv.regioneId != null) {
			rv.regione = Regione.findAsTable(rv.regioneId);
		}
		if (rv.provinciaId != null) {
			rv.provincia = Provincia.findAsTable(rv.provinciaId);
		}
		return rv;
	}

}
