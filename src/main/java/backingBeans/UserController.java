package backingBeans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import model.AdministradorDeUnidad;
import model.NoSocio;
import model.OperadorDeUnidad;
import model.Profile;
import model.Socio;
import model.SocioVirtual;
import model.Unidad;
import model.User;
import acceso.HiberjpaFactoryDAO;
import acceso.UnidadDAO;
import acceso.UserDAO;

@ManagedBean
@ViewScoped
public class UserController extends Controller {
	
	// DAOs related variables
	private UserDAO userDAO = HiberjpaFactoryDAO.getInstance().getUser();
	
	// Domain model related variables
	private User user = new User(new Unidad());
	private List<User> users = list();
	private Set<String> profiles = new HashSet<String>();

	/**
	 * Metodo hardcode para poder utilizar el multiCheckbox
	 * @param e
	 */
	public void profileChanged( ValueChangeEvent e){
		
		@SuppressWarnings("unchecked")
		Set<String> newSet = (Set<String>)e.getNewValue();
		@SuppressWarnings("unchecked")
		Set<String> oldSet = (Set<String>)e.getOldValue();		
		
		Set<String> tempNewSet = new HashSet<String>();
		Set<String> tempOldSet = new HashSet<String>();
		
		tempNewSet.addAll(newSet);
		tempOldSet.addAll(oldSet);		

		tempNewSet.removeAll(oldSet);
		tempOldSet.removeAll(newSet);
		
		for (String profileString : tempNewSet) {
			if(profileString.equals("Operador")) user.add(new OperadorDeUnidad()); else
			if(profileString.equals("Administrador")) user.add(new AdministradorDeUnidad()); else
			if(profileString.equals("NoSocio")) user.add(new NoSocio()); else
			if(profileString.equals("Socio")) user.add(new Socio()); else
			if(profileString.equals("SocioVirtual")) user.add(new SocioVirtual());
		}
		
		for (String profileString : tempOldSet) {
			if(profileString.equals("Operador")) user.remove(new OperadorDeUnidad()); else
			if(profileString.equals("Administrador")) user.remove(new AdministradorDeUnidad()); else
			if(profileString.equals("NoSocio")) user.remove(new NoSocio()); else
			if(profileString.equals("Socio")) user.remove(new Socio()); else
			if(profileString.equals("SocioVirtual")) user.remove(new SocioVirtual());

		}
	}

	/**
	 * HookMethod para verificar los permisos segun el profile
	 */
	public boolean accessPermittedHook() {
		return sessionBean.getUser().esAdministradorDeUnidad() || sessionBean.getUser().esOperadorDeUnidad();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	//listo desde este get
	public List<User> getUsers() {
		users = list();
		return users;
	}

	public void setusers(List<User> users) {
		this.users = users;
	}
    
    public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public Set<String> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<String> profiles) {
		this.profiles = profiles;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void edit(User user){
    	this.user = user;
    	profiles = user.getStringProfiles();
    }

	public void save(){
		userDAO.guardar(user);
		user = new User(new Unidad());
		profiles =  new HashSet<String>();
	}
	
	public void remove (User user){
		userDAO.eliminar(user.getId());
	}

	public void merge(){
		// merge en el metodo profileChanged (esta hardcodeado pero funciona)
		userDAO.modificar(this.user);
		user = new User(new Unidad());
		profiles =  new HashSet<String>();
	}

	public List<User> list(){
		if (sessionBean != null){
			if( sessionBean.islogin()){
				if(sessionBean.getUser().esAdministradorDeUnidadCentral() || sessionBean.getUser().esOperadorDeUnidadCentral()){
					return userDAO.listar();
				} else 
				if(sessionBean.getUser().esAdministradorDeUnidad() || sessionBean.getUser().esOperadorDeUnidad()){
					Unidad userUnidad = sessionBean.getUser().getUnidad();
					return userDAO.listar(userUnidad);
				}
			}
		}
		return null;
	}
	
	public List<User> getUsuarios(){
		return userDAO.listar();
	}
	
	public List<Unidad> getUnidades(){
		UnidadDAO unidadDAO = HiberjpaFactoryDAO.getInstance().getUnidad();
		if(sessionBean.getUser().esAdministradorDeUnidadCentral() || sessionBean.getUser().esOperadorDeUnidadCentral()){
			return unidadDAO.listar();
		} else {
			List<Unidad> myUnidad = new ArrayList<Unidad>();
			myUnidad.add(sessionBean.getUser().getUnidad());
			return myUnidad;
		}
	}
	
	public  List<Profile> getAllProfiles(){
		List<Profile> profiles = new ArrayList<Profile>();
		if(sessionBean.getUser().esAdministradorDeUnidad()){
			profiles.add(new OperadorDeUnidad());
			profiles.add(new AdministradorDeUnidad());
		}
		profiles.add(new NoSocio());
		profiles.add(new Socio());
		profiles.add(new SocioVirtual());
		return profiles;
	}



}