package prueba;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import comportamiento.CompAuto;
import taller.Marca;
import taller.Modelo;
import taller.Auto;
import taller.Cliente;

public class PruebaAltaAuto {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"obligatorio", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Autos antes del alta:");
		List<Auto> l = (List<Auto>) em.createQuery("Select a From Auto a")
				.getResultList();
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}

		em.getTransaction().commit();

		// Cargo: marca, modelo, cliente
		Marca marca = em.find(Marca.class, 1);
		Modelo modelo = em.find(Modelo.class, 1);
		Cliente cliente = em.find(Cliente.class, 4);
		CompAuto compAuto = new CompAuto();
		compAuto.altaAuto("AAB-3071", 2011, "blanco", "22222222", marca,
				modelo, cliente);

		em.getTransaction().begin();

		System.out.println("Autos despues del alta:");
		List<Auto> l2 = (List<Auto>) em.createQuery("Select a From Auto a")
				.getResultList();
		for (int i = 0; i < l2.size(); i++) {
			System.out.println(l2.get(i));
		}

		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
