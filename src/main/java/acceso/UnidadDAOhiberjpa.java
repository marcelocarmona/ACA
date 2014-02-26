package acceso;


import model.Unidad;


public class UnidadDAOhiberjpa extends GeneralDAOhiberjpa<Unidad> implements
		UnidadDAO {

	public UnidadDAOhiberjpa() {
		super(Unidad.class);
	}


}
