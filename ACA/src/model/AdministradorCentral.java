package model;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * gestiona los operadores de la central y la información de filiales, 
 * delegaciones, grupos de referencia e instituciones beneficiarias 
 * (cárceles, comedores escolares, etc.)
 * @author marcelo
 *
 */

@Entity
public class AdministradorCentral extends AdministradorDeUnidad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public AdministradorCentral(){}
}
