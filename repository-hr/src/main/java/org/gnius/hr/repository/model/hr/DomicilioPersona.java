package org.gnius.hr.repository.model.hr;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.gnius.hr.repository.model.common.specialized.Indirizzo;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name=DomicilioPersona.TABLE_NAME)
public class DomicilioPersona extends Indirizzo implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "hr_domiciliopersona";
	
//	@Id
//	@Column(name="personaId") 
//	public String uuid;	
//	
////	@MapsId 
////    @OneToOne(mappedBy = "domicilio", fetch = FetchType.EAGER)
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
	@JsonIgnore // << ci darebbe una dipendenza ricorsiva
	@JsonbTransient // jsonIgnore per jsonB	
	public Persona persona;
	
}
