package acceso;

import java.util.List;

import javax.persistence.TypedQuery;

import anotations.Transactional;
import model.SocioVirtual;
import model.User;

public class SocioVirtualDAOhiberjpa extends GeneralDAOhiberjpa<SocioVirtual>
		implements SocioVirtualDAO {

	public SocioVirtualDAOhiberjpa() {
		super(SocioVirtual.class);
	}
	
	@Transactional(readOnly=true)
	public SocioVirtual find(User user) {
		TypedQuery<SocioVirtual> q = em.createQuery("SELECT o FROM SocioVirtual o JOIN o.user u WHERE u.id = :id", SocioVirtual.class);
		q.setParameter("id",user.getId());	
		List<SocioVirtual> results = q.getResultList();
		
		if(!results.isEmpty()){
			// ignores multiple results
			return results.get(0);
		}
		
		return null;
	}

}
