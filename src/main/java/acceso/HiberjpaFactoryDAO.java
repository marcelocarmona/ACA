package acceso;

public class HiberjpaFactoryDAO implements FactoryDAO {
	
	private static FactoryDAO SINGLETON = new HiberjpaFactoryDAO();
	
    public static FactoryDAO getInstance() {
        return SINGLETON;
    }

	public AdministradorCentralDAOhiberjpa getAdministradorCentral() {
		return new AdministradorCentralDAOhiberjpa();
	}

	public AdministradorDeUnidadDAOhiberjpa getAdministradorDeUnidad() {
		return new AdministradorDeUnidadDAOhiberjpa();
	}

	public AvisoDePagoDAOhiberjpa getAvisoDePago() {
		return new AvisoDePagoDAOhiberjpa();
	}

	public CuotaDAOhiberjpa getCuota() {
		return new CuotaDAOhiberjpa();
	}

	public InstitucionDAOhiberjpa getInstitucion() {
		return new InstitucionDAOhiberjpa();
	}

	public MedicamentoDAOhiberjpa getMedicamento() {
		return new MedicamentoDAOhiberjpa();
	}

	public NoSocioDAOhiberjpa getNoSocio() {
		return new NoSocioDAOhiberjpa();
	}

	public OperadorDeUnidadDAOhiberjpa getOperadorDeUnidad() {
		return new OperadorDeUnidadDAOhiberjpa();
	}

	public PagoDAOhiberjpa getPago() {
		return new PagoDAOhiberjpa();
	}

	public ProductoDAOhiberjpa getProducto() {
		return new ProductoDAOhiberjpa();
	}

	public SocioDAOhiberjpa getSocio() {
		return new SocioDAOhiberjpa();
	}

	public SocioVirtualDAOhiberjpa getSocioVirtual() {
		return new SocioVirtualDAOhiberjpa();
	}

	public UnidadDAOhiberjpa getUnidad() {
		return new UnidadDAOhiberjpa();
	}

	public UnidadCentralDAOhiberjpa getUnidadCentral() {
		return new UnidadCentralDAOhiberjpa();
	}

	public UserDAOhiberjpa getUser() {
		return new UserDAOhiberjpa();
	}
}