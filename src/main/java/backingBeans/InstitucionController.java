package backingBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import model.Institucion;
import acceso.HiberjpaFactoryDAO;
import acceso.InstitucionDAO;
import acceso.UnidadCentralDAO;

@ManagedBean
@ViewScoped
public class InstitucionController extends Controller {
	
	// DAOs related variables
	private InstitucionDAO institucionDAO = HiberjpaFactoryDAO.getInstance().getInstitucion();
	
	// Domain model related variables
	private Institucion institucion = new Institucion();
	private List<Institucion> instituciones = list();
	
	public Institucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}
	
	//listo desde este get
	public List<Institucion> getInstituciones() {
		instituciones = list();
		return instituciones;
	}

	public void setInstituciones(List<Institucion> instituciones) {
		this.instituciones = instituciones;
	}
	
	public InstitucionDAO getInstitucionDAO() {
		return institucionDAO;
	}

	public void setInstitucionDAO(InstitucionDAO institucionDAO) {
		this.institucionDAO = institucionDAO;
	}
    
    public void edit(Institucion institucion){
    	this.institucion = institucion;
    }

	public void save(){
		UnidadCentralDAO unidadCentralDAO = HiberjpaFactoryDAO.getInstance().getUnidadCentral();
		unidadCentralDAO.save(institucion);
		institucion = new Institucion();
	}

	public void test(){
System.out.println("TEST------------");
	}
	
	public void test(ActionEvent event){
System.out.println("TEST------------");
	      if (event.getComponent().getAttributes().get("node") != null) { 
			try {
				System.out.println("ALGO------------");
	         } catch (Exception e) {
	        	 System.out.println("ERRORRRRRr--------------------------TEST------------"+e);
	         }
	      } else System.out.println("esNull");
		
	}
	

	/**
	 * Si algun NoSocio tiene esta institucion se la borro
	 * @param institucion
	 */
	public void remove (Institucion institucion){
		UnidadCentralDAO unidadCentralDAO = HiberjpaFactoryDAO.getInstance().getUnidadCentral();
    	if(institucionDAO.hasNoSocio(institucion)){
    		unidadCentralDAO.removeAllNoSocios(institucion);
    		addMessage("Se elimino "+institucion.getName()+" de los NoSocios");
    	};
		institucionDAO.eliminar(institucion.getId());
	}


	public void merge(){
		institucionDAO.modificar(this.institucion);
		institucion = new Institucion();
	}


	public List<Institucion> list(){
		return institucionDAO.listar();
	}
}