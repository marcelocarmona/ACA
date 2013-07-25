package acceso;

import model.UnidadCentral;
import model.User;

public class UnidadCentralDAOhiberjpa extends GeneralDAOhiberjpa<UnidadCentral>
		implements UnidadCentralDAO {

	public UnidadCentralDAOhiberjpa() {
		super(UnidadCentral.class);
	}

	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
