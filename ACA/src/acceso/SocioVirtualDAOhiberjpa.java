package acceso;

import model.SocioVirtual;

public class SocioVirtualDAOhiberjpa extends GeneralDAOhiberjpa<SocioVirtual>
		implements SocioVirtualDAO {

	public SocioVirtualDAOhiberjpa() {
		super(SocioVirtual.class);
	}

}
