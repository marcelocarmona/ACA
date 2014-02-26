package model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
public class SocioVirtual extends Socio implements Serializable {

	private static final long serialVersionUID = 1L;

	public SocioVirtual() {}

	public boolean esSocio() {
		return false;
	}
	
	public boolean esSocioVirtual() {
		return true;
	}
	
	public String getProfileType(){
		return "SocioVirtual";
	}

}
