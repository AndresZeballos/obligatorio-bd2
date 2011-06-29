package prueba;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import taller.Auto;
import taller.Cliente;
import taller.Marca;
import taller.Modelo;

import comportamiento.CompAuto;
import comportamiento.CompCliente;

public class PruebaAltaCliente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"obligatorio", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Clientes antes del alta:");
		List<Cliente> l = (List<Cliente>) em.createQuery(
				"Select c From Cliente c").getResultList();
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}

		em.getTransaction().commit();

		CompCliente compCliente = new CompCliente();
		
		Auto auto1 = em.find(Auto.class, 1);
		Auto auto2 = em.find(Auto.class, 2);
		List<Auto> autos = new ArrayList<Auto>();
		autos.add(auto1);
		autos.add(auto2);
		
		compCliente.altaCliente("Ernesto", "Toledo", "Ecuador M-18 S-08", 26822222, autos);
		
		em.getTransaction().begin();

		System.out.println("Clientes despues del alta:");
		List<Cliente> l2 = (List<Cliente>) em.createQuery(
				"Select c From Cliente c").getResultList();
		for (int i = 0; i < l2.size(); i++) {
			System.out.println(l2.get(i));
		}

		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
