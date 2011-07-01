package prueba;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import taller.Presupuesto;

import comportamiento.CompPresupuesto;

public class PruebaAceptarPresupuesto {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"obligatorio", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		System.out
				.print("Presupuestos aceptados antes de ejecutar la accion: ");
		List<Presupuesto> l = (List<Presupuesto>) em.createQuery(
				"Select p From Presupuesto p Where p.aceptado = true")
				.getResultList();
		System.out.println(l.size());

		em.getTransaction().commit();

		// Cargo: marca, modelo, cliente
		Presupuesto presupuesto = em.find(Presupuesto.class, 6);
		CompPresupuesto compPresupuesto = new CompPresupuesto();
		compPresupuesto.aceptarPresupuesto(presupuesto);

		em.getTransaction().begin();

		System.out
				.print("Presupuestos aceptados despues de ejecutar la accion: ");
		List<Presupuesto> l2 = (List<Presupuesto>) em.createQuery(
				"Select p From Presupuesto p Where p.aceptado = true")
				.getResultList();
		System.out.println(l2.size());

		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
