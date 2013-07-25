package backingBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import acceso.FactoryDAO;
import acceso.HiberjpaFactoryDAO;
import acceso.UserDAO;

import model.User;

@ManagedBean
public class LoginBean {
	
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
	
	public String login(){
		FactoryDAO factoryDAO = new HiberjpaFactoryDAO();
		UserDAO userDAO = factoryDAO.getUser();
		
		User userOrNull = userDAO.findUser(userName);

		if (userOrNull != null && password.equals(userOrNull.getPassword())) {
			return "login";
//			HttpSession session = req.getSession(true);
//			String welcomePage = userOrNull.welcomePage();
//			session.setAttribute("welcomePage", welcomePage);
//			res.sendRedirect("./" + welcomePage);

		} else {
			String summary = "Error en el usuario y/o password";
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,  null);
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, message); 
			return null;
		}
	}
}
