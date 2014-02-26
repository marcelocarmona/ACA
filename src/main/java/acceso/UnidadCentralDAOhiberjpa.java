package acceso;


import java.util.List;

import javax.persistence.TypedQuery;

import anotations.Transactional;
import model.Institucion;
import model.Medicamento;
import model.Producto;
import model.Unidad;
import model.UnidadCentral;
import model.NoSocio;

public class UnidadCentralDAOhiberjpa extends GeneralDAOhiberjpa<UnidadCentral> implements UnidadCentralDAO {

	public UnidadCentralDAOhiberjpa() {
		super(UnidadCentral.class);
	}

	@Transactional(readOnly=false)
	public void save(Institucion institucion){
		//supongo que la unidadCentral es la que tiene el id 1
		UnidadCentral unidadCentral = em.find(UnidadCentral.class,(long)1);
		unidadCentral.add(institucion);
	}

	@Transactional(readOnly=false)
	public void removeAllNoSocios(Institucion institucion) {	
		//Eliminar la institucion de todos los noSocios
		TypedQuery<NoSocio> q = em.createQuery("SELECT n FROM NoSocio n JOIN n.instituciones i WHERE i.id = :id", NoSocio.class);	
		q.setParameter("id", institucion.getId());
		List<NoSocio> NoSocioList = q.getResultList();
		
		Institucion persistInstitucion = em.find(Institucion.class, institucion.getId());
		
		for (NoSocio noSocio : NoSocioList) {
			noSocio.getInstituciones().remove(persistInstitucion);
			em.merge(noSocio);
		}
	}
	
	@Transactional(readOnly=false)
	public void save(Medicamento medicamento){
		//supongo que la unidadCentral es la que tiene el id 1
		UnidadCentral unidadCentral = em.find(UnidadCentral.class,(long)1);
		unidadCentral.add(medicamento);
	}

	@Transactional(readOnly=false)
	public void save(Producto producto) {
		//supongo que la unidadCentral es la que tiene el id 1
		UnidadCentral unidadCentral = em.find(UnidadCentral.class,(long)1);
		unidadCentral.add(producto);
	}

	@Transactional(readOnly=false)
	public void save(Unidad unidad) {
		//supongo que la unidadCentral es la que tiene el id 1
		UnidadCentral unidadCentral = em.find(UnidadCentral.class,(long)1);
		unidadCentral.add(unidad);
	}



}
