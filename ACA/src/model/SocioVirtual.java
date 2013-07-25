package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
public class SocioVirtual extends Socio implements Serializable {

	private static final long serialVersionUID = 1L;

	public SocioVirtual() {}
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="socio_virtual_id")
	private List<AvisoDePago> avisosDePagos;
	
	public List<AvisoDePago> getAvisosDePagos() {
		return avisosDePagos;
	}

	public void setAvisosDePagos(List<AvisoDePago> avisosDePagos) {
		this.avisosDePagos = avisosDePagos;
	}

	public void avisoDePago() {
		
	}

}
