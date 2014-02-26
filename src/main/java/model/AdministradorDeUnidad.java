package model;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Son los encargados de administrar los operadores de la unidad a la que pertenece
 * @author marcelo
 *
 */

@Entity
public class AdministradorDeUnidad extends Profile implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public boolean esAdministradorDeUnidad(){
		return true;
	}
	
	public String getProfileType(){
		return "Administrador";
	}

}
