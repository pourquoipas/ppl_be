package org.gnius.hr.repository.model.base.table;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.gnius.hr.repository.model.common.TablePanacheEntity;
@Entity
@Table(name = Comune.TABLE_NAME)
public class Comune extends TablePanacheEntity {
	
	public static final String TABLE_NAME = "base_comune";
	
	@Column(length = 6)
	public String codiceStatistico;
	
	@Column(length = 5)
	public String cap;
	
    @ElementCollection(fetch = FetchType.EAGER, targetClass = String.class)
    @CollectionTable(
            name="base_capcomune",
            joinColumns=@JoinColumn(name="comuneId")
    )
    @Column(name="cap", nullable = false, length = 5)
    public Set<String> capComune = new TreeSet<String>();
	
	@Column(length = 36)
	public String statoId;
	@Transient
	public TablePanacheEntity stato;
	
	@Column(length = 36)
	public String statofederatoId;
	@Transient
	public TablePanacheEntity statofederato;
	
	@Column(length = 36)
	public String regioneId;
	@Transient
	public TablePanacheEntity regione;

	@Column(length = 36)
	public String provinciaId;
	@Transient
	public TablePanacheEntity provincia;

	
	public static TablePanacheEntity findAsTable(String uuid) {
		return findByTableAndId("Comune", uuid);
	}

}
