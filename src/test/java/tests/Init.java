package tests;

import java.util.Date;

import model.AdministradorDeUnidad;
import model.UnidadCentral;
import model.User;
import acceso.HiberjpaFactoryDAO;
import acceso.UnidadCentralDAO;
import acceso.UserDAO;

public class Init {
	
	/**
	 * Metodo inicial para poder usar la aplicación crea un usuario admin con contraseña admin 
	 * perteneciente a la unidad central y con perfil administrador
	 * @param args
	 */
	public static void main (String [ ] args) 
	{ 
		// fecha de hoy
		Date fecha = new Date();
	
	//--------------------------- creo una Unidad Central ---------------------------
	UnidadCentral uniCentral = new UnidadCentral();
	uniCentral.setMail("asd@asd.com");
	uniCentral.setMeetings("reuniones lues a las 9 en la oficina 3");
	uniCentral.setName("Unidad Central");
	uniCentral.setPhone("0221-384932");

	
	// -------------------------------------- FACTORY ------------------------------------------
	HiberjpaFactoryDAO factoryDAO = new HiberjpaFactoryDAO();
	// --------------------------- CREACION DEL OBJETO DAO PRINCIPAL ---------------------------
	UnidadCentralDAO unidadCentralDAO = factoryDAO.getUnidadCentral();
	unidadCentralDAO.guardar(uniCentral);

	//--------------------------- creo un Usuario ---------------------------
	User u1 = new User(uniCentral);
	u1.setAddress("direccion user 1");
	u1.setDateOfBirth(fecha);
	u1.setDni("334753823");
	u1.setLastname("Apellido");
	u1.setMail("mi email");
	u1.setName("admin");
	u1.setPassword("admin");
	u1.setPhone("0221-484334");
	u1.setUnidad(uniCentral);
	
	// --------------------------- Guardo usuario ---------------------------
	UserDAO userDAO = factoryDAO.getUser();
	userDAO.guardar(u1);
	
	// --------------------------- Usuario como Responsable de unidad ---------------------------
	uniCentral.setResponsible(u1);
	unidadCentralDAO.modificar(uniCentral);

	// --------------------------- Perfil administrador ---------------------------
	AdministradorDeUnidad adminUni1 = new AdministradorDeUnidad();
	u1.add(adminUni1);
	userDAO.modificar(u1);

	}
}
