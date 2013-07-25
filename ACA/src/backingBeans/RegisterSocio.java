package backingBeans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Socio;
import model.User;

import acceso.FactoryDAO;
import acceso.HiberjpaFactoryDAO;
import acceso.SocioDAO;
import acceso.UserDAO;

@ManagedBean(name="registerSocio")
@RequestScoped
public class RegisterSocio {
	
	private String name;
	private String lastname;
	private String dni;
	private Date dateOfBirth;
	private String password;
	private String phone;
	private String mail;
	private String address;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String register(){
		User user = new User();		
		user.setName(getName());
		user.setLastname(getLastname());
		user.setDni(getDni());
		user.setDateOfBirth(getDateOfBirth());
		user.setPassword(getPassword());
		user.setPhone(getPhone());
		user.setMail(getMail());
		user.setAddress(getAddress());

		
		FactoryDAO factoryDAO = new HiberjpaFactoryDAO();
		UserDAO userDAO = factoryDAO.getUser();
		userDAO.guardar(user);
		return "exito";
	}

}
