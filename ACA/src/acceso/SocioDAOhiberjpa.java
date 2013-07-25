package acceso;

import model.Socio;

public class SocioDAOhiberjpa extends GeneralDAOhiberjpa<Socio> implements
		SocioDAO {

	public SocioDAOhiberjpa() {
		super(Socio.class);
	}

}
