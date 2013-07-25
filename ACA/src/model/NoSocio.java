package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class NoSocio extends Profile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
		name="NoSocio_Institucion",
		joinColumns=@JoinColumn(name="noSocio_id") ,
		inverseJoinColumns=@JoinColumn(name="institucion_id"))
	private List<Institucion> instituciones;

	
	public List<Institucion> getInstituciones() {
		return instituciones;
	}

	public void setInstituciones(List<Institucion> instituciones) {
		this.instituciones = instituciones;
	}
}
