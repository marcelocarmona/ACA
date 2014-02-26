package acceso;

import java.util.List;

import javax.persistence.TypedQuery;

import anotations.Transactional;
import model.Institucion;
import model.NoSocio;
import model.User;

public class NoSocioDAOhiberjpa extends GeneralDAOhiberjpa<NoSocio> implements
		NoSocioDAO {

	public NoSocioDAOhiberjpa() {
		super(NoSocio.class);
	}
	
	
	@Transactional(readOnly=true)
	public NoSocio find(User user) {
		TypedQuery<NoSocio> q = em.createQuery("SELECT o FROM NoSocio o JOIN o.user u WHERE u.id = :id", NoSocio.class);
		q.setParameter("id",user.getId());	
		List<NoSocio> results = q.getResultList();
		
		if(!results.isEmpty()){
			// ignores multiple results
			return results.get(0);
		}
		
		return null;
	}
	
	@Transactional(readOnly=true)
	public List<Institucion> getInstituciones(NoSocio noSocio) {
		TypedQuery<Institucion> q = em.createQuery("SELECT i FROM NoSocio n JOIN n.instituciones i WHERE n.id = :id", Institucion.class);	
		q.setParameter("id",noSocio.getId());	
		List<Institucion> results = q.getResultList();
		return results;
	}
	
	@Transactional(readOnly=false)
	public void removeInstitucion(NoSocio noSocio,Institucion institucion) {
		//busco los objetos persistentes
		noSocio = em.find(NoSocio.class, noSocio.getId());
		institucion = em.find(Institucion.class, institucion.getId());
		
		noSocio.getInstituciones().remove(institucion);
	}
	
	


}
