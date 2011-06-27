package prueba;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;

import comportamiento.CompPresupuesto;

public class PruebaReparacionesPeriodo {

	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"obligatorio", new HashMap());
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		CompPresupuesto cp = new CompPresupuesto();

		Date start = new Date(Date.UTC(90, 5, 26, 12, 0, 0));
		Date end = new Date(Date.UTC(112, 5, 26, 12, 0, 0));

		long p = cp.reparacionesPeriodo(start, end);
		System.out.println(p);

		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
