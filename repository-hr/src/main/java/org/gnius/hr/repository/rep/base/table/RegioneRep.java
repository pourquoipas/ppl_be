package org.gnius.hr.repository.rep.base.table;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;

import org.gnius.hr.repository.model.base.table.Regione;
import org.gnius.hr.repository.model.base.table.Stato;
import org.gnius.hr.repository.rep.common.AbstractTableRepository;
import org.gnius.hr.repository.rep.common.TableRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@Path("v1/regione")
@ApplicationScoped
public class RegioneRep extends AbstractTableRepository<Regione> implements TableRepository<Regione>{

	@Override
	public Regione findById(String id) {
		return Regione.findById(id);
	}

	@Override
	public List<Regione> listAll() {
		return Regione.listAll();
	}

	@Override
	public void updateValues(Regione persisted, Regione provided) {
		super.updateValues(persisted, provided);
		persisted.statoId = provided.statoId;
		if (provided.stato != null)
			persisted.stato = provided.stato;
		
		persisted.statofederatoId = provided.statofederatoId;
		if (provided.statofederato != null)
			persisted.statofederato = provided.statofederato;
	}

	@Override
	public PanacheQuery<Regione> find(String find, Map<String, Object> params) {
		return Regione.find(find, params);
	}

	@Override
	public PanacheQuery<Regione> findAll() {
		return Regione.findAll();
	}
	
	@Override
	public Regione autoInit(Regione entity) {
		Regione rv = super.autoInit(entity);
		if (rv.statoId != null) {
			rv.stato = Stato.findAsTable(rv.statoId);
		}
		if (rv.statofederatoId != null) {
			rv.statofederato = Stato.findAsTable(rv.statofederatoId);
		}
		return rv;
	}

}
