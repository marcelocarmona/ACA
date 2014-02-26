package backingBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import acceso.FactoryDAO;
import acceso.HiberjpaFactoryDAO;
import acceso.UserDAO;
import model.User;

@ManagedBean(name="sessionBean")
@SessionScoped
public class SessionBean {

	private User user = null;
	
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String login(){
		FactoryDAO factoryDAO = new HiberjpaFactoryDAO();
		UserDAO userDAO = factoryDAO.getUser();
		
		User userOrNull = userDAO.findUser(userName);

		if (userOrNull != null && password.equals(userOrNull.getPassword())) {
			user = userOrNull;
//			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user",userOrNull);
			return "index";
		} else {
			String summary = "Error en el usuario y/o password";
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,  null);
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, message); 
			return null;
		}
	}
	
	public String logout(){
		user = null;
//		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index";
	}
	
	public boolean islogin(){
		return user != null;
	}
	
}
