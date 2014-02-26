package aspects;

import java.lang.reflect.Field;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.aspectj.lang.reflect.MethodSignature;

import anotations.Transactional;

public aspect TransactionalAspect {
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("ACA");

	Object around():execution(@Transactional * *(..)){
		Object obj = null;
		EntityManager em = null;

//		System.out.println(" ENTRO ASPECT " + thisJoinPoint.getSignature());

		MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();
		Transactional annotation = methodSignature.getMethod().getAnnotation(Transactional.class);

		Object dao = thisJoinPoint.getTarget();

		try {

			for (Field daoFieldEntityManager : dao.getClass().getFields()) {
				if (daoFieldEntityManager.getType().equals(javax.persistence.EntityManager.class)) {

					em = emf.createEntityManager();
					daoFieldEntityManager.set(dao, em);

					if (annotation.readOnly() == false) {
						em.getTransaction().begin();
						obj = proceed();
						em.getTransaction().commit();
					} else {
						obj = proceed();
					}
			
					em.close();
				}
			}

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

//		System.out.println(" SALGO ASPECT " + thisJoinPoint.getSignature());

		return obj;

	}
}
