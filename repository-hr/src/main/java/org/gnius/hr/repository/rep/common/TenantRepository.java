package org.gnius.hr.repository.rep.common;

import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.gnius.hr.repository.model.common.TenantPanacheEntity;

public interface TenantRepository<T extends TenantPanacheEntity> extends PplRepository<T> {

    @GET
    public /* List<T> */ Response getAll(@QueryParam("tenant") String tenant);
	
}
