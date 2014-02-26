package model;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Operador de unidad tiene permiso para gestionar los socios de la unidad (filial, delegacioÌ�n) 
 * a la cual pertenecen. 
 * Son los encargados de registrar los socios, actualizar sus datos y registrar los pagos de los
 * mismos
 * @author marcelo
 * 
 */

@Entity
public class OperadorDeUnidad extends Profile implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public OperadorDeUnidad(){}
	
	public boolean esOperadorDeUnidad(){
		return true;
	}
	
	public String getProfileType(){
		return "Operador";
	}

}
