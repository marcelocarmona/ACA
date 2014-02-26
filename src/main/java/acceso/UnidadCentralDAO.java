package acceso;

import model.Institucion;
import model.Medicamento;
import model.Producto;
import model.Unidad;
import model.UnidadCentral;

public interface UnidadCentralDAO extends GeneralDAO<UnidadCentral> {
	
	
	public void save(Institucion institucion);
	
	public void removeAllNoSocios(Institucion institucion);

	public void save(Medicamento medicamento);

	public void save(Producto producto);

	public void save(Unidad unidad);

}
