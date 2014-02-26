package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class NoSocio extends Profile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	@JoinTable(
		name="NoSocio_Institucion",
		joinColumns=@JoinColumn(name="noSocio_id") ,
		inverseJoinColumns=@JoinColumn(name="institucion_id"))
	
	private List<Institucion> instituciones = new ArrayList<Institucion>();

	public NoSocio() {
		
	}
	
	public NoSocio(List<Institucion> instituciones) {
		super();
		this.instituciones = instituciones;
	}

	public List<Institucion> getInstituciones() {
		return instituciones;
	}

	public void setInstituciones(List<Institucion> instituciones) {
		this.instituciones = instituciones;
	}
	
	public boolean esNoSocio(){
		return true;
	}
	
	public String getProfileType(){
		return "NoSocio";
	}

	public void add(Institucion institucion) {
		instituciones.add(institucion);
	}
}
