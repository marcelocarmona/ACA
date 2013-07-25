package acceso;

import model.NoSocio;

public class NoSocioDAOhiberjpa extends GeneralDAOhiberjpa<NoSocio> implements
		NoSocioDAO {

	public NoSocioDAOhiberjpa() {
		super(NoSocio.class);
	}

}
