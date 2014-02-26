package backingBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import acceso.HiberjpaFactoryDAO;

/**
 * Controller general contiene sessionBean y UI componets usado de forma general
 * @author Mclo
 *
 */
public class Controller {
	
	//State
	private boolean editing = false;
	
	//Injecting Managed Bean
	@ManagedProperty(value = "#{sessionBean}")
	protected SessionBean sessionBean;

	//must povide the setter method
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	
	public SessionBean getSessionBean() {
		return sessionBean;
	}
	
	public boolean isEditing() {
		return editing;
	}
	public void setEditing(boolean editing) {
		this.editing = editing;
	}
	public void addMessage(String summary) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    } 
	
	public void addInfoMessage(String summary) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    } 
	
	public boolean accessPermitted() {
		if (sessionBean != null){
			if( sessionBean.islogin()){
			    return accessPermittedHook();
			}
		}
		return false;
	}

	//Subclass responsibility
	public boolean accessPermittedHook(){
		System.out.println("Subclass responsibility");
		return false;
	}
	
	public boolean socioAlDia(){
		if (getSessionBean() != null){
			if( sessionBean.islogin()){
				if (sessionBean.getUser().esAdministradorDeUnidad() || sessionBean.getUser().esOperadorDeUnidad()){
					return true;
				} else if(sessionBean.getUser().esSocioVirtual())
					return HiberjpaFactoryDAO.getInstance().getSocio().alDia( sessionBean.getUser().getProfileSocioVirtual());
				 else if (sessionBean.getUser().esSocio())
					 return HiberjpaFactoryDAO.getInstance().getSocio().alDia( sessionBean.getUser().getProfileSocio());
			}
		}
		return false;
	}
	
	public String msgAlDia(){
		if(socioAlDia()) return "Como Socio se encuantra al dia";
		else return "Debe abonar sus cuotas";
	}
}
