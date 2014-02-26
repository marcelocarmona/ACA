package acceso;

import java.util.List;

import model.AvisoDePago;
import model.SocioVirtual;

public interface AvisoDePagoDAO extends GeneralDAO<AvisoDePago> {

	List<AvisoDePago> list(SocioVirtual profileSocioVirtual);

	void confirmar(AvisoDePago avisoDePago);

	List<AvisoDePago> listPendientes();

}
