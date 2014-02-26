package acceso;

import model.SocioVirtual;
import model.User;

public interface SocioVirtualDAO extends GeneralDAO<SocioVirtual> {

	SocioVirtual find(User user);

}
