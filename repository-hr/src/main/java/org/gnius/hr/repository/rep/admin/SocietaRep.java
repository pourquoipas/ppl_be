package org.gnius.hr.repository.rep.admin;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;

import org.gnius.hr.repository.model.admin.Societa;
import org.gnius.hr.repository.model.common.PanacheFindBuilder;
import org.gnius.hr.repository.model.common.Search;
import org.gnius.hr.repository.rep.common.AbstractPplRepository;
import org.gnius.hr.repository.rep.common.PplRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@Path("v1/societa")
@ApplicationScoped
public class SocietaRep extends AbstractPplRepository<Societa> implements PplRepository<Societa> {

	@Override
	public Societa findById(String id) {
		return Societa.findById(id);
	}

	@Override
	public List<Societa> listAll() {
		return Societa.listAll();
	}

	@Override
	public void updateValues(Societa persisted, Societa provided) {
		persisted.codice = provided.codice;
		persisted.descrizione = provided.descrizione;
		persisted.ruoloAccesso = provided.ruoloAccesso;
	}

	@Override
	public PanacheQuery<Societa> preparaQuery(Search<Societa> search) {
		String find = "";
		PanacheFindBuilder pfb = new PanacheFindBuilder();
		if (search.eq != null) {
			pfb.addEq("codice", search.eq.codice, false);
			pfb.addEq("descrizione", search.eq.descrizione, false);
		}
		if (search.like != null) {
			pfb.addLike("codice", search.like.codice, false);
			pfb.addLike("descrizione", search.like.descrizione, false);
		}
		if (search.ge != null) {
			pfb.addGe("codice", search.ge.codice, false);
			pfb.addGe("descrizione", search.ge.descrizione, false);
		}
		if (search.le != null) {
			pfb.addLe("codice", search.le.codice, false);
			pfb.addLe("descrizione", search.le.descrizione, false);
		}

		find = pfb.getQuery();
		if (find != null && find.length() > 0) {
			 return Societa.find(find, pfb.getParams());
		}
		return Societa.findAll();
	}

//    @POST
//    @Transactional
//    @Path("/new")
//    public Response createNew(Societa entity) {
//    	return create(entity);
//    }
	
	
}
