package acceso;

import model.OperadorDeUnidad;
import model.User;

public interface OperadorDeUnidadDAO extends GeneralDAO<OperadorDeUnidad> {

	OperadorDeUnidad find(User user);

}
