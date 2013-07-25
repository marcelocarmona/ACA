package acceso;

import model.Institucion;

public class InstitucionDAOhiberjpa extends GeneralDAOhiberjpa<Institucion> implements InstitucionDAO{

	// ver si esta bien pensado esto <----------------
	public InstitucionDAOhiberjpa(){
		super(Institucion.class);
	}
	
	//consultas especificas de Instituciones

}

