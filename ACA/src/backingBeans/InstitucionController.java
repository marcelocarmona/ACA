package backingBeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.Institucion;
import model.User;
import acceso.FactoryDAO;
import acceso.HiberjpaFactoryDAO;
import acceso.InstitucionDAO;
import acceso.UnidadCentralDAO;
import acceso.UserDAO;

@ManagedBean
public class InstitucionController {
	
	private Institucion institucion = new Institucion();
	

	public Institucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}
	
    public void addMessage(String summary) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  

	public String save(){
		FactoryDAO factoryDAO = new HiberjpaFactoryDAO();
		InstitucionDAO institucionDAO = factoryDAO.getInstitucion();
		institucionDAO.guardar(institucion);
		return "exito";
	}
	
	public void remove (long id){
		FactoryDAO factoryDAO = new HiberjpaFactoryDAO();
		InstitucionDAO institucionDAO = factoryDAO.getInstitucion();
		UnidadCentralDAO uniDAO = factoryDAO.getUnidadCentral();
		//unidad central
		System.out.println(uniDAO.encontrar(1).getProductos().get(1));
		//addMessage(uniDAO.encontrar(1).getMail());

	}

	public void merge (Institucion inst){
		FactoryDAO factoryDAO = new HiberjpaFactoryDAO();
		InstitucionDAO institucionDAO = factoryDAO.getInstitucion();
		institucionDAO.modificar(inst);
	}

	public List<Institucion> getList(){
		FactoryDAO factoryDAO = new HiberjpaFactoryDAO();
		InstitucionDAO institucionDAO = factoryDAO.getInstitucion();
		return institucionDAO.listar();
	}
}