package prueba;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import taller.Auto;
import taller.Presupuesto;
import comportamiento.CompPresupuesto;

public class PruebaAltaPresupuesto {

	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"obligatorio", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Presupuestos antes del alta:");
		List<Presupuesto> l = (List<Presupuesto>) em.createQuery(
				"Select m From Presupuesto m").getResultList();
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}

		em.getTransaction().commit();

		CompPresupuesto cp = new CompPresupuesto();

		Date fecha = new Date(Date.UTC(111, 5, 26, 12, 0, 0));
		System.out.println(fecha);
		
		int tiempoReparacion = 6;
		int costoReparacion = 7500;

		Auto auto = em.find(Auto.class, 1);

		cp.altaPresupuesto(fecha, tiempoReparacion, costoReparacion, auto);

		em.getTransaction().begin();

		System.out.println("Presupuestos luego del alta:");
		l = (List<Presupuesto>) em.createQuery("Select m From Presupuesto m")
				.getResultList();
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
		em.getTransaction().commit();

	}
}
