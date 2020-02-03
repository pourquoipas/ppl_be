package org.gnius.hr.repository.rep.base.table;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;

import org.gnius.hr.repository.model.base.table.TitoloStudio;
import org.gnius.hr.repository.rep.common.AbstractTableRepository;
import org.gnius.hr.repository.rep.common.TableRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@Path("v1/titolostudio")
@ApplicationScoped
public class TitoloStudioRep 
		extends AbstractTableRepository<TitoloStudio> 
		implements TableRepository<TitoloStudio> {

	@Override
	public TitoloStudio findById(String id) {
		return TitoloStudio.findById(id);
	}
	
	@Override
	public List<TitoloStudio> listAll() {
		return TitoloStudio.listAll();
	}
	
	@Override
	public PanacheQuery<TitoloStudio> find(String find, Map<String, Object> params) {
		return TitoloStudio.find(find, params);
	}

	@Override
	public PanacheQuery<TitoloStudio> findAll() {
		return TitoloStudio.findAll();
	}

	@Override
	public void updateValues(TitoloStudio persisted, TitoloStudio provided) {
		super.updateValues(persisted, provided);
		persisted.livello = provided.livello;
	}
}
