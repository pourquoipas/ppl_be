package org.gnius.hr.repository.rep.common;

import java.util.Map;

import org.gnius.hr.repository.model.admin.Societa;
import org.gnius.hr.repository.model.common.PanacheFindBuilder;
import org.gnius.hr.repository.model.common.Search;
import org.gnius.hr.repository.model.common.TablePanacheEntity;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

/** <p>Repository + Rest resource di una tabella codice/descrizione/inizio/fine.
 * </p>
 * <p>
 * Salvo necessità non re-implementate <i>preparaQuery</i> ma eseguite l'ovveride di 
 * <b>fillFindBuilder</b> chiamando la super se non dovete modificare la gestione delle ricerche 
 * relativamente ai campi di TablePanacheEntity.
 * </p>
 * @author gianluca
 *
 * @param <T>
 */
public abstract class AbstractTableRepository<T extends TablePanacheEntity> extends AbstractTenantRepository<T> implements TableRepository<T> {
	
	@Override
	public void updateValues(T persisted, T provided) {
		persisted.codice = provided.codice;
		persisted.descrizione = provided.descrizione;
		persisted.inizio = provided.inizio;
		persisted.fine = provided.fine;
	}

	/** Do override of this to add your own parameters 
	 * 
	 */
	public void fillFindBuilder(PanacheFindBuilder pfb, Search<T> search) {
		super.fillFindBuilder(pfb, search);
		if (search.eq != null) {
			pfb.addEq("codice", search.eq.codice, false);
			pfb.addEq("descrizione", search.eq.descrizione, false);
			pfb.addEq("inizio", search.eq.inizio, false);
			pfb.addEq("fine", search.eq.fine, false);
			if (search.eq.attivo != null) {
				if (search.eq.attivo) {
					if (search.eq.valido != null) {
						pfb.add(" (inizio IS NULL OR inizio<=:valido) AND (fine IS NULL OR fine <= :valido) ", "valido", search.eq.valido);
					} else {
						pfb.addConst(" (fine IS NULL) ");
					}
				} else {
					if (search.eq.valido != null) {
						pfb.add(" (inizio>:valido OR fine<:valido) ", "valido", search.eq.valido);
					} else {
						pfb.addConst(" (fine IS NOT NULL) ");
					}
				}
			}
		}
		if (search.like != null) {
			pfb.addLike("codice", search.like.codice, false);
			pfb.addLike("descrizione", search.like.descrizione, false);
		}
		if (search.ge != null) {
			pfb.addGe("codice", search.ge.codice, false);
			pfb.addGe("descrizione", search.ge.descrizione, false);
			pfb.addGe("inizio", search.ge.inizio, false);
			pfb.addGe("fine", search.ge.fine, false);
		}
		if (search.le != null) {
			pfb.addLe("codice", search.le.codice, false);
			pfb.addLe("descrizione", search.le.descrizione, false);
			pfb.addLe("inizio", search.le.inizio, false);
			pfb.addLe("fine", search.le.fine, false);
		}
		
	}
	

}
