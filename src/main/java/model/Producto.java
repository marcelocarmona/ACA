package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
	private String marca;
	private String caracteristicas;
	private String rnpa;
	private String empresa;
	private String rne;
	private Date fechaAlta;
	private Date fechaCertificado;
	private String Comentario;
	private String Categoria;

	public Producto(){}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}	
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getRnpa() {
		return rnpa;
	}
	public void setRnpa(String rnpa) {
		this.rnpa = rnpa;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getRne() {
		return rne;
	}
	public void setRne(String rne) {
		this.rne = rne;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaCertificado() {
		return fechaCertificado;
	}
	public void setFechaCertificado(Date fechaCertificado) {
		this.fechaCertificado = fechaCertificado;
	}
	public String getComentario() {
		return Comentario;
	}
	public void setComentario(String comentario) {
		Comentario = comentario;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
}
