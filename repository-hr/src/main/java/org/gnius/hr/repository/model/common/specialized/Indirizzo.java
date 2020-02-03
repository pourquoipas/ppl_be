package org.gnius.hr.repository.model.common.specialized;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.gnius.hr.repository.model.base.table.Comune;
import org.gnius.hr.repository.model.base.table.Provincia;
import org.gnius.hr.repository.model.base.table.Stato;
import org.gnius.hr.repository.model.common.TablePanacheEntity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/** <p>Vedi standard poste per composizione indirizzo:<br>
 * https://www.poste.it/standard_composizione_indirizzi.pdf<br>
 * <ul>da 3 a 6 righe
 * <li>1 Destinatario (obbligatoria)</li>
 * <li>2 Aggiuntive (informazioni, presso, ecc) (facoltativa)</li>
 * <li>3 Edificio (scala, piano, interno, ecc) (facoltativa)</li>
 * <li>4 Indirizzo (qualificatore(*) + nome via + numero civico) (obbligatoria) (*) via, piazza, corso, ecc)</li>
 * <li>5 Localita (nell'ordine CAP, località destinazione, sigla provincia) (obbligatoria)</li>
 * <li>6 StatoEstero (SOLO PER ESTERO) (Obbligatoria se stato estero) </li>
 * </ul>
 * Per noi (vedi regole di composizione in enterprise/core)<br>
 * se c'è località scrivo quella, se manca scrivo descrizione comune.<br>
 * l'indirizzo deve comprendere il qualificatore ma non il civico.<br>
 * 
 * 
 * @author gianluca
 *
 */
@MappedSuperclass
public class Indirizzo extends PanacheEntityBase {

    @Override
    public String toString() {
    	// TODO
    	return this.getClass().getSimpleName();
        // return this.getClass().getSimpleName() + "<" + uuid + ">";
    }

	@Column(name="statoId", length=36)
	public String statoId;
	@Transient
	public TablePanacheEntity stato;

	@Column(name="provinciaId", length=36)
	public String provinciaId;
	@Transient
	public TablePanacheEntity provincia;
	
	@Column(name="comuneId", length=36)
	public String comuneId;
	@Transient
	public TablePanacheEntity comune;
	
	@Column(name="cap", length=5)
	public String cap;
	
	@Column(name="localita", length=30)
	public String localita;
	
	@Column(name="indirizzo", length=50)
	public String indirizzo;
	
	@Column(name="civico", length=10)
	public String civico;

	@Column(name="interno", length=10)
	public String interno;
	
	@Column(name="scala", length=10)
	public String scala;
	
	@Column(name="edificiodesc", length=100)
	public String edificioDesc;
	
	@Column(name="aggiuntive", length=100)
	public String aggiuntive;
	
}
