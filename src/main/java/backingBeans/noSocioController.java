package backingBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import acceso.HiberjpaFactoryDAO;
import acceso.NoSocioDAO;
import acceso.UserDAO;
import model.Institucion;
import model.NoSocio;
import model.User;

@ManagedBean
@RequestScoped
public class noSocioController extends Controller{
	
	// Domain model related variables
	private Institucion institucion = new Institucion();
	private User user = new User();
	
	//DAO
	NoSocioDAO noSocioDAO = HiberjpaFactoryDAO.getInstance().getNoSocio();
	
	public Institucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * HookMethod para verificar los permisos segun el profile
	 */
	public boolean accessPermittedHook() {
		return sessionBean.getUser().esAdministradorDeUnidad() || sessionBean.getUser().esOperadorDeUnidad();
	}


	//Instituciones del usuario NoSocio
	public List<Institucion> getInstituciones(){
		return noSocioDAO.getInstituciones(sessionBean.getUser().getProfileNoSocio());
	}
	
	public List<Institucion> getInstituciones(User user){
		user = HiberjpaFactoryDAO.getInstance().getUser().encontrar(user.getId());
		return noSocioDAO.getInstituciones(user.getProfileNoSocio());
	}
	
	public List<User> getUsuarios(){
		UserDAO userDAO = HiberjpaFactoryDAO.getInstance().getUser();
		return userDAO.noSocioList();
	}
	
	public void asignar(){
		user = HiberjpaFactoryDAO.getInstance().getUser().encontrar(user.getId());
		NoSocio noSocio = noSocioDAO.encontrar(user.getProfileNoSocio().getId());
		List<Institucion> instituciones = noSocioDAO.getInstituciones(noSocio);
		instituciones.add(institucion);
		noSocio.setInstituciones(instituciones);
		noSocioDAO.modificar(noSocio);
	}
	
	public void remove(User user,Institucion institucion){
		user = HiberjpaFactoryDAO.getInstance().getUser().encontrar(user.getId());
		NoSocio noSocio = noSocioDAO.encontrar(user.getProfileNoSocio().getId());
		
		noSocioDAO.removeInstitucion(noSocio,institucion);
	}



}
