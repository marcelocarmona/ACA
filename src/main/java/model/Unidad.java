package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
public class Unidad implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	
	@OneToOne
	@JoinColumn(name="responsible_user_id")
	private User responsible;
	private String meetings;
	private String mail;
	private String phone;
	
	// private UnidadCentral unidadCentral;

	@OneToMany(mappedBy="unidad")
	private List<User> users;

	public Unidad(){}
	
	public Unidad(String name) {
		super();
		this.name = name;
	}
	
	public Unidad(User responsible){
		this.responsible = responsible;
	}
	
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

	public User getResponsible() {
		return responsible;
	}
	public void setResponsible(User responsible) {
		this.responsible = responsible;
	}

	public String getMeetings() {
		return meetings;
	}
	public void setMeetings(String meetings) {
		this.meetings = meetings;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	/**
	 * fin getters y setters
	 */

	//Subclass responsibility
	public boolean esUnidadCentral() {
		return false;
	}
	
	public String getUnidadType(){
		return esUnidadCentral() ? "UnidadCentral":"Unidad";
	}

}
