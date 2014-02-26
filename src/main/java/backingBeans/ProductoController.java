package backingBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Producto;
import acceso.HiberjpaFactoryDAO;
import acceso.ProductoDAO;
import acceso.UnidadCentralDAO;

@ManagedBean
@ViewScoped
public class ProductoController extends Controller{
	
	
	// DAOs related variables
	private ProductoDAO productoDAO = HiberjpaFactoryDAO.getInstance().getProducto();
	
	// Domain model related variables
	private Producto producto = new Producto();
	private List<Producto> productos = list();

	/**
	 * HookMethod para verificar los permisos segun el profile
	 */
	public boolean accessPermittedHook() {
		return sessionBean.getUser().esAdministradorDeUnidadCentral();
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	//listo desde este get
	public List<Producto> getProductos() {
		productos = list();
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}


	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

    public void edit(Producto producto){
    	this.producto = producto;
    }

	public void save(){
		UnidadCentralDAO unidadCentralDAO = HiberjpaFactoryDAO.getInstance().getUnidadCentral();
		unidadCentralDAO.save(producto);
		producto = new Producto();
	}
	
	public void remove (Producto producto){
		productoDAO.eliminar(producto.getId());
	}
   
	public void merge(){
		productoDAO.modificar(this.producto);
		producto = new Producto();
	}

	public List<Producto> list(){
		return productoDAO.listar();
	}
}