package org.gnius.hr.enterprise.model.hr;

import java.time.LocalDate;
import java.util.List;

import org.gnius.hr.enterprise.model.base.Comune;
import org.gnius.hr.enterprise.model.base.Provincia;
import org.gnius.hr.enterprise.model.base.Stato;
import org.gnius.hr.enterprise.model.base.TitoloStudio;
import org.gnius.hr.enterprise.model.common.TenantEntity;
import org.gnius.hr.enterprise.model.common.specialized.Contatto;
import org.gnius.hr.enterprise.model.common.specialized.Indirizzo;
import org.gnius.hr.interfaces.base.enums.SessoEnum;
import org.gnius.hr.interfaces.base.enums.StatoCivileEnum;

public class Persona extends TenantEntity {
	
	public String codice;
	public String cognome;
	public String nome;
	public SessoEnum sesso;
	public StatoCivileEnum statoCivile;
	public LocalDate dataNascita;
	public String statoNascitaId;
	public Stato statoNascita;
	public String provinciaNascitaId;
	public Provincia provinciaNascita;
	public String comuneNascitaId;
	public Comune comuneNascita;
	public String cittadinanzaId;
	public Stato cittadinanza;
	public String codiceFiscale;
	public String titoloStudioId;
	public TitoloStudio titoloStudio;
	public String titoloStudioDesc;
	public Integer titoloStudioAnno;
    public /* ResidenzaPersona */ Indirizzo residenza;  	
    public /* DomicilioPersona */ Indirizzo domicilio;  
    
    public List<Contatto> contatti;
}
