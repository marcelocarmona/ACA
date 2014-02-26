package model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
public class Socio extends Profile implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Socio(){}
	
	public boolean esSocio(){
		return true;
	}
	
	public String getProfileType(){
		return "Socio";
	}

}
