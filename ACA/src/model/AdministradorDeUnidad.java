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

	public AdministradorDeUnidad(){}
	
	/*public boolean registrarOperadorDeUnidad(OperadorDeUnidad NuevoOperadorDeUnidad){
		boolean isNew = unidad.getOperadoresDeUnidad().contains(NuevoOperadorDeUnidad);
		if (isNew)
			unidad.getOperadoresDeUnidad().add(NuevoOperadorDeUnidad);
		return isNew;
	}
	*/
	
	public void actualizarDatos(OperadorDeUnidad unOperadorDeUnidad){
		//actualiza datos de OperadorDeUnidad
	}

}
