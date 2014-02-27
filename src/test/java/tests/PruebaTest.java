package tests;

import model.*;
import acceso.*;

public class PruebaTest {
	public static void main (String [ ] args) 
	{
		FactoryDAO factoryDAO = new HiberjpaFactoryDAO();

		// ------------ CREACION DE OBJETOS DAOs Y OBJETOS DEL MODELO ---------------
		//AdministradorCentralDAO objetoDAO = factoryDAO.getAdministradorCentral(); AdministradorCentral objeto;
		//AdministradorDeUnidadDAO objetoDAO = factoryDAO.getAdministradorDeUnidad();	AdministradorDeUnidad objeto;
		//AvisoDePagoDAO objetoDAO = factoryDAO.getAvisoDePago(); AvisoDePago objeto;
		//CuotaDAO objetoDAO = factoryDAO.getCuota(); Cuota objeto;
		//InstitucionDAO objetoDAO = factoryDAO.getInstitucion(); Institucion objeto;
		//MedicamentoDAO objetoDAO = factoryDAO.getMedicamento(); Medicamento objeto;
		//NoSocioDAO objetoDAO = factoryDAO.getNoSocio(); NoSocio objeto;
		//OperadorCentralDAO objetoDAO = factoryDAO.getOperadorCentral(); OperadorCentral objeto;
		//OperadorDeUnidadDAO objetoDAO = factoryDAO.getOperadorDeUnidad(); OperadorDeUnidad objeto;
		//PagoDAO objetoDAO = factoryDAO.getPago(); Pago objeto;
		//ProductoDAO objetoDAO = factoryDAO.getProducto(); Producto objeto;
		//SocioDAO objetoDAO = factoryDAO.getSocio(); Socio objeto;
		//SocioVirtualDAO objetoDAO = factoryDAO.getSocioVirtual(); SocioVirtual objeto;
		//UnidadDAO objetoDAO = factoryDAO.getUnidad(); Unidad objeto;
		UnidadCentralDAO objetoDAO = factoryDAO.getUnidadCentral(); UnidadCentral objeto;
		//UserDAO objetoDAO = factoryDAO.getUser(); User objeto;

		long id = 1; //<------ reemplazar por id que este persistido para modificar y/o eliminar
		
		System.out.print("\n --------------------------- LISTAR --------------------------- \n");
		for (Object ob : objetoDAO.listar()) {
			System.out.println(ob);
		}

		System.out.print("\n --------------------------- ENCONTRAR --------------------------- \n");
		objeto = objetoDAO.encontrar(id);
		System.out.println(objeto);

		
		System.out.print("\n --------------------------- MODIFICAR --------------------------- \n");
		//insertar codigo para modificar ejemplo si objeto fuera Usuario:
		//objeto.setName("pepe");
		
		objetoDAO.modificar(objeto);
		System.out.println(objeto);
		
		System.out.print("\n --------------------------- ELIMINAR --------------------------- \n");
		//objetoDAO.eliminar(id);
	} 
}