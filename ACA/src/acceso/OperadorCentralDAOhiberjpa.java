package acceso;

import model.OperadorCentral;

public class OperadorCentralDAOhiberjpa extends
		GeneralDAOhiberjpa<OperadorCentral> implements OperadorCentralDAO {

	public OperadorCentralDAOhiberjpa() {
		super(OperadorCentral.class);

	}

}
