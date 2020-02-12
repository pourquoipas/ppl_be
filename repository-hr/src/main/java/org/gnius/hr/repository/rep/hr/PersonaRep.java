package org.gnius.hr.repository.rep.hr;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;

import org.gnius.hr.repository.model.base.table.Comune;
import org.gnius.hr.repository.model.base.table.Provincia;
import org.gnius.hr.repository.model.base.table.Stato;
import org.gnius.hr.repository.model.base.table.TitoloStudio;
import org.gnius.hr.repository.model.common.PanacheFindBuilder;
import org.gnius.hr.repository.model.common.Search;
import org.gnius.hr.repository.model.hr.ContattoPersona;
import org.gnius.hr.repository.model.hr.DomicilioPersona;
import org.gnius.hr.repository.model.hr.Persona;
import org.gnius.hr.repository.model.hr.ResidenzaPersona;
import org.gnius.hr.repository.rep.common.AbstractTenantRepository;
import org.gnius.hr.repository.rep.common.TenantRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@Path("v1/persona")
@ApplicationScoped
public class PersonaRep extends AbstractTenantRepository<Persona> implements TenantRepository<Persona> {

	@Override
	public PanacheQuery<Persona> find(String find, Map<String, Object> params) {
		return Persona.find(find, params);
	}

	@Override
	public PanacheQuery<Persona> findAll() {
		return Persona.findAll();
	}

	@Override
	public Persona findById(String id) {
		return Persona.findById(id);
	}

	@Override
	public List<Persona> listAll() {
		return Persona.listAll();
	}

	@Override
	public void updateValues(Persona persisted, Persona provided) {
		persisted.codice = provided.codice;
		persisted.cognome = provided.cognome;
		persisted.nome = provided.nome;
		persisted.sesso = provided.sesso;
		persisted.statoCivile = provided.statoCivile;
		persisted.dataNascita = provided.dataNascita;
		persisted.statoNascitaId = provided.statoNascitaId;
		persisted.statoNascita = provided.statoNascita;
		persisted.provinciaNascitaId = provided.provinciaNascitaId;
		persisted.provinciaNascita = provided.provinciaNascita;
		persisted.comuneNascitaId = provided.comuneNascitaId;
		persisted.comuneNascita = provided.comuneNascita;
		persisted.cittadinanzaId = provided.cittadinanzaId;
		persisted.cittadinanza = provided.cittadinanza;
		persisted.codiceFiscale = provided.codiceFiscale;
		persisted.titoloStudioId = provided.titoloStudioId;
		persisted.titoloStudio = provided.titoloStudio;
		persisted.titoloStudioDesc = provided.titoloStudioDesc;
		persisted.titoloStudioAnno = provided.titoloStudioAnno;
		if (provided.residenza != null) {
			if (persisted.residenza == null) {
				persisted.residenza = new ResidenzaPersona();
				persisted.residenza.persona = persisted;
			}
			persisted.residenza.statoId = provided.residenza.statoId;
			persisted.residenza.stato = provided.residenza.stato;
			persisted.residenza.provinciaId = provided.residenza.provinciaId;
			persisted.residenza.provincia = provided.residenza.provincia;
			persisted.residenza.comuneId = provided.residenza.comuneId;
			persisted.residenza.comune = provided.residenza.comune;
			persisted.residenza.cap = provided.residenza.cap;
			persisted.residenza.localita = provided.residenza.localita;
			persisted.residenza.indirizzo = provided.residenza.indirizzo;
			persisted.residenza.civico = provided.residenza.civico;
			persisted.residenza.interno = provided.residenza.interno;
			persisted.residenza.scala = provided.residenza.scala;
			persisted.residenza.edificioDesc = provided.residenza.edificioDesc;
			persisted.residenza.aggiuntive = provided.residenza.aggiuntive;
		} else {
			// TODO Non posso metterla a null !!! 
		}
		if (provided.domicilio != null) {
			if (persisted.domicilio == null) {
				persisted.domicilio = new DomicilioPersona();
				persisted.domicilio.persona = persisted;
			}
			persisted.domicilio.statoId = provided.domicilio.statoId;
			persisted.domicilio.stato = provided.domicilio.stato;
			persisted.domicilio.provinciaId = provided.domicilio.provinciaId;
			persisted.domicilio.provincia = provided.domicilio.provincia;
			persisted.domicilio.comuneId = provided.domicilio.comuneId;
			persisted.domicilio.comune = provided.domicilio.comune;
			persisted.domicilio.cap = provided.domicilio.cap;
			persisted.domicilio.localita = provided.domicilio.localita;
			persisted.domicilio.indirizzo = provided.domicilio.indirizzo;
			persisted.domicilio.civico = provided.domicilio.civico;
			persisted.domicilio.interno = provided.domicilio.interno;
			persisted.domicilio.scala = provided.domicilio.scala;
			persisted.domicilio.edificioDesc = provided.domicilio.edificioDesc;
			persisted.domicilio.aggiuntive = provided.domicilio.aggiuntive;
		} else {
			// TODO Non posso metterla a null !!! 
		}
		// Contatti
		if (provided.contatti != null && provided.contatti.size() > 0) {
			// Aggiorno tutti i contatti esistenti, presenti anche in provided, e rimuovo quelli assenti.
			List<ContattoPersona> newList = persisted.contatti.stream().
				filter(pers_c -> 
					provided.contatti.stream()
						.anyMatch(prov_c -> 
							{ 	if (prov_c.uuid != null && prov_c.uuid.equals(pers_c.uuid)) {
									pers_c.contatto = prov_c.contatto;
									pers_c.tipo = prov_c.tipo;
									return true;
								}
								return false;
							})
				).collect(Collectors.toList());
			
			// Aggiungo tutti i contatti presenti in provided e senza uuid
			newList.addAll(provided.contatti.stream()
					.filter(prov_c -> prov_c.uuid == null)							// << Filtro quelli con uuid a null
					.map(prov_c -> {prov_c.persona = persisted; return prov_c; }) 	// << Imposto persona
					.collect(Collectors.toList()));									// << ottengo una lista da aggiungere
					
			
			persisted.contatti = newList;
		} else {
			persisted.contatti.clear();
		}
		
	}
	
	@Override
	public void fillFindBuilder(PanacheFindBuilder pfb, Search<Persona> search) {
		super.fillFindBuilder(pfb, search);
		if (search.eq != null) {
			pfb.addEq("codice", search.eq.codice, false);
			pfb.addEq("cognome", search.eq.cognome, false);
			pfb.addEq("nome", search.eq.nome, false);
			pfb.addEq("sesso", search.eq.sesso, false);
			pfb.addEq("statoCivile", search.eq.statoCivile, false);
			pfb.addEq("dataNascita", search.eq.dataNascita, false);
			pfb.addEq("statoNascitaId", search.eq.statoNascitaId, false);
			pfb.addEq("provinciaNascitaId", search.eq.provinciaNascitaId, false);
			pfb.addEq("comuneNascitaId", search.eq.comuneNascitaId, false);
			pfb.addEq("cittadinanzaId", search.eq.cittadinanzaId, false);
			pfb.addEq("codiceFiscale", search.eq.codiceFiscale, false);
			pfb.addEq("titolostudioId", search.eq.titoloStudioId, false);
		}
		if (search.like != null) {
			pfb.addLike("codice", search.like.codice, false);
			pfb.addLike("cognome", search.like.cognome, false);
			pfb.addLike("nome", search.like.nome, false);
			pfb.addLike("codiceFiscale", search.like.codiceFiscale, false);
		}
		if (search.ge != null) {
			pfb.addGe("codice", search.ge.codice, false);
			pfb.addGe("cognome", search.ge.cognome, false);
			pfb.addGe("nome", search.ge.nome, false);
			pfb.addGe("dataNascita", search.ge.dataNascita, false);
		}
		if (search.le != null) {
			pfb.addLe("codice", search.le.codice, false);
			pfb.addLe("cognome", search.le.cognome, false);
			pfb.addLe("nome", search.le.nome, false);
			pfb.addLe("dataNascita", search.le.dataNascita, false);
		}
	}
	
	@Override
	public Persona autoInit(Persona entity) {
		Persona rv = super.autoInit(entity);
		if (rv.statoNascitaId != null) {
			rv.statoNascita = Stato.findAsTable(rv.statoNascitaId);
		}
		if (rv.comuneNascitaId != null) {
			rv.comuneNascita = Comune.findAsTable(rv.comuneNascitaId);
		}
		if (rv.provinciaNascitaId != null) {
			rv.provinciaNascita = Provincia.findAsTable(rv.provinciaNascitaId);
		}
		if (rv.cittadinanzaId != null) {
			rv.cittadinanza = Stato.findAsTable(rv.cittadinanzaId);
		}
		if (rv.titoloStudioId != null) {
			rv.titoloStudio = TitoloStudio.findAsTable(rv.titoloStudioId);
		}
		if (rv.residenza != null) {
			if (rv.residenza.statoId != null) {
				rv.residenza.stato = Stato.findAsTable(rv.residenza.statoId);
			}
			if (rv.residenza.comuneId != null) {
				rv.residenza.comune = Comune.findAsTable(rv.residenza.comuneId);
			}
			if (rv.residenza.provinciaId != null) {
				rv.residenza.provincia = Provincia.findAsTable(rv.residenza.provinciaId);
			}
		}
		if (rv.domicilio != null) {
			if (rv.domicilio.statoId != null) {
				rv.domicilio.stato = Stato.findAsTable(rv.domicilio.statoId);
			}
			if (rv.domicilio.comuneId != null) {
				rv.domicilio.comune = Comune.findAsTable(rv.domicilio.comuneId);
			}
			if (rv.domicilio.provinciaId != null) {
				rv.domicilio.provincia = Provincia.findAsTable(rv.domicilio.provinciaId);
			}
		}
		return rv;
	}
	

}
