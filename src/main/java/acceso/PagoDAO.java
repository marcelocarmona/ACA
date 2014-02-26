package acceso;

import java.util.List;

import model.Pago;
import model.Unidad;

public interface PagoDAO extends GeneralDAO<Pago> {

	List<Pago> listar(Unidad unidad);

}
