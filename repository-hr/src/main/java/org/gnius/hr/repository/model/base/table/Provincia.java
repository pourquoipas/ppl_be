package org.gnius.hr.repository.model.base.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.gnius.hr.repository.model.common.TablePanacheEntity;

@Entity
@Table(name = Provincia.TABLE_NAME)
public class Provincia extends TablePanacheEntity {
	
	public static final String TABLE_NAME = "base_provincia";
	
	// TODO verifica se è sensato
	@Column(length = 2)
	public String sigla;
	
	@Column(length = 36)
	public String statoId;
	@Transient
	public TablePanacheEntity stato;
	
	@Column(length = 36)
	public String statofederatoId;
	@Transient
	public TablePanacheEntity statofederato;
	
	@Column(length = 36)
	public String regioneId;
	@Transient
	public TablePanacheEntity regione;

	public static TablePanacheEntity findAsTable(String uuid) {
		return findByTableAndId("Provincia", uuid);
	}

}
