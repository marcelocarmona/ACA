package acceso;

import java.util.List;

import javax.persistence.TypedQuery;

import anotations.Transactional;
import model.Socio;
import model.Unidad;
import model.User;

public class UserDAOhiberjpa extends GeneralDAOhiberjpa<User> implements UserDAO {

	public UserDAOhiberjpa() {
		super(User.class);
	}

	@Transactional(readOnly=true)
	public User findUser(String name) {
		TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class);
		q.setParameter("name",name);	
		List<User> results = q.getResultList();
		
		if(!results.isEmpty()){
			// ignores multiple results
			return results.get(0);
		}
		
		return null;
	}

	@Transactional(readOnly=true)
	public List<User> listar(Unidad userUnidad) {
		TypedQuery<User> q = em.createQuery("SELECT u FROM User u JOIN u.unidad uni WHERE uni.id = :id", User.class);
		q.setParameter("id",userUnidad.getId());	
		List<User> results = q.getResultList();
		return results;
	}

	@Transactional(readOnly=true)
	public List<User> noSocioList() {
		TypedQuery<User> q = em.createQuery("SELECT u FROM User u JOIN u.profiles p WHERE p in (SELECT n.id FROM NoSocio n) ", User.class);	
		List<User> results = q.getResultList();
		return results;
	}
	
	@Transactional(readOnly=true)
	public List<User> socioList() {
		TypedQuery<User> q = em.createQuery("SELECT u FROM User u JOIN u.profiles p WHERE p in (SELECT s FROM Socio s) ", User.class);	
		List<User> results = q.getResultList();
		return results;
	}
	
	@Transactional(readOnly=true)
	public List<User> socioList(Unidad unidad) {
		TypedQuery<User> q = em.createQuery("SELECT u FROM Unidad uni JOIN uni.users u JOIN u.profiles p WHERE uni.id = :id AND p in (SELECT s FROM Socio s) ", User.class);	
		q.setParameter("id", unidad.getId());
		List<User> results = q.getResultList();
		return results;
	}

	@Transactional(readOnly=true)
	public User find(Socio socio) {
		TypedQuery<User> q = em.createQuery("SELECT u FROM User u JOIN u.profiles p WHERE p in (SELECT s FROM Socio s WHERE s.id = :id) ", User.class);
		q.setParameter("id",socio.getId());	
		List<User> results = q.getResultList();
		
		if(!results.isEmpty()){
			// ignores multiple results
			return results.get(0);
		}
		
		return null;
	}


	

}
