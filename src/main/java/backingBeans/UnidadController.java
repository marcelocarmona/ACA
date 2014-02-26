package backingBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Unidad;
import model.User;
import acceso.HiberjpaFactoryDAO;
import acceso.UnidadCentralDAO;
import acceso.UnidadDAO;
import acceso.UserDAO;

@ManagedBean
@ViewScoped
public class UnidadController extends Controller {
	
	// DAOs related variables
	private UnidadDAO unidadDAO = HiberjpaFactoryDAO.getInstance().getUnidad();
	
	// Domain model related variables
	private Unidad unidad = new Unidad(new User());
	private List<Unidad> unidades = list();

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	//listo desde este get
	public List<Unidad> getUnidades() {
		unidades = list();
		return unidades;
	}

	public void setUnidades(List<Unidad> unidades) {
		this.unidades = unidades;
	}

	public UnidadDAO getUnidadDAO() {
		return unidadDAO;
	}

	public void setUnidadDAO(UnidadDAO unidadDAO) {
		this.unidadDAO = unidadDAO;
	}

	public void edit(Unidad unidad){
    	this.unidad = unidad;
    }

	public void save(){
		UnidadCentralDAO unidadCentralDAO = HiberjpaFactoryDAO.getInstance().getUnidadCentral();
		unidadCentralDAO.save(unidad);
		unidad = new Unidad(new User());
	}
	
	public void remove (Unidad unidad){
		unidadDAO.eliminar(unidad.getId());
	}

	public void merge(){
		unidadDAO.modificar(this.unidad);
		unidad = new Unidad(new User());
	}

	public List<Unidad> list(){
		return unidadDAO.listar();
	}

	public List<User> getUsuarios(){
		UserDAO userDAO = HiberjpaFactoryDAO.getInstance().getUser();
		return userDAO.listar();
	}


}