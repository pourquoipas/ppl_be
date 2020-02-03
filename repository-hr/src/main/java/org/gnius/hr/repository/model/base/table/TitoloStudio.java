package org.gnius.hr.repository.model.base.table;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.gnius.hr.interfaces.base.enums.LivelloTitoloStudioEnum;
import org.gnius.hr.repository.model.common.TablePanacheEntity;

@Entity
@Table(name = TitoloStudio.TABLE_NAME)
public class TitoloStudio extends TablePanacheEntity {
	
	public static final String TABLE_NAME = "base_titolosudio";
	
	@Enumerated(EnumType.STRING)
	public LivelloTitoloStudioEnum livello;
	
	public static TablePanacheEntity findAsTable(String uuid) {
		return findByTableAndId("TitoloStudio", uuid);
	}
	
}
