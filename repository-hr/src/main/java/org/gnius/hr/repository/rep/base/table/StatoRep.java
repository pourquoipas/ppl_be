package org.gnius.hr.repository.rep.base.table;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;

import org.gnius.hr.repository.model.base.table.Stato;
import org.gnius.hr.repository.rep.common.AbstractTableRepository;
import org.gnius.hr.repository.rep.common.TableRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@Path("v1/stato")
@ApplicationScoped
public class StatoRep extends AbstractTableRepository<Stato> implements TableRepository<Stato>{

	@Override
	public Stato findById(String id) {
		return Stato.findById(id);
	}

	@Override
	public List<Stato> listAll() {
		return Stato.listAll();
	}

	@Override
	public void updateValues(Stato persisted, Stato provided) {
		super.updateValues(persisted, provided);
		persisted.isoAlpha2 = provided.isoAlpha2;
		persisted.isoAlpha3 = provided.isoAlpha3;
		persisted.isoNumeric = provided.isoNumeric;
	}

	@Override
	public PanacheQuery<Stato> find(String find, Map<String, Object> params) {
		return Stato.find(find, params);
	}

	@Override
	public PanacheQuery<Stato> findAll() {
		return Stato.findAll();
	}

}
