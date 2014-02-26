package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Cuota implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue
	private long id;
	private Date fechaDeEmision;
	private double monto;
	private double montoAPagar;
	
	@ManyToOne
	@JoinColumn(name="socio_id")
	private Socio socio;
	
	@OneToMany(mappedBy="cuota",cascade=CascadeType.REMOVE)
	private List<Pago> pagos;
	
	@OneToMany(mappedBy="cuota",cascade=CascadeType.REMOVE)
	private List<AvisoDePago> avisosDePagos;
	
	
	public Cuota() {
	}

	public Cuota(Date fechaDeEmision, double monto, Socio socio) {
		super();
		this.fechaDeEmision = fechaDeEmision;
		this.monto = monto;
		this.socio = socio;
		this.montoAPagar = monto;
	}

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
		this.montoAPagar = monto;
	}

	public double getMontoAPagar() {
		return montoAPagar;
	}

	public void setMontoAPagar(double montoAPagar) {
		this.montoAPagar = montoAPagar;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public List<AvisoDePago> getAvisosDePagos() {
		return avisosDePagos;
	}

	public void setAvisosDePagos(List<AvisoDePago> avisosDePagos) {
		this.avisosDePagos = avisosDePagos;
	}
	
	public void restarMontoAPagar(double monto){
		this.montoAPagar-=monto;
	}

	public void sumarMontoAPagar(double monto) {
		this.montoAPagar+=monto;
	}
	
	public String getMonth(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaDeEmision);
		return new java.text.DateFormatSymbols().getMonths()[cal.get(Calendar.MONTH)];
	}
	
	public String getYear(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaDeEmision);
		return Integer.toString(cal.get(Calendar.YEAR));
	}

}
