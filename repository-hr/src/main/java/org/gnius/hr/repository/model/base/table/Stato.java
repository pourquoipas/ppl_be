package org.gnius.hr.repository.model.base.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.gnius.hr.repository.model.common.TablePanacheEntity;
import org.gnius.hr.tools.UpdatableEntity;

@Entity
@Table(name = Stato.TABLE_NAME)
public class Stato extends TablePanacheEntity {
	
	public static final String TABLE_NAME = "base_stato";
	
	@Column(length = 2, nullable = true)
	public String isoAlpha2;
	@Column(length = 3, nullable = true)
	public String isoAlpha3;
	@Column(length = 3, nullable = true)
	public String isoNumeric;
	
	
	public static TablePanacheEntity findAsTable(String uuid) {
		return findByTableAndId("Stato", uuid);
	}
}
