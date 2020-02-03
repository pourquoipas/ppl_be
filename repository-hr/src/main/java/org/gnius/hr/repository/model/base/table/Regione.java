package org.gnius.hr.repository.model.base.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.gnius.hr.repository.model.common.TablePanacheEntity;

@Entity
@Table(name = Regione.TABLE_NAME)
public class Regione extends TablePanacheEntity {

	public static final String TABLE_NAME = "base_regione";

	@Column(length = 36)
	public String statoId;
	@Transient
	public TablePanacheEntity stato;

	@Column(length = 36)
	public String statofederatoId;
	@Transient
	public TablePanacheEntity statofederato;

	public static TablePanacheEntity findAsTable(String uuid) {
		return findByTableAndId("Regione", uuid);
	}

}
