package acceso;
import java.util.List;

import javax.persistence.TypedQuery;

import anotations.Transactional;
import model.Cuota;
import model.Socio;
import model.Unidad;

public class CuotaDAOhiberjpa extends GeneralDAOhiberjpa<Cuota> implements
		CuotaDAO {

	public CuotaDAOhiberjpa() {
		super(Cuota.class);
	}

	@Transactional(readOnly=true)
	public List<Socio> sociosSinCuotas() {
		TypedQuery<Socio> q = em.createQuery("SELECT socio FROM Socio socio WHERE socio not in (SELECT c.socio FROM Cuota c WHERE MONTH(c.fechaDeEmision) = MONTH(CURRENT_DATE) AND YEAR(c.fechaDeEmision) = YEAR(CURRENT_DATE))", Socio.class);	
		List<Socio> results = q.getResultList();
		return results;
	}
	
	@Transactional(readOnly=true)
	public List<Cuota> listCuotasSociovirtual() {
		TypedQuery<Cuota> q = em.createQuery("SELECT c FROM Cuota c JOIN c.socio cs WHERE cs in (SELECT s FROM SocioVirtual s)", Cuota.class);	
		List<Cuota> results = q.getResultList();
		return results;
	}

	@Transactional(readOnly=true)
	public List<Cuota> listMisCuotasPendientes(Socio socio){
		TypedQuery<Cuota> q = em.createQuery("SELECT c FROM Cuota c JOIN c.socio s WHERE s.id = :id AND c.montoAPagar > 0", Cuota.class);	
		q.setParameter("id", socio.getId());
		List<Cuota> results = q.getResultList();
		return results;
	}

	@Transactional(readOnly=true)
	public List<Cuota> listarPendientes() {
		TypedQuery<Cuota> q = em.createQuery("SELECT c FROM Cuota c WHERE c.montoAPagar > 0", Cuota.class);	
		List<Cuota> results = q.getResultList();
		return results;
	}
	
	@Transactional(readOnly=true)
	public List<Cuota> listarPendientes(Unidad unidad) {
		TypedQuery<Cuota> q = em.createQuery("SELECT c FROM Cuota c JOIN c.socio s WHERE c.montoAPagar > 0 AND s in (SELECT pro FROM Unidad uni JOIN uni.users u JOIN u.profiles pro WHERE uni.id = :id)", Cuota.class);	
		q.setParameter("id", unidad.getId());
		List<Cuota> results = q.getResultList();
		return results;
	}

	@Transactional(readOnly=true)
	public List<Cuota> listar(Unidad unidad) {
		TypedQuery<Cuota> q = em.createQuery("SELECT c FROM Cuota c JOIN c.socio s WHERE s in (SELECT p FROM Unidad uni JOIN uni.users u JOIN u.profiles p WHERE uni.id = :id)  ", Cuota.class);	
		q.setParameter("id", unidad.getId());
		List<Cuota> results = q.getResultList();
		return results;
	}
	
	@Transactional(readOnly=false)
	public void modificar(Cuota cuota) {
		Cuota persistenCuota = em.find(Cuota.class,cuota.getId());
		cuota.restarMontoAPagar(persistenCuota.getMonto()-persistenCuota.getMontoAPagar());
		em.merge(cuota);
	}



}
