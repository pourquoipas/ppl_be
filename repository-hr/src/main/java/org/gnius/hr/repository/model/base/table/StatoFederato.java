package org.gnius.hr.repository.model.base.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.gnius.hr.repository.model.common.TablePanacheEntity;

@Entity
@Table(name = StatoFederato.TABLE_NAME)
public class StatoFederato extends TablePanacheEntity {
	
	public static final String TABLE_NAME = "base_statofederato";

	@Column(length = 36)
	public String statoId;
	@Transient
	public TablePanacheEntity stato;
	
	public static TablePanacheEntity findAsTable(String uuid) {
		return findByTableAndId("StatoFederato", uuid);
	}
	
}
