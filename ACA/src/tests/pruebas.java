package tests;

import model.User;
import acceso.FactoryDAO;
import acceso.HiberjpaFactoryDAO;
import acceso.UserDAO;

public class pruebas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FactoryDAO factoryDAO = new HiberjpaFactoryDAO();
		UserDAO userDAO = factoryDAO.getUser();
		
		User userOrNull = userDAO.findUser("pepe");
		System.out.println(userOrNull);

	}

}
