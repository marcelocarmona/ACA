package acceso;

import model.AvisoDePago;

public class AvisoDePagoDAOhiberjpa extends GeneralDAOhiberjpa<AvisoDePago>
		implements AvisoDePagoDAO {

	public AvisoDePagoDAOhiberjpa() {
		super(AvisoDePago.class);
	}

}
