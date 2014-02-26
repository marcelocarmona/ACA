package acceso;

import model.Socio;
import model.User;

public interface SocioDAO extends GeneralDAO<Socio> {

	Socio find(User user);
	
	boolean alDia(Socio socio);
}
