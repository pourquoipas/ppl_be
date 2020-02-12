package org.gnius.hr.repository.model.common.specialized;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import org.gnius.hr.interfaces.base.enums.TipoContattoEnum;
import org.gnius.hr.repository.model.common.BasePanacheEntity;

@MappedSuperclass
public class Contatto extends BasePanacheEntity {

	@Column(name="tipo", length=20)
	@Enumerated(EnumType.STRING)
	public TipoContattoEnum tipo;
	
	@Column(name="contatto", length=200)
	public String contatto;
	
}
