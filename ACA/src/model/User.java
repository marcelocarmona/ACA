package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue private long id;

	private String name;
	private String lastname;
	private String dni;
	private Date dateOfBirth;
	private String password;
	private String phone;
	private String mail;
	private String address;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private List<Profile> profiles;

	public User(String name) {
		super();
		this.name = name;
		this.password = "pass";
	}
	
	public User(){}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
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

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	public String welcomePage() {
		return "welcome" + this.getClass().getSimpleName() + ".html";
	}
}
