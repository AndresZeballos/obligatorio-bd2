package comportamiento;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
