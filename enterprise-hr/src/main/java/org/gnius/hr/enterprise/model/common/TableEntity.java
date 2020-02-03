package org.gnius.hr.enterprise.model.common;

import java.time.LocalDate;

import org.gnius.hr.util.DateUtil;

public class TableEntity extends TenantEntity {
	public String codice;
	
	/** Campo contenente la descrizione della tabella */
	public String descrizione;
	
	/** Campo contenente la data di inizio validità della tabella (inclusiva, il giorno di inizio la tabella era valida) */
	public LocalDate inizio;
	
	/** Campo contenente la data di fine validità della tabella  (inclusiva, il giorno di fine la tabella era valida) */
	public LocalDate fine;
	
	public boolean attivo(LocalDate data) {
		if (data == null) {
			return fine == null;
		} else {
			return DateUtil.isIn(inizio, fine, data);
		}
	}

	public LocalDate valido;
	public Boolean attivo;

}
