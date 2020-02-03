package org.gnius.hr.repository.rep.base.table;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;

import org.gnius.hr.repository.model.base.table.Provincia;
import org.gnius.hr.repository.model.base.table.Regione;
import org.gnius.hr.repository.model.base.table.Stato;
import org.gnius.hr.repository.model.base.table.StatoFederato;
import org.gnius.hr.repository.rep.common.AbstractTableRepository;
import org.gnius.hr.repository.rep.common.TableRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@Path("v1/provincia")
@ApplicationScoped
public class ProvinciaRep extends AbstractTableRepository<Provincia> implements TableRepository<Provincia>{

	@Override
	public Provincia findById(String id) {
		return Provincia.findById(id);
	}

	@Override
	public List<Provincia> listAll() {
		return Provincia.listAll();
	}

	@Override
	public void updateValues(Provincia persisted, Provincia provided) {
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
	}

	@Override
	public PanacheQuery<Provincia> find(String find, Map<String, Object> params) {
		return Provincia.find(find, params);
	}

	@Override
	public PanacheQuery<Provincia> findAll() {
		return Provincia.findAll();
	}
	
	@Override
	public Provincia autoInit(Provincia entity) {
		Provincia rv = super.autoInit(entity);
		if (rv.statoId != null) {
			rv.stato = Stato.findAsTable(rv.statoId);
		}
		if (rv.statofederatoId != null) {
			rv.statofederato = StatoFederato.findAsTable(rv.statofederatoId);
		}
		if (rv.regioneId != null) {
			rv.regione = Regione.findAsTable(rv.regioneId);
		}
		return rv;
	}
}
