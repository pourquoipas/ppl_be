package org.gnius.hr.repository.rep.common;

import java.util.List;
import java.util.Map;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.gnius.hr.repository.model.common.PanacheFindBuilder;
import org.gnius.hr.repository.model.common.Search;
import org.gnius.hr.repository.model.common.TenantPanacheEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

public abstract class AbstractTenantRepository<T extends TenantPanacheEntity> extends AbstractPplRepository<T> implements TenantRepository<T> {

	protected List<T> listAllByTenant(String tenant) {
		return TenantPanacheEntity.list("societa", tenant);
	}
	
	@Override
	public Response getAll(@QueryParam("tenant") String tenant) {
		return Response.ok(listAll()).build();
	}
	
	public void fillFindBuilder(PanacheFindBuilder pfb, Search<T> search) {
		if (search.eq != null) {
			pfb.addEq("societa", search.eq.societa, false);
		}
	}
	
	@Override
	public PanacheQuery<T> preparaQuery(Search<T> search) {
		String find = "";
		PanacheFindBuilder pfb = new PanacheFindBuilder();
		fillFindBuilder(pfb, search);
		find = pfb.getQuery();
		if (find != null && find.length() > 0) {
			// return doFind(find, pfb.getParams());
			return find(find, pfb.getParams());
		}
		return findAll();
	}
	
	public abstract PanacheQuery<T> find(String find, Map<String, Object> params);
	public abstract PanacheQuery<T> findAll();
	
}
