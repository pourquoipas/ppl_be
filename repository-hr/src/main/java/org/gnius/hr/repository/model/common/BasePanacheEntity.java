package org.gnius.hr.repository.model.common;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/** 
 * <p>
 * Rappresenta una entità dotata di uuid generato da hibernate per la gestione dati sul progetto HuRes.
 * </p>
 * 
 * @author gianluca
 * @see PanacheEntityBase
 */
@MappedSuperclass
public abstract class BasePanacheEntity extends PanacheEntityBase {
	
    /**
     * The auto-generated UUID field. This field is set by Hibernate ORM when this entity
     * is persisted.
     *
     * @see #persist()
     */
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length = 36)
    public String uuid;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "<" + uuid + ">";
    }
    
}
