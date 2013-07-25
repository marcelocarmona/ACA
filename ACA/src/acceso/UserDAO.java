package acceso;

import model.User;

public interface UserDAO extends GeneralDAO<User> {
	
	User findUser(String name);

}
