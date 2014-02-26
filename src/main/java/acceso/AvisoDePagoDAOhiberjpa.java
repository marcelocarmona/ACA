package acceso;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import anotations.Transactional;
import model.AvisoDePago;
import model.Cuota;
import model.Pago;
import model.SocioVirtual;

public class AvisoDePagoDAOhiberjpa extends GeneralDAOhiberjpa<AvisoDePago>
		implements AvisoDePagoDAO {

	public AvisoDePagoDAOhiberjpa() {
		super(AvisoDePago.class);
	}
	
	@Transactional(readOnly=true)
	public List<AvisoDePago> list(SocioVirtual socioVirtual) {
		TypedQuery<AvisoDePago> q = em.createQuery("SELECT a FROM AvisoDePago a JOIN a.cuota c JOIN c.socio s WHERE s.id = :id", AvisoDePago.class);
		q.setParameter("id", socioVirtual.getId());
		List<AvisoDePago> results = q.getResultList();
		return results;
	}

	@Transactional(readOnly=false)
	public void confirmar(AvisoDePago avisoDePago) {
		avisoDePago.setConfirmado(true);
		Pago pago = new Pago(avisoDePago.getCuota(),avisoDePago.getMonto(),new Date());
		Cuota persistenCuota = em.find(Cuota.class,avisoDePago.getCuota().getId());
		persistenCuota.restarMontoAPagar(pago.getMonto());
		em.merge(persistenCuota);
		em.merge(avisoDePago);
		em.persist(pago);
	}

	@Transactional(readOnly=true)
	public List<AvisoDePago> listPendientes() {
		TypedQuery<AvisoDePago> q = em.createQuery("SELECT a FROM AvisoDePago a WHERE a.confirmado = false", AvisoDePago.class);
		List<AvisoDePago> results = q.getResultList();
		return results;
	}

}
