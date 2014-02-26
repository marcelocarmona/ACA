package backingBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Cuota;
import model.Socio;
import model.SocioVirtual;
import model.User;
import acceso.CuotaDAO;
import acceso.HiberjpaFactoryDAO;
import acceso.SocioDAO;
import acceso.SocioVirtualDAO;
import acceso.UserDAO;

@ManagedBean
@ViewScoped
public class CuotaController extends Controller implements Serializable {

	private static final long serialVersionUID = 1L;

	// DAOs related variables
	private CuotaDAO cuotaDAO = HiberjpaFactoryDAO.getInstance().getCuota();
	
	// Domain model related variables
	private User user = new User();
	private Cuota cuota = new Cuota();
	private List<Cuota> cuotas = list();
	
	/**
	 * HookMethod para verificar los permisos segun el profile
	 */
	public boolean accessPermittedHook() {
		return sessionBean.getUser().esAdministradorDeUnidadCentral();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cuota getCuota() {
		return cuota;
	}

	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}
	
	//listo desde este get
    public List<Cuota> getCuotas() {
    	cuotas = list();
		return cuotas;
	}

	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	public CuotaDAO getCuotaDAO() {
		return cuotaDAO;
	}

	public void setCuotaDAO(CuotaDAO cuotaDAO) {
		this.cuotaDAO = cuotaDAO;
	}

	public void edit(Cuota cuota){
		user = HiberjpaFactoryDAO.getInstance().getUser().find(cuota.getSocio());
    	this.cuota = cuota;
    }
	
	/**
	 * Al ser la relacion socio - usuario unidirecional necesito este metodo
	 */
	public void setSocio(){
		user = HiberjpaFactoryDAO.getInstance().getUser().encontrar(user.getId());
		if (user.esSocio()){
			SocioDAO socioDAO = HiberjpaFactoryDAO.getInstance().getSocio();
			Socio socio = socioDAO.encontrar(user.getProfileSocio().getId());
			cuota.setSocio(socio);
		} else if (user.esSocioVirtual()){
			SocioVirtualDAO socioVirtualDAO = HiberjpaFactoryDAO.getInstance().getSocioVirtual();
			SocioVirtual socioVirtual = socioVirtualDAO.encontrar(user.getProfileSocioVirtual().getId());
			cuota.setSocio(socioVirtual);
		}
		
	}
	
	public Number getSociosSinCuotas(){
		 List<Socio> socios = cuotaDAO.sociosSinCuotas();
		 return socios.size();
	}
	
	public User getUserSocio(Cuota cuota){
		return HiberjpaFactoryDAO.getInstance().getUser().find(cuota.getSocio());
	}
	
	public List<User> getUsuarios(){
		UserDAO userDAO = HiberjpaFactoryDAO.getInstance().getUser();
		if(sessionBean.getUser().esAdministradorDeUnidadCentral())
			return userDAO.socioList();
		else if(sessionBean.getUser().esAdministradorDeUnidad())
			return userDAO.socioList(sessionBean.getUser().getUnidad());
		else
			return null;
	}
	
	public void batchSave(){
		List<Socio> socios = cuotaDAO.sociosSinCuotas();
		double monto = cuota.getMonto();
		for (Socio socio : socios) {
			cuota.setFechaDeEmision(new Date());
			cuota.setSocio(socio);
			cuota.setMonto(monto);
			cuotaDAO.guardar(this.cuota);
			cuota = new Cuota();
		}
	}

	public void save(){
		setSocio();
		cuota.setFechaDeEmision(new Date());
		cuotaDAO.guardar(this.cuota);
		cuota = new Cuota();
	}

	public void remove (Cuota cuota){
		cuotaDAO.eliminar(cuota.getId());
	}

	public void merge(){
		cuotaDAO.modificar(this.cuota);
		cuota = new Cuota();
	}

	public List<Cuota> list(){
		if (sessionBean != null){
			if( sessionBean.islogin()){
				if(sessionBean.getUser().esAdministradorDeUnidadCentral())
					return cuotaDAO.listar();
				else if(sessionBean.getUser().esAdministradorDeUnidad())
					return cuotaDAO.listar(sessionBean.getUser().getUnidad());
			}
		}
		return null;
	}
	
	public List<Cuota> getListMisCuotasPendientes(){
		if (sessionBean != null){
			if( sessionBean.islogin()){
				if (sessionBean.getUser().esSocioVirtual()){
					return cuotaDAO.listMisCuotasPendientes(sessionBean.getUser().getProfileSocioVirtual());	
				} else if (sessionBean.getUser().esSocio()){
					return cuotaDAO.listMisCuotasPendientes(sessionBean.getUser().getProfileSocio());
				}
			}
		}
		return null;
	}
}