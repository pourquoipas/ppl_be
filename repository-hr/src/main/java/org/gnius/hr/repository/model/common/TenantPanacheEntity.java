package org.gnius.hr.repository.model.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * <p> 
 * Una entità che venga utilizzata in accezione multi-tenant, nel caso di HuRes con indicazione del codice della società (tabella hr_societa)
 * </p>
 * 
 * @author gianluca
 * @see Societa
 * @see BasePanacheEntity
 */
@MappedSuperclass
public abstract class TenantPanacheEntity extends BasePanacheEntity {

	/** colonna che contiene il codice della società che fa da discriminante in una situazione di multi tenancy
	 * 
	 */
	@Column(name = "societa", length = 8, nullable = false)
	public String societa;
	
    @Override
    public String toString() {
        return super.toString();
    }
	
}
