package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
abstract public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue private long id;
	
	public Profile(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	//Subclass responsibility
	public boolean esOperadorDeUnidad(){
		return false;
	}
	
	//Subclass responsibility
	public boolean esAdministradorDeUnidad(){
		return false;
	}

	//Subclass responsibility
	public boolean esNoSocio(){
		return false;
	}

	//Subclass responsibility
	public boolean esSocio(){
		return false;
	}
	
	//Subclass responsibility
	public boolean esSocioVirtual(){
		return false;
	}
	
	//Subclass responsibility	
	public String getProfileType(){
		return "Abstracta";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this.getClass().equals(obj.getClass())) return true;
		return false;
	}
}
