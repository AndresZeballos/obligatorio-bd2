package comportamiento;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;

import taller.Auto;
import taller.Presupuesto;

public class CompPresupuesto {

	@SuppressWarnings("rawtypes")
	public void altaPresupuesto(Date fecha, int tiempoReparacion,
			int costoReparacion, Auto auto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"obligatorio", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Presupuesto p = new Presupuesto();
		p.setFecha(fecha);
		p.setTiempoReparacion(tiempoReparacion);
		p.setCostoReparacion(costoReparacion);
		p.setAuto(auto);

		em.persist(p);

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	@SuppressWarnings("rawtypes")
	public long reparacionesPeriodo(Date inicio, Date fin) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"obligatorio", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		long p = (Long) em
				.createQuery(
						"SELECT SUM(x.costoReparacion) FROM Presupuesto x "
								+ "WHERE x.aceptado = true "
								+ "AND x.fecha BETWEEN :start AND :end")
				.setParameter("start", inicio, TemporalType.DATE)
				.setParameter("end", fin, TemporalType.DATE)
				.getResultList().get(0);

		em.getTransaction().commit();

		em.close();
		emf.close();

		return p;
	}
}