package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
public class AvisoDePago implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue private long id;
	private double monto;
	private Date fecha;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cuota_id")
	private Cuota cuota;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Cuota getCuota() {
		return cuota;
	}
	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}
}
