package prueba;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import taller.Cliente;
import taller.Presupuesto;

import comportamiento.CompCliente;

public class PruebaReparacionesCliente {

	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"obligatorio", new HashMap());
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		CompCliente cp = new CompCliente();

		Cliente cliente = em.find(Cliente.class, 2);
		Date start = new Date(Date.UTC(100, 5, 26, 12, 0, 0));
		Date end = new Date(Date.UTC(110, 5, 26, 12, 0, 0));

		List<Presupuesto> l3 = cp.reparacionesCliente(cliente, start, end);
		for (int i = 0; i < l3.size(); i++) {
			System.out.println(l3.get(i));
		}
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
