package acceso;

import model.Producto;

public class ProductoDAOhiberjpa extends GeneralDAOhiberjpa<Producto> implements ProductoDAO {

	public ProductoDAOhiberjpa() {
		super(Producto.class);
	}

}
