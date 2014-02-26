package backingBeans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Cuota;
import model.Pago;
import model.Socio;
import model.User;
import acceso.HiberjpaFactoryDAO;
import acceso.PagoDAO;

@ManagedBean
@ViewScoped
public class pagoController extends Controller {

	// DAOs related variables
	private PagoDAO pagoDAO = HiberjpaFactoryDAO.getInstance().getPago();
	
	// Domain model related variables
	private Cuota cuota = new Cuota();
	private Pago pago = new Pago(cuota);
	private List<Pago> pagos = list();
	
	/**
	 * HookMethod para verificar los permisos segun el profile
	 */
	public boolean accessPermittedHook() {
		return sessionBean.getUser().esAdministradorDeUnidadCentral();
	}
	
	public Cuota getCuota() {
		return cuota;
	}

	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	//listo desde este get
	public List<Pago> getPagos() {
		pagos = list();
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

    public PagoDAO getPagoDAO() {
		return pagoDAO;
	}

	public void setPagoDAO(PagoDAO pagoDAO) {
		this.pagoDAO = pagoDAO;
	}

	public void edit(Pago pago){
    	this.pago = pago;
    	cuota = pago.getCuota();
    }
	
	public List<Cuota> getCuotas(){
		if (sessionBean != null){
			if( sessionBean.islogin()){
				if(sessionBean.getUser().esAdministradorDeUnidadCentral())
					return HiberjpaFactoryDAO.getInstance().getCuota().listar();
				else if(sessionBean.getUser().esAdministradorDeUnidad())
					return HiberjpaFactoryDAO.getInstance().getCuota().listar(sessionBean.getUser().getUnidad());
			}
		}
		return null;
	}
	
	
	public List<Cuota> getCuotasPendientes(){
		if (sessionBean != null){
			if( sessionBean.islogin()){
				if(sessionBean.getUser().esAdministradorDeUnidadCentral())
					return HiberjpaFactoryDAO.getInstance().getCuota().listarPendientes();
				else if(sessionBean.getUser().esAdministradorDeUnidad() || sessionBean.getUser().esOperadorDeUnidad())
					return HiberjpaFactoryDAO.getInstance().getCuota().listarPendientes(sessionBean.getUser().getUnidad());
			}
		}
		return null;
	}
	
	public User getUser(Socio socio){
		return HiberjpaFactoryDAO.getInstance().getUser().find(socio);
	}

	public void save(){
		pago.setFecha(new Date());
		pagoDAO.guardar(pago);
		cuota = new Cuota();
		pago = new Pago(cuota);
	}

	public void remove (Pago pago){
		pagoDAO.eliminar(pago.getId());
	}

	public void merge(){
		pagoDAO.modificar(this.pago);
		cuota = new Cuota();
		pago = new Pago(cuota);
	}

	public List<Pago> list(){
		if (sessionBean != null){
			if( sessionBean.islogin()){
				if(sessionBean.getUser().esAdministradorDeUnidadCentral() || sessionBean.getUser().esOperadorDeUnidadCentral())
					return pagoDAO.listar();
				else if(sessionBean.getUser().esAdministradorDeUnidad() || sessionBean.getUser().esOperadorDeUnidad())
					return pagoDAO.listar(sessionBean.getUser().getUnidad());
			}
		}
		return null;
	}
}