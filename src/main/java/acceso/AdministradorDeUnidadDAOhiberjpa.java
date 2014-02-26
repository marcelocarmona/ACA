package acceso;

import java.util.List;

import javax.persistence.TypedQuery;

import anotations.Transactional;
import model.AdministradorDeUnidad;
import model.User;

public class AdministradorDeUnidadDAOhiberjpa extends
		GeneralDAOhiberjpa<AdministradorDeUnidad> implements
		AdministradorDeUnidadDAO {

	public AdministradorDeUnidadDAOhiberjpa() {
		super(AdministradorDeUnidad.class);

	}
	
	@Transactional(readOnly=true)
	public AdministradorDeUnidad find(User user) {
		TypedQuery<AdministradorDeUnidad> q = em.createQuery("SELECT a FROM AdministradorDeUnidad a JOIN a.user u WHERE u.id = :id", AdministradorDeUnidad.class);
		q.setParameter("id",user.getId());	
		List<AdministradorDeUnidad> results = q.getResultList();
		
		if(!results.isEmpty()){
			// ignores multiple results
			return results.get(0);
		}
		
		return null;
	}


}
