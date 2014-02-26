package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class UnidadCentral extends Unidad implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="unidadCentral_id")
	List <Institucion> instituciones = new ArrayList<Institucion>();

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="unidadCentral_id")
	List <Producto> productos = new ArrayList<Producto>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="unidadCentral_id")
	List <Medicamento> medicamentos = new ArrayList<Medicamento>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="unidadCentral_id")
	List <Unidad> unidades = new ArrayList<Unidad>();;
	
	public UnidadCentral(){
		
	}

	public List<Institucion> getInstituciones() {
		return instituciones;
	}

	public void setInstituciones(List<Institucion> instituciones) {
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

	public void add(Institucion institucion) {
		instituciones.add(institucion);
	}

	public Institucion get(Institucion institucion) {
		return instituciones.get((int) institucion.getId());
	}

	public void add(Medicamento medicamento) {
		medicamentos.add(medicamento);
	}

	public void add(Producto producto) {
		productos.add(producto);
		
	}

	public void add(Unidad unidad) {
		unidades.add(unidad);
	}
	
	public boolean esUnidadCentral(){
		return true;
	}
}
