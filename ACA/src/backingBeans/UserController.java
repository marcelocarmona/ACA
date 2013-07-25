package backingBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import model.User;
import acceso.FactoryDAO;
import acceso.HiberjpaFactoryDAO;
import acceso.UserDAO;

@ManagedBean
public class UserController {
	
	private User user = new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String save(){
		FactoryDAO factoryDAO = new HiberjpaFactoryDAO();
		UserDAO userDAO = factoryDAO.getUser();
		userDAO.guardar(user);
		return "exito";
	}
	
	public void remove(long id){
		FactoryDAO factoryDAO = new HiberjpaFactoryDAO();
		UserDAO userDAO = factoryDAO.getUser();
		userDAO.eliminar(id);
	}

	public void merge (User user){
		FactoryDAO factoryDAO = new HiberjpaFactoryDAO();
		UserDAO userDAO = factoryDAO.getUser();
		userDAO.modificar(user);
	}

	public List<User> getList(){
		FactoryDAO factoryDAO = new HiberjpaFactoryDAO();
		UserDAO userDAO = factoryDAO.getUser();
		return userDAO.listar();
	}
}