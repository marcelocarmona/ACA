package tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import acceso.*;
import model.*;

public class ConDAOTest {
	public static void main (String [ ] args) 
	{ 
		
		// fecha de hoy
		Date fecha = new Date();
		
		//--------------------------- Creo Medicamentos ---------------------------
		Medicamento m1 = new Medicamento();
		m1.setName("medicamento 1");

		Medicamento m2 = new Medicamento();
		m2.setName("medicamento 2");

		List<Medicamento> mList = new ArrayList<>();
		mList.add(m1);
		mList.add(m2);
		
		
		//--------------------------- creo Productos ---------------------------
		Producto p1 = new Producto();
		p1.setCaracteristicas("caracteristicas ....");
		p1.setCategoria("categoria 1");
		p1.setComentario("comentario...");
		p1.setEmpresa("empresa string");
		p1.setFechaAlta(fecha);
		p1.setFechaCertificado(fecha);
		p1.setMarca("una marca");
		p1.setRne("RNE");
		p1.setRnpa("RNPA");
		
		Producto p2 = new Producto();
		p2.setCaracteristicas("caracteristicas ....");
		p2.setCategoria("categoria 1");
		p2.setComentario("comentario...");
		p2.setEmpresa("empresa string");
		p2.setFechaAlta(fecha);
		p2.setFechaCertificado(fecha);
		p2.setMarca("una marca");
		p2.setRne("RNE");
		p2.setRnpa("RNPA");
		
		List<Producto> pList = new ArrayList<Producto>();
		pList.add(p1);
		pList.add(p2);
		
		
		//--------------------------- creo Instituciones ---------------------------
		Institucion i1 = new Institucion();
		i1.setName("institucion 1");
		Institucion i2 = new Institucion();
		i2.setName("institucion 2");
		
		List<Institucion> iList = new ArrayList<Institucion>();
		iList.add(i1);
		iList.add(i2);
		

		//--------------------------- creo una Cuota ---------------------------
		
		Cuota c1 = new Cuota();
		c1.setFechaDeEmision(fecha);
		c1.setMonto(31);
		
		Cuota c2 = new Cuota();
		c2.setFechaDeEmision(fecha);
		c2.setMonto(32);
		
		Cuota c3 = new Cuota();
		c3.setFechaDeEmision(fecha);
		c3.setMonto(33);
		
		Cuota c4 = new Cuota();
		c4.setFechaDeEmision(fecha);
		c4.setMonto(34);
		
		List<Cuota> cList1 = new ArrayList<Cuota>();
		cList1.add(c1);
		
		List<Cuota> cList2 = new ArrayList<Cuota>();
		cList2.add(c2);
		
		List<Cuota> cList3 = new ArrayList<Cuota>();
		cList3.add(c3);
		cList3.add(c4);
		

		//--------------------------- creo pagos ---------------------------
		
		Pago pago1 = new Pago();
		pago1.setFecha(fecha);
		pago1.setMonto(100);
		pago1.setCuota(c1);
		
		Pago pago2 = new Pago();
		pago2.setFecha(fecha);
		pago2.setMonto(200);
		pago2.setCuota(c2);
		
		Pago pago3 = new Pago();
		pago3.setFecha(fecha);
		pago3.setMonto(300);
		pago3.setCuota(c2);
		
		List<Pago> pagoList1 = new ArrayList<Pago>();
		pagoList1.add(pago1);
		
		List<Pago> pagoList2 = new ArrayList<Pago>();
		pagoList2.add(pago2);
		pagoList2.add(pago3);
		
		
		//--------------------------- creo avisos de pago ---------------------------
		
		AvisoDePago aviso1 = new AvisoDePago();
		aviso1.setFecha(fecha);
		aviso1.setMonto(50);
		aviso1.setCuota(c1);
		
		AvisoDePago aviso2 = new AvisoDePago();
		aviso2.setFecha(fecha);
		aviso2.setMonto(30);
		aviso2.setCuota(c2);
		
		List<AvisoDePago> avisoList = new ArrayList<AvisoDePago>();
		avisoList.add(aviso1);
		avisoList.add(aviso2);
		
		//--------------------------- creo perfiles ---------------------------
		
		OperadorDeUnidad op1 = new OperadorDeUnidad();
		AdministradorDeUnidad adminUni1 = new AdministradorDeUnidad();
		AdministradorDeUnidad adminUni2 = new AdministradorDeUnidad();
		NoSocio noSocio1 = new NoSocio();
		noSocio1.setInstituciones(iList);
		Socio socio1 = new Socio(); /* add cuotas */ c1.setSocio(socio1);c2.setSocio(socio1);c3.setSocio(socio1);c4.setSocio(socio1);
		SocioVirtual socioVirtual1 = new SocioVirtual();
		AdministradorCentral adminCentral1 = new AdministradorCentral();
		
		List<Profile> profileList1 = new ArrayList<Profile>();
		profileList1.add(op1);
		profileList1.add(adminUni1);
		profileList1.add(adminCentral1);
		
		List<Profile> profileList2 = new ArrayList<Profile>();
		profileList2.add(adminUni2);
		
		List<Profile> profileList3 = new ArrayList<Profile>();
		profileList3.add(noSocio1);
		
		List<Profile> profileList4 = new ArrayList<Profile>();
		profileList4.add(socio1);
		
		List<Profile> profileList5 = new ArrayList<Profile>();
		
		List<Profile> profileList6 = new ArrayList<Profile>();
		profileList6.add(socioVirtual1);

		
		//--------------------------- creo Usuarios ---------------------------
		
		User u1 = new User();
		u1.setAddress("direccion user 1");
		u1.setDateOfBirth(fecha);
		u1.setDni("334753823");
		u1.setLastname("Apellido");
		u1.setMail("mi email");
		u1.setName("usuario 1");
		u1.setPassword("password");
		u1.setPhone("0221-484334");
		u1.setProfiles(profileList1);
		
		User u2 = new User();
		u2.setAddress("direccion user 2");
		u2.setDateOfBirth(fecha);
		u2.setDni("12341223");
		u2.setLastname("Apellido");
		u2.setMail("mi email");
		u2.setName("usuario 2");
		u2.setPassword("password2");
		u2.setPhone("0221-2345843");
		u2.setProfiles(profileList2);
		
		User u3 = new User();
		u3.setAddress("direccion user 3");
		u3.setDateOfBirth(fecha);
		u3.setDni("334753823");
		u3.setLastname("Apellido");
		u3.setMail("mi email");
		u3.setName("usuario 3");
		u3.setPassword("password");
		u3.setPhone("0221-484334");
		u3.setProfiles(profileList3);

		User u4 = new User();
		u4.setAddress("direccion user 4");
		u4.setDateOfBirth(fecha);
		u4.setDni("334753823");
		u4.setLastname("Apellido");
		u4.setMail("mi email");
		u4.setName("usuario 4");
		u4.setPassword("password");
		u4.setPhone("0221-484334");
		u4.setProfiles(profileList4);
		
		User u5 = new User();
		u5.setAddress("direccion user 5");
		u5.setDateOfBirth(fecha);
		u5.setDni("334753823");
		u5.setLastname("Apellido");
		u5.setMail("mi email");
		u5.setName("usuario 5");
		u5.setPassword("password");
		u5.setPhone("0221-484334");
		u5.setProfiles(profileList5);
		
		
		User u6 = new User();
		u6.setAddress("direccion user 6");
		u6.setDateOfBirth(fecha);
		u6.setDni("334753823");
		u6.setLastname("Apellido");
		u6.setMail("mi email");
		u6.setName("usuario 6");
		u6.setPassword("password");
		u6.setPhone("0221-484334");
		u6.setProfiles(profileList6);
		
		List<User> uList1 = new ArrayList<User>();
		uList1.add(u1);
		uList1.add(u2);
		
		List<User> uList2 = new ArrayList<User>();
		uList2.add(u3);
		uList2.add(u4);
		
		List<User> uList3 = new ArrayList<User>();
		uList3.add(u5);
		uList3.add(u6);
		

		
		//--------------------------- creo Unidades ---------------------------
		Unidad uni1 = new Unidad();
		uni1.setMail("unidad1@asd.com");
		uni1.setMeetings("reuniones ....");
		uni1.setName("Unidad 1");
		uni1.setPhone("0221-234442");
		uni1.setUsers(uList1);
		uni1.setResponsible(u1);
	
		Unidad uni2 = new Unidad();
		uni2.setMail("asd@asd.com");
		uni2.setMeetings("reuniones martes :)");
		uni2.setName("Unidad 2");
		uni2.setPhone("0221-45632");
		uni2.setUsers(uList2);
		uni2.setResponsible(u2);
		
		List<Unidad> uniList = new ArrayList<Unidad>();
		uniList.add(uni1);
		uniList.add(uni2);
		
		
		//--------------------------- creo una Unidad Central ---------------------------
		UnidadCentral uniCentral = new UnidadCentral();
		uniCentral.setMail("asd@asd.com");
		uniCentral.setMeetings("reuniones lues a las 9 en la oficina 3");
		uniCentral.setName("Unidad Central");
		uniCentral.setPhone("0221-384932");
		uniCentral.setResponsible(u3);
		
		uniCentral.setUsers(uList3);
		uniCentral.setMedicamentos(mList);
		uniCentral.setProductos(pList);
		uniCentral.setInstituciones(iList);
		uniCentral.setUnidades(uniList);
		
		
		// -------------------------------------- FACTORY ------------------------------------------
		HiberjpaFactoryDAO factoryDAO = new HiberjpaFactoryDAO();
		// --------------------------- CREACION DEL OBJETO DAO PRINCIPAL ---------------------------
		UnidadCentralDAO unidadCentralDAO = factoryDAO.getUnidadCentral();
		unidadCentralDAO.guardar(uniCentral);
		
		System.out.print("objetos persistidos :) "); 
	} 
}
