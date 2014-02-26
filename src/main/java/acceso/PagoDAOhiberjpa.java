package acceso;

import java.util.List;

import javax.persistence.TypedQuery;

import anotations.Transactional;
import model.Cuota;
import model.Pago;
import model.Unidad;

public class PagoDAOhiberjpa extends GeneralDAOhiberjpa<Pago> implements
		PagoDAO {

	public PagoDAOhiberjpa() {
		super(Pago.class);
	}
	
	@Transactional(readOnly=false)
	public void guardar(Pago pago){
		Cuota persistenCuota = em.find(Cuota.class,pago.getCuota().getId());
		persistenCuota.restarMontoAPagar(pago.getMonto());
		em.merge(persistenCuota);
		em.persist(pago);
	}

	@Transactional(readOnly=false)
	public void modificar(Pago pago){
		Pago persistenPago = em.find(Pago.class,pago.getId());
		Cuota persistenCuota = em.find(Cuota.class,pago.getCuota().getId());
		persistenCuota.restarMontoAPagar(pago.getMonto()-persistenPago.getMonto());
		em.merge(persistenCuota);
		em.merge(pago);
	}
	
	@Transactional(readOnly=false)
	public void eliminar(long id) {
		Pago persistenPago = em.find(Pago.class,id);
		Cuota persistenCuota = em.find(Cuota.class,persistenPago.getCuota().getId());
		persistenCuota.sumarMontoAPagar(persistenPago.getMonto());
		em.merge(persistenCuota);
		em.remove(persistenPago);
	}

	@Transactional(readOnly=true)
	public List<Pago> listar(Unidad unidad) {
		TypedQuery<Pago> q = em.createQuery("SELECT p FROM Pago p JOIN p.cuota c JOIN c.socio s WHERE s in (SELECT pro FROM Unidad uni JOIN uni.users u JOIN u.profiles pro WHERE uni.id = :id)  ", Pago.class);	
		q.setParameter("id", unidad.getId());
		List<Pago> results = q.getResultList();
		return results;
	}
}
