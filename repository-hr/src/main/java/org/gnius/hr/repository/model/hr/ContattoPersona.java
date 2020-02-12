package org.gnius.hr.repository.model.hr;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.gnius.hr.repository.model.common.specialized.Contatto;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name=ContattoPersona.TABLE_NAME)
public class ContattoPersona extends Contatto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "hr_contattopersona";
	
	@ManyToOne
	@JoinColumn(name = "personaId")
	@JsonIgnore // << ci darebbe una dipendenza ricorsiva
	@JsonbTransient // jsonIgnore per jsonB	
	public Persona persona;

	@Column(name="dtins")
	// @Temporal(TemporalType.TIMESTAMP)
	public LocalDateTime dtins;
	
	@PrePersist
	public void prePersist() {
		if (this.dtins == null) {
			this.dtins = LocalDateTime.now();
		}
	}
	
}
