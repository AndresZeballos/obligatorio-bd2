package prueba;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import taller.Cliente;

import comportamiento.CompCliente;

public class PruebaBajaCliente {

	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"obligatorio", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Clientes antes de la baja:");
		List<Cliente> l = (List<Cliente>) em.createQuery(
				"Select m From Cliente m").getResultList();
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}

		em.getTransaction().commit();

		CompCliente cp = new CompCliente();

		Date fecha = new Date(Date.UTC(111, 5, 26, 12, 0, 0));
		System.out.println(fecha);

		Cliente cliente = em.find(Cliente.class, 2);

		cp.bajaCliente(cliente, fecha);

		em.getTransaction().begin();

		System.out.println("Clientes luego de la baja:");
		l = (List<Cliente>) em.createQuery("Select m From Cliente m")
				.getResultList();
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
