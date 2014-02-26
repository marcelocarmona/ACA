package acceso;

import java.util.List;

import javax.persistence.TypedQuery;

import anotations.Transactional;
import model.Institucion;

public class InstitucionDAOhiberjpa extends GeneralDAOhiberjpa<Institucion> implements InstitucionDAO{

	public InstitucionDAOhiberjpa(){
		super(Institucion.class);
	}
	
	@Transactional(readOnly=true)
	public boolean hasNoSocio(Institucion institucion){
		//instituciones con Nosocios
		TypedQuery<Institucion> q = em.createQuery("SELECT DISTINCT i FROM NoSocio n JOIN n.instituciones i WHERE i.id = :id", Institucion.class);	
		q.setParameter("id", institucion.getId());
		List<Institucion> institucionList = q.getResultList();
		return institucionList.size() >= 1;
	}

}

