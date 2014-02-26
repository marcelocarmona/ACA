package acceso;

import java.util.List;

import javax.persistence.TypedQuery;

import anotations.Transactional;
import model.OperadorDeUnidad;
import model.User;

public class OperadorDeUnidadDAOhiberjpa extends
		GeneralDAOhiberjpa<OperadorDeUnidad> implements OperadorDeUnidadDAO {

	public OperadorDeUnidadDAOhiberjpa() {
		super(OperadorDeUnidad.class);
	}
	
	@Transactional(readOnly=true)
	public OperadorDeUnidad find(User user) {
		TypedQuery<OperadorDeUnidad> q = em.createQuery("SELECT o FROM OperadorDeUnidad o JOIN o.user u WHERE u.id = :id", OperadorDeUnidad.class);
		q.setParameter("id",user.getId());	
		List<OperadorDeUnidad> results = q.getResultList();
		
		if(!results.isEmpty()){
			// ignores multiple results
			return results.get(0);
		}
		
		return null;
	}
}
