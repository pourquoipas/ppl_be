package org.gnius.hr.repository.model.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.gnius.hr.repository.model.common.BasePanacheEntity;

/**
 * <p> 
 * Tabella che rappresenta una società. 
 * </p>
 * <p>
 * In visione multi-tenant la società rappresenta anche il discriminante per 
 * distinguere fra dati di società differenti presenti sullo stesso DB<br>
 * In quest'ottica tutte le entità i cui dati saranno distinti fra diverse
 * società dovranno ereditare il campo societa che conterrà il codice della
 * società.<br>
 * Per fare questo è consigliato/necessario, estendere (direttamente o 
 * indirettamente) TenantPanacheEntity.
 * </p>
 * @author gianluca
 * @see TenantPanacheEntity
 *
 */
@Entity
@Table(name = "hr_societa")
public class Societa extends BasePanacheEntity {

	@Column(name = "codice", length = 8, nullable = false)
	public String codice;
	
	@Column(name = "descrizione", length = 100, nullable = false)
	public String descrizione;
	
	/** definisce il ruolo (role) che dovrà avere l'utente per accedere alla società
	 *  
	 */
	@Column(name = "ruolo_accesso", length = 20)
	public String ruoloAccesso;
}
