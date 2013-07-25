package acceso;

import model.OperadorDeUnidad;

public class OperadorDeUnidadDAOhiberjpa extends
		GeneralDAOhiberjpa<OperadorDeUnidad> implements OperadorDeUnidadDAO {

	public OperadorDeUnidadDAOhiberjpa() {
		super(OperadorDeUnidad.class);
	}

}
