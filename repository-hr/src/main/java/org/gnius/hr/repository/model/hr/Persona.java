package org.gnius.hr.repository.model.hr;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.gnius.hr.interfaces.base.enums.SessoEnum;
import org.gnius.hr.interfaces.base.enums.StatoCivileEnum;
import org.gnius.hr.repository.model.common.TablePanacheEntity;
import org.gnius.hr.repository.model.common.TenantPanacheEntity;

@Entity
@Table(name=Persona.TABLE_NAME)
public class Persona extends TenantPanacheEntity {

	public static final String TABLE_NAME = "hr_persona";

	/** Campo contenente il codice della persona */
	@Column(name = "codice", length = 25, nullable = false)
	public String codice;
	
	@Column(name = "cognome", length = 50, nullable = false)
	public String cognome;

	@Column(name = "nome", length = 50, nullable = false)
	public String nome;
	
	@Enumerated(EnumType.STRING)
	public SessoEnum sesso;

	@Column(name="statocivile")
	@Enumerated(EnumType.STRING)
	public StatoCivileEnum statoCivile;
	
	@Column(name="dataaascita", nullable=true)
	public LocalDate dataNascita;
	
	@Column(name="statonascitaId", length=36)
	public String statoNascitaId;
	@Transient
	public TablePanacheEntity statoNascita;

	@Column(name="provincianascitaId", length=36)
	public String provinciaNascitaId;
	@Transient
	public TablePanacheEntity provinciaNascita;
	
	@Column(name="comunenascitaId", length=36)
	public String comuneNascitaId;
	@Transient
	public TablePanacheEntity comuneNascita;
	
	@Column(name="cittadinanzaId", length=36)
	public String cittadinanzaId;
	@Transient
	public TablePanacheEntity cittadinanza;

	@Column(name="codicefiscale", length=16)
	public String codiceFiscale;
	
// ToDo. 
// titolostudio potrebbe andare in una tabella a parte come gli indirizzi	
	// Titolo studio.
	@Column(name="titolostudioId", length=36)
	public String titoloStudioId;
	@Transient
	public TablePanacheEntity titoloStudio;
	
	@Column(name="titolostudiodesc", length=100)
	public String titoloStudioDesc;
	
	@Column(name="titolostudioanno")
	public Integer titoloStudioAnno;
	
	// TODO Contatti: Cellulare, telefono, mail, altro
	
//	// Residenza e Domicilio (vedi: ResidenzaPersona, https://stackoverflow.com/questions/6833370/jpa-onetoone-with-shared-id-can-i-do-this-better)
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
//    // @PrimaryKeyJoinColumn
//	@JoinColumn(name = "uuid",insertable=false,updatable=false)
//    public ResidenzaPersona residenza;  	
	
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
//    // @PrimaryKeyJoinColumn
//	@JoinColumn(name = "uuid",insertable=false,updatable=false)
//    public DomicilioPersona domicilio;  	

	@PrimaryKeyJoinColumn
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
//	@JoinColumn(name = "uuid")
    public ResidenzaPersona residenza;  	

	@PrimaryKeyJoinColumn
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
//	@JoinColumn(name = "uuid")
    public DomicilioPersona domicilio;  	
	
	
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER) 
	@OrderBy("dtins ASC")
	public List<ContattoPersona> contatti = new ArrayList<ContattoPersona>();
}
