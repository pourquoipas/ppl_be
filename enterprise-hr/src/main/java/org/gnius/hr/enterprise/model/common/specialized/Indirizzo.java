package org.gnius.hr.enterprise.model.common.specialized;

import org.gnius.hr.enterprise.model.base.Comune;
import org.gnius.hr.enterprise.model.base.Provincia;
import org.gnius.hr.enterprise.model.base.Stato;
import org.gnius.hr.enterprise.model.common.BaseEntity;

public class Indirizzo extends BaseEntity {

	public String statoId;
	public Stato stato;
	public String provinciaId;
	public Provincia provincia;
	public String comuneId;
	public Comune comune;
	public String cap;
	public String localita;
	public String indirizzo;
	public String civico;
	public String interno;
	public String scala;
	public String edificioDesc;
	public String aggiuntive;
}
