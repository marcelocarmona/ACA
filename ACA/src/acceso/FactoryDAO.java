package acceso;


public interface FactoryDAO {
	
	public AdministradorCentralDAO getAdministradorCentral();
	
	public AdministradorDeUnidadDAO getAdministradorDeUnidad();
	
	public AvisoDePagoDAO getAvisoDePago();
	
	public CuotaDAO getCuota();
	
	public InstitucionDAO getInstitucion();
	
	public MedicamentoDAO getMedicamento();
	
	public NoSocioDAO getNoSocio();
	
	public OperadorCentralDAO getOperadorCentral();
	
	public OperadorDeUnidadDAO getOperadorDeUnidad();
	
	public PagoDAO getPago();
	
	public ProductoDAO getProducto();
	
	//clase abstracta
	//public ProfileDAO getProfile();
	
	public SocioDAO getSocio();
	
	public SocioVirtualDAO getSocioVirtual();
	
	public UnidadDAO getUnidad();
	
	public UnidadCentralDAO getUnidadCentral();
	
	public UserDAO getUser();
	
	
}
