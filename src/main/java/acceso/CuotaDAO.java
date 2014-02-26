package acceso;

import java.util.List;

import model.Cuota;
import model.Socio;
import model.Unidad;

public interface CuotaDAO extends GeneralDAO<Cuota> {

	List<Socio> sociosSinCuotas();

	List<Cuota> listCuotasSociovirtual();

	List<Cuota> listMisCuotasPendientes(Socio socio);

	List<Cuota> listarPendientes();

	List<Cuota> listar(Unidad unidad);

	List<Cuota> listarPendientes(Unidad unidad);

}
