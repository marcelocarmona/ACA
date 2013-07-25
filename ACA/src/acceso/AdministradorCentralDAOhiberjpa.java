package acceso;

import model.AdministradorCentral;

public class AdministradorCentralDAOhiberjpa extends
		GeneralDAOhiberjpa<AdministradorCentral> implements
		AdministradorCentralDAO {

	public AdministradorCentralDAOhiberjpa() {
		super(AdministradorCentral.class);
	}

}
