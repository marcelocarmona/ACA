package acceso;

import java.util.List;

import javax.persistence.TypedQuery;

import anotations.Transactional;
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

}
