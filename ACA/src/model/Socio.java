package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
public class Socio extends Profile implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="socio_id")
	private List<Pago> pagos;

	public Socio(){}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

}
