package org.gnius.hr.enterprise.model.base;

import org.gnius.hr.enterprise.model.common.TableEntity;

public class Regione extends TableEntity {
	public String statoId;
	public Stato stato;
	public String statofederatoId;
	public StatoFederato statofederato;
}
