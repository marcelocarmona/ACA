package acceso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import anotations.Transactional;

public class GeneralDAOhiberjpa<T> implements GeneralDAO<T>{

	public EntityManager em;
	
	private Class<T> type;
	
	public GeneralDAOhiberjpa(Class<T> t) {
	        type = t;
	}

	@Transactional(readOnly=true)
	public List<T> listar() {
		TypedQuery<T> q = em.createQuery("from "+type.getName(), type);
		List<T> result =  q.getResultList();
		return result;
	}

	@Transactional(readOnly=false)
	public void guardar(T t) {
		em.persist(t);
	}

	@Transactional(readOnly=false)
	public void eliminar(long id) {
		em.remove(em.getReference(type, id));
	}

	@Transactional(readOnly=true)
	public T encontrar(long id) {
		return em.find(type, id);
	}

	@Transactional(readOnly=false)
	public void modificar(T t) {
		em.merge(t);
	}
}
