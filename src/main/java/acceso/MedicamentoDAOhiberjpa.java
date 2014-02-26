package acceso;

import model.Medicamento;

public class MedicamentoDAOhiberjpa extends GeneralDAOhiberjpa<Medicamento>
		implements MedicamentoDAO {

	public MedicamentoDAOhiberjpa() {
		super(Medicamento.class);
	}

}
