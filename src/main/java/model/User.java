package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	@ManyToOne
	@JoinColumn(name="unidad_id")
	private Unidad unidad;

	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private List<Profile> profiles;

	public User(String name) {
		super();
		this.name = name;
		this.password = "pass";
	}
	
	public User(Unidad unidad){
		this.unidad = unidad;
		this.profiles = new ArrayList<Profile>();
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
	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}
	
	//metodo solo para listener de la vista userControlelr
	public Set<String> getStringProfiles() {
		HashSet<String> listString = new HashSet<String>();
		for (Profile profile : profiles) {
			listString.add(profile.getProfileType());
		}
		return listString;
	}

	//ver si puedo escribir un poco mejor esto 
	//Revisar la Api de collections
	//posiblemente profiles tenga que ser un set o algo parecido
	public boolean esAdministradorDeUnidad(){
		for (Profile profile : profiles) {
			if(profile.esAdministradorDeUnidad())
				return true;
		}
		return false;
	}
	

	public boolean esAdministradorDeUnidadCentral(){
		if(esAdministradorDeUnidad() && unidad.esUnidadCentral())
			return true;
		return false;
	}
	
	public boolean esOperadorDeUnidad(){
		for (Profile profile : profiles) {
			if(profile.esOperadorDeUnidad())
				return true;
		}
		return false;
	}
	
	public boolean esOperadorDeUnidadCentral(){
		if(esOperadorDeUnidad() && unidad.esUnidadCentral())
			return true;
		return false;
	}
	
	//Revisar  org.hibernate.LazyInitializationException:
	//lo arregle poniendo los profiles como EAGER
	public boolean esNoSocio(){
		for (Profile profile : profiles) {
			if(profile.esNoSocio())
				return true;
		}
		return false;
	}
	
	public boolean esSocio() {
		for (Profile profile : profiles) {
			if(profile.esSocio())
				return true;
		}
		return false;
	}
	
	public boolean esSocioVirtual() {
		for (Profile profile : profiles) {
			if(profile.esSocioVirtual())
				return true;
		}
		return false;
	}

	
	//Revisar por que seguro lo puedo escribir mejor
	public NoSocio getProfileNoSocio(){
		for (Profile profile : profiles) {
			if(profile.esNoSocio())
				return (NoSocio) profile;
		}
		return null;
	}
	
	public Socio getProfileSocio() {
		for (Profile profile : profiles) {
			if(profile.esSocio())
				return (Socio) profile;
		}
		return null;
	}
	
	public SocioVirtual getProfileSocioVirtual() {
		for (Profile profile : profiles) {
			if(profile.esSocioVirtual())
				return (SocioVirtual) profile;
		}
		return null;
	}

	public void add(Profile profile) {
		profiles.add(profile);		
	}

	public void remove(AdministradorDeUnidad administradorDeUnidad) {
		profiles.remove(administradorDeUnidad);
	}

	public void remove(NoSocio noSocio) {
		profiles.remove(noSocio);
		
	}

	public void remove(OperadorDeUnidad operadorDeUnidad) {
		profiles.remove(operadorDeUnidad);
		
	}

	public void remove(Socio socio) {
		profiles.remove(socio);
		
	}
	
	public void remove(SocioVirtual socio) {
		profiles.remove(socio);
		
	}
	
	
	public void removeAdministradorDeUnidad(){
		for (Profile profile : profiles) {
			if(profile.esAdministradorDeUnidad())
				profiles.remove(profile);
		}
	}
	
	public void removeOperadorDeUnidad(){
		for (Profile profile : profiles) {
			if(profile.esAdministradorDeUnidad())
				profiles.remove(profile);
		}
	}
	
	public void removeNoSocio(){
		for (Profile profile : profiles) {
			if(profile.esAdministradorDeUnidad())
				profiles.remove(profile);
		}
	}
	
	public void removeSocio(){
		for (Profile profile : profiles) {
			if(profile.esAdministradorDeUnidad())
				profiles.remove(profile);
		}
	}
	
	public void removeSocioVirtual(){
		for (Profile profile : profiles) {
			if(profile.esAdministradorDeUnidad())
				profiles.remove(profile);
		}
	}







	

	


}
