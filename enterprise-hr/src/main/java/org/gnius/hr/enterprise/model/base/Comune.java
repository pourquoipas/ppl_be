package org.gnius.hr.enterprise.model.base;

import java.util.Set;
import java.util.TreeSet;

import org.gnius.hr.enterprise.model.common.TableEntity;

public class Comune extends TableEntity {
	public String codiceStatistico;
	public String cap;
    public Set<String> capComune = new TreeSet<String>();

	public String statoId;
	public Stato stato;
	public String statofederatoId;
	public StatoFederato statofederato;
	public String regioneId;
	public Regione regione;
	public String provinciaId;
	public Regione provincia;
}
