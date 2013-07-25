package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
public class UnidadCentral extends Unidad implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="unidadCentral_id")
	List <Institucion> instituciones;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="unidadCentral_id")
	List <Producto> productos;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="unidadCentral_id")
	List <Medicamento> medicamentos;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="unidadCentral_id")
	List <Unidad> unidades;
	
	public UnidadCentral(){
		
	}

	public List<Institucion> getInstitucion() {
		return instituciones;
	}

	public void setInstitucion(List<Institucion> instituciones) {
		this.instituciones = instituciones;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public List<Unidad> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidad> unidades) {
		this.unidades = unidades;
	}
	
	/**
	 * End getters and setters
	 */
	/*
	public User getUser(String name) {
		User userOrNull = super.getUser(name);
		if (userOrNull == null){
			for (Unidad unaUnidad : this.getUnidades()) {
				userOrNull = unaUnidad.getUser(name);
				if (userOrNull != null)
					return userOrNull; 
			}
		}
		return userOrNull;
	}
*/
	
}
