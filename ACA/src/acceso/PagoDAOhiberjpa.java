package acceso;

import model.Pago;

public class PagoDAOhiberjpa extends GeneralDAOhiberjpa<Pago> implements
		PagoDAO {

	public PagoDAOhiberjpa() {
		super(Pago.class);
	}

}
