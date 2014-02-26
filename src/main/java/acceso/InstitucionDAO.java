package acceso;
import model.Institucion;

public interface InstitucionDAO extends GeneralDAO<Institucion>{

	boolean hasNoSocio(Institucion institucion);


}
