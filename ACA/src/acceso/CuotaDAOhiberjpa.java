package acceso;
import model.Cuota;

public class CuotaDAOhiberjpa extends GeneralDAOhiberjpa<Cuota> implements
		CuotaDAO {

	public CuotaDAOhiberjpa() {
		super(Cuota.class);
	}

}
