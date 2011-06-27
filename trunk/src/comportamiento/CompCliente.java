package comportamiento;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;

import taller.Cliente;
import taller.Presupuesto;

public class CompCliente {

	@SuppressWarnings("rawtypes")
	public void bajaCliente(Cliente cliente, Date baja) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"obligatorio", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		cliente.setBaja(baja);

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Presupuesto> reparacionesCliente(Cliente cliente, Date inicio,
			Date fin) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"obligatorio", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<Presupuesto> p = (List<Presupuesto>) em
				.createQuery(
						"SELECT x FROM Presupuesto x, Auto a "
								+ "WHERE a.cliente.id = :id "
								+ "AND x.auto.id = a.id "
								+ "AND x.aceptado = true "
								+ "AND x.fecha BETWEEN :start AND :end ORDER BY x.fecha")
				.setParameter("start", inicio, TemporalType.DATE)
				.setParameter("end", fin, TemporalType.DATE)
				.setParameter("id", cliente.getId()).getResultList();

		em.getTransaction().commit();

		em.close();
		emf.close();

		return p;
	}
}
