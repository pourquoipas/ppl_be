package org.gnius.hr.repository.rep.common;

import org.gnius.hr.repository.model.common.TablePanacheEntity;

public interface TableRepository<T extends TablePanacheEntity> extends TenantRepository<T> {

}
