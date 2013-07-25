package acceso;

import model.UnidadCentral;
import model.User;

public interface UnidadCentralDAO extends GeneralDAO<UnidadCentral> {
	
	/**
	 * Devuelve el usuario correspondiente a su userName
	 * @param userName
	 * @return
	 */
	User getUser(String userName);

}
