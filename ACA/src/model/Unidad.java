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
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="responsible_user_id")
	private User responsible;
	private String meetings;
	private String mail;
	private String phone;
	
	// private UnidadCentral unidadCentral;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="unidad_id")
	private List<Cuota> cuotas;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="unidad_id")
	private List<User> users;

	public Unidad(){}
	
	public Unidad(String name) {
		super();
		this.name = name;
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
	
	public List<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
/*
	public UnidadCentral getUnidadCentral() {
		return unidadCentral;
	}

	public void setUnidadCentral(UnidadCentral unidadCentral) {
		this.unidadCentral = unidadCentral;
	}
*/
	/**
	 * fin getters y setters
	 */
	
	public void cobrarMes(){
		/*for (Socio socio : this.socios)
			socio.getCuenta().extraer(this.unidadCentral.getCuota());*/
	}
	
	
	public Socio getSocio(String name){
		return null;
		/*for (Socio unSocio : this.getSocios()) {
			if (unSocio.getName().equals(name)){
				return unSocio;
			  } 
		}
		return null;*/
	}
	
	public OperadorDeUnidad getOperadorDeUnidad(String name){
		return null;
		/*for (OperadorDeUnidad unOperadorDeUnidad : this.getOperadoresDeUnidad()) {
			if (unOperadorDeUnidad.getName().equals(name)){
				return unOperadorDeUnidad;
			  } 
		}
		return null;*/
	}
	
	public AdministradorDeUnidad getAdministradorDeUnidad(String name){
		return null;
		/*for (AdministradorDeUnidadDAO unAdministradorDeUnidad : this.getAdministradoresDeUnidad()) {
			if (unAdministradorDeUnidad.getName().equals(name)){
				return unAdministradorDeUnidad;
			  } 
		}
		return null;*/
	}
	
	/**
	 * Metodo que puede ser refactorizado
	 * @param name
	 * @return
	 */
	
//	public User getUser(String name){
//		return responsible;
		/*User userOrNull = getSocio(name);
		if (userOrNull == null){
			userOrNull = getOperadorDeUnidad(name);
			if (userOrNull == null){
				userOrNull = getAdministradorDeUnidad(name);
			}		
		}
		return userOrNull;*/
//    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
