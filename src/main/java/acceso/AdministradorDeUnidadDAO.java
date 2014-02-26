package acceso;

import model.AdministradorDeUnidad;
import model.User;

public interface AdministradorDeUnidadDAO extends
		GeneralDAO<AdministradorDeUnidad> {

	AdministradorDeUnidad find(User user);

}
