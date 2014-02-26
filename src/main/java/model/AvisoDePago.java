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
	private boolean confirmado;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cuota_id")
	private Cuota cuota;
	
	public AvisoDePago() {
		this.confirmado = false;
	}
	
	public AvisoDePago(double monto, Date fecha, Cuota cuota) {
		super();
		this.monto = monto;
		this.fecha = fecha;
		this.cuota = cuota;
		this.confirmado = false;
	}
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
	public boolean isConfirmado() {
		return confirmado;
	}
	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}
	public Cuota getCuota() {
		return cuota;
	}
	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}
}
