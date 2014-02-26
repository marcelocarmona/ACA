package acceso;

import java.util.List;

import javax.persistence.TypedQuery;

import anotations.Transactional;
import model.Cuota;
import model.Socio;
import model.User;

public class SocioDAOhiberjpa extends GeneralDAOhiberjpa<Socio> implements
		SocioDAO {

	public SocioDAOhiberjpa() {
		super(Socio.class);
	}
	
	@Transactional(readOnly=true)
	public Socio find(User user) {
		TypedQuery<Socio> q = em.createQuery("SELECT o FROM Socio o JOIN o.user u WHERE u.id = :id", Socio.class);
		q.setParameter("id",user.getId());	
		List<Socio> results = q.getResultList();
		
		if(!results.isEmpty()){
			// ignores multiple results
			return results.get(0);
		}
		
		return null;
	}

	@Transactional(readOnly=true)
	public boolean alDia(Socio socio) {
		TypedQuery<Cuota> q = em.createQuery("SELECT c FROM Cuota c JOIN c.socio s WHERE s.id = :id AND c.montoAPagar > 0", Cuota.class);
		q.setParameter("id",socio.getId());	
		List<Cuota> results = q.getResultList();
		if(results.isEmpty()){
			return true;
		}else return false;
	}

}
