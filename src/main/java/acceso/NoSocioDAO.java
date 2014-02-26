package acceso;

import java.util.List;

import model.Institucion;
import model.NoSocio;
import model.User;

public interface NoSocioDAO extends GeneralDAO<NoSocio> {

	NoSocio find(User user);

	List<Institucion> getInstituciones(NoSocio noSocio);

	void removeInstitucion(NoSocio noSocio, Institucion institucion);

}
