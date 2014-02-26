package acceso;

import java.util.List;

import model.Socio;
import model.Unidad;
import model.User;

public interface UserDAO extends GeneralDAO<User> {
	
	User findUser(String name);

	List<User> listar(Unidad userUnidad);

	List<User> noSocioList();

	List<User> socioList();

	User find(Socio socio);

	List<User> socioList(Unidad unidad);

}
