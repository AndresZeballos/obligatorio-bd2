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

import comportamiento.CompCliente;

public class PruebaAltaCliente {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
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

		em.getTransaction().begin();
		Marca marca = em.find(Marca.class, 1);
		em.getTransaction().commit();

		System.out.println();

		em.getTransaction().begin();
		Modelo modelo = em.find(Modelo.class, 1);
		em.getTransaction().commit();

		em.getTransaction().begin();

		CompCliente compCliente = new CompCliente();

		Auto auto1 = new Auto();
		auto1.setMatricula("UnaMatricula01");
		auto1.setAño(2021);
		auto1.setColor("Amarillo patito");
		auto1.setChasis("Coche0011");
		auto1.setMarca(marca);
		auto1.setModelo(modelo);

		Auto auto2 = new Auto();

		auto2.setMatricula("UnaMatricula02");
		auto2.setAño(2022);
		auto2.setColor("Amarillo patito");
		auto2.setChasis("Coche0012");
		auto2.setMarca(marca);
		auto2.setModelo(modelo);

		List<Auto> autos = new ArrayList<Auto>();
		autos.add(auto1);
		autos.add(auto2);

		compCliente.altaCliente("Ernesto", "Toledo", "Ecuador M-18 S-08",
				26822222, autos);

		em.getTransaction().commit();

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
