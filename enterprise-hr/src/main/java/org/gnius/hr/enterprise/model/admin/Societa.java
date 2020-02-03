package org.gnius.hr.enterprise.model.admin;

import org.gnius.hr.enterprise.model.common.BaseEntity;

import io.quarkus.runtime.annotations.RegisterForReflection;

public class Societa extends BaseEntity {
	public String codice;
	public String descrizione;
	public String ruoloAccesso;
}
