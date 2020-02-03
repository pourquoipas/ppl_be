package org.gnius.hr.enterprise.model.base;

import org.gnius.hr.enterprise.model.common.TableEntity;

public class Provincia extends TableEntity {
	public String sigla;

	public String statoId;
	public Stato stato;
	public String statofederatoId;
	public StatoFederato statofederato;
	public String regioneId;
	public Regione regione;
	
}
