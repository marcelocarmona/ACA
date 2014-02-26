package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Medicamento;
import acceso.HiberjpaFactoryDAO;
import acceso.MedicamentoDAO;
import acceso.UnidadCentralDAO;

@ManagedBean
@ViewScoped
public class MedicamentoController extends Controller implements Serializable {


	private static final long serialVersionUID = 1L;

	// DAOs related variables
	private MedicamentoDAO medicamentoDAO = HiberjpaFactoryDAO.getInstance().getMedicamento();
	
	// Domain model related variables
	private Medicamento medicamento = new Medicamento();
	private List<Medicamento> medicamentos = list();
	
	/**
	 * HookMethod para verificar los permisos segun el profile
	 */
	public boolean accessPermittedHook() {
		return sessionBean.getUser().esAdministradorDeUnidadCentral();
	}
	
	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	
	//listo desde este get
	public List<Medicamento> getMedicamentos() {
		medicamentos = list();
		return medicamentos;
	}
	
	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public MedicamentoDAO getMedicamentoDAO() {
		return medicamentoDAO;
	}

	public void setMedicamentoDAO(MedicamentoDAO medicamentoDAO) {
		this.medicamentoDAO = medicamentoDAO;
	}

    public void edit(Medicamento medicamento){
    	this.medicamento = medicamento;
    }

	public void save(){
		UnidadCentralDAO unidadCentralDAO = HiberjpaFactoryDAO.getInstance().getUnidadCentral();
		unidadCentralDAO.save(medicamento);
		medicamento = new Medicamento();
	}

	public void remove (Medicamento medicamento){
		medicamentoDAO.eliminar(medicamento.getId());
	}

	public void merge(){
		medicamentoDAO.modificar(this.medicamento);
		medicamento = new Medicamento();
	}

	public List<Medicamento> list(){
		return medicamentoDAO.listar();
	}
}