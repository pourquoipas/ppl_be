package org.gnius.hr.repository.model.common;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Query;
import javax.persistence.Transient;

import org.gnius.hr.util.DateUtil;
import org.hibernate.transform.Transformers;

import io.quarkus.hibernate.orm.panache.runtime.JpaOperations;

/** <h3>Gestione base di una tabella con date di validità (inizio e fine).</h3>
 * <p>
 * Utilizzabile anche per gestire una tabella senza date validità, in effetti l'assenza 
 * delle date identifica il record come valido.
 * </p>
 * <ul> Implelemtazione gestione della validità:<br>
 * <li> Le date sono inclusive, ovvero il giorno di inizio la tabella è valida, ed il giorno di fine la tabella è valida</li>
 * <li> inizio == null indica che la tabella è valida da SEMPRE fino ad una eventuale data fine</li>
 * <li> fine == null indica che la tabella è valida fino a SEMPRE a partire da una eventuale data inizio</li>
 * <li><ul>un record è attivo rispetto ad una DATA VALIDA se:
 *     <li>la data inizio è null o la data inizio è <= della data</li>
 *     <li>la data fine è null o la la data fine è >= della data</li>
 *     </ul>
 * </li>
 * <li>un record è attivo rispetto ad una DATA NULL se la data fine è null</li>
 * </ul>
 * @author gianluca
 *
 */
@MappedSuperclass
public class TablePanacheEntity extends TenantPanacheEntity {

	/** Campo contenente il codice della tabella */
	@Column(name = "codice", length = 25, nullable = false)
	public String codice;
	
	/** Campo contenente la descrizione della tabella */
	@Column(name = "descrizione", length = 100, nullable = false)
	public String descrizione;
	
//	/** Campo contenente lo stato (attivo Si/No) della tabella */
//	@Column(name = "attivo", nullable = true)
//	public Boolean attivo;
//	
	/** Campo contenente la data di inizio validità della tabella (inclusiva, il giorno di inizio la tabella era valida) */
	@Column(name = "inizio", nullable = true)
	public LocalDate inizio;
	
	/** Campo contenente la data di fine validità della tabella  (inclusiva, il giorno di fine la tabella era valida) */
	@Column(name = "fine", nullable = true)
	public LocalDate fine;
	
	public boolean attivo(LocalDate data) {
		if (data == null) {
			return fine == null;
		} else {
			return DateUtil.isIn(inizio, fine, data);
		}
	}

	@Transient
	public LocalDate valido;
	@Transient
	public Boolean attivo;
	
	public TablePanacheEntity() {
		
	}
	public TablePanacheEntity(String uuid, String codice, String descrizione) {
		this.uuid = uuid;
		this.codice = codice;
		this.descrizione = descrizione;
	}
	
	public static TablePanacheEntity findByTableAndId(String table, String uuid) {
		
//		@SuppressWarnings({ "unchecked", "deprecation" })
//		List<TablePanacheEntity> postDTOs = (List<TablePanacheEntity>)JpaOperations.getEntityManager()
//				.createQuery(
//						" SELECT uuid, codice, descrizione FROM " + 
//						table + 
//						" WHERE uuid = :uuid")
//				.setParameter( "uuid", uuid)
//				.unwrap( org.hibernate.query.Query.class )
//				.setResultTransformer( Transformers.aliasToBean( TablePanacheEntity.class ) )
//				.getResultList();		
//		if (postDTOs != null && postDTOs.size() > 0) {
//			return postDTOs.get(0);
//		}
//		return null;
		
		Query q = JpaOperations.getEntityManager().createQuery(" SELECT new org.gnius.hr.repository.model.common.TablePanacheEntity(uuid, codice, descrizione) FROM " + table + " WHERE uuid = :uuid", TablePanacheEntity.class);
		q.setParameter("uuid", uuid);
		// q.setResultTransformer(Transformers.aliasToBean(TablePanacheEntity.class));
		try {
		return (TablePanacheEntity)q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
//		PanacheQuery<PanacheEntityBase> query = TablePanacheEntity.find(" SELECT uuid, codice, descrizione FROM " + table + " WHERE uuid = :uuid", uuid);
//		query.singleResult();
	}
}
