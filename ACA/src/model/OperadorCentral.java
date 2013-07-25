package model;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 * gestiona los socios propios de la central y socios virtuales, y posee acceso para 
 * consultar toda la información de los socios adheridos a través de las diferentes unidades.
 * @author marcelo
 *
 */

@Entity
public class OperadorCentral extends OperadorDeUnidad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public OperadorCentral(){}

	public void consultarInformacion(){
		//consulta informacion de todos los socios de todas las unidades
	}

}
