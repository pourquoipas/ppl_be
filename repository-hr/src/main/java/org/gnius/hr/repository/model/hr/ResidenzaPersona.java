package org.gnius.hr.repository.model.hr;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.gnius.hr.repository.model.common.specialized.Indirizzo;

import com.fasterxml.jackson.annotation.JsonIgnore;

/** N.B. Vedi https://stackoverflow.com/questions/6833370/jpa-onetoone-with-shared-id-can-i-do-this-better
 * 
 * @author gianluca
 *
 */
@Entity
@Table(name=ResidenzaPersona.TABLE_NAME)
public class ResidenzaPersona extends Indirizzo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "hr_residenzapersona";
	
//	@Id
//	@Column(name="personaId") 
//	public String uuid;	
//	
////	@MapsId 
////    @OneToOne(mappedBy = "residenza", fetch = FetchType.EAGER)
////	// @Column(name="personaId")
////    @JoinColumn(name = "personaId")   //same name as id @Column
////    public Persona persona;
//	
//	@MapsId
//	@OneToOne
//	@JoinColumn(name = "personaId")
//	public Persona persona;

	@Id
	@OneToOne()
	@JoinColumn(name = "personaId")
	@JsonIgnore   // << ci darebbe una dipendenza ricorsiva
	@JsonbTransient // jsonIgnore per jsonB
	public Persona persona;
	
}
