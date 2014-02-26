package backingBeans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.AvisoDePago;
import model.Cuota;
import model.Socio;
import model.User;
import acceso.AvisoDePagoDAO;
import acceso.HiberjpaFactoryDAO;

@ManagedBean
@ViewScoped
public class AvisoDePagoController extends Controller {


	// DAOs related variables
	private AvisoDePagoDAO avisoDePagoDAO = HiberjpaFactoryDAO.getInstance().getAvisoDePago();
	
	// Domain model related variables
	private AvisoDePago avisoDePago = new AvisoDePago(0,new Date(),new Cuota());
	private List<AvisoDePago> avisoDePagos = list();
	
	/**
	 * HookMethod para verificar los permisos segun el profile
	 */
	public boolean accessPermittedHook() {
		return sessionBean.getUser().esAdministradorDeUnidadCentral();
	}
	
	public AvisoDePago getAvisoDePago() {
		return avisoDePago;
	}

	public void setAvisoDePago(AvisoDePago avisoDePago) {
		this.avisoDePago = avisoDePago;
	}

	//listo desde este get
	public List<AvisoDePago> getAvisoDePagos() {
		avisoDePagos = list();
		return avisoDePagos;
	}

	public void setAvisoDePagos(List<AvisoDePago> avisoDePagos) {
		this.avisoDePagos = avisoDePagos;
	}

	public AvisoDePagoDAO getAvisoDePagoDAO() {
		return avisoDePagoDAO;
	}

	public void setAvisoDePagoDAO(AvisoDePagoDAO avisoDePagoDAO) {
		this.avisoDePagoDAO = avisoDePagoDAO;
	}

    public void edit(AvisoDePago avisoDePago){
    	this.avisoDePago = avisoDePago;
    }
    
	public List<Cuota> getCuotas(){
		return HiberjpaFactoryDAO.getInstance().getCuota().listCuotasSociovirtual();
	}
	
	public List<Cuota> getMisCuotasPendientes(){
		if (sessionBean != null){
			if( sessionBean.islogin()){
				if (sessionBean.getUser().esSocioVirtual()){
					return HiberjpaFactoryDAO.getInstance().getCuota().listMisCuotasPendientes(sessionBean.getUser().getProfileSocioVirtual());
				}
			}
		}
		return null;
	}
	
	public User getUser(Socio socio){
		return HiberjpaFactoryDAO.getInstance().getUser().find(socio);
	}
	
	public void confirmar(AvisoDePago avisoDePago){
		avisoDePagoDAO.confirmar(avisoDePago);
	}

	public void save(){
		avisoDePago.setFecha(new Date());
		avisoDePagoDAO.guardar(avisoDePago);
		avisoDePago = new AvisoDePago(0,new Date(),new Cuota());
	}

	public void remove (AvisoDePago avisoDePago){
		avisoDePagoDAO.eliminar(avisoDePago.getId());
	}

	public void merge(){
		avisoDePagoDAO.modificar(this.avisoDePago);
		avisoDePago = new AvisoDePago(0,new Date(),new Cuota());
	}

	public List<AvisoDePago> list(){
		return avisoDePagoDAO.listar();
	}
	
	public List<AvisoDePago> getListPendientes(){
		return avisoDePagoDAO.listPendientes();
	}

	public List<AvisoDePago> getListAsSocioVirtual(){
		if (sessionBean != null){
			if( sessionBean.islogin()){
				if (sessionBean.getUser().esSocioVirtual()){
					return avisoDePagoDAO.list(sessionBean.getUser().getProfileSocioVirtual());	
				}
			}
		}
		return null;
	}
}