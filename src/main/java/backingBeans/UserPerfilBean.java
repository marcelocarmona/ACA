package backingBeans;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.User;
import acceso.HiberjpaFactoryDAO;
import acceso.UserDAO;

@ManagedBean
@RequestScoped
public class UserPerfilBean extends Controller{
	

	public User getUser() {
		return getSessionBean().getUser();
	}

	public String merge(){
		UserDAO userDAO = HiberjpaFactoryDAO.getInstance().getUser();
		try {
			userDAO.modificar(this.getUser());
		} catch (Exception e) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),  null);  
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos modificados",  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);
		return null;
	}
}