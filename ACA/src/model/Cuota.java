package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Cuota implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue
	private long id;
	private Date fechaDeEmision;
	private double monto;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="socio_id")
	private Socio socio;
	
	public Date vencimiento(){
		return fechaDeEmision;	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFechaDeEmision() {
		return fechaDeEmision;
	}

	public void setFechaDeEmision(Date fechaDeEmision) {
		this.fechaDeEmision = fechaDeEmision;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}
}
