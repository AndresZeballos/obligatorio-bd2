package prueba;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import taller.Marca;

public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Buenos días Vietman!!!!");
		Date a = new Date(-604070999750L);
		a.setYear(2012);
		System.out.println(a.getYear());
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"obligatorio", new HashMap());
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Marca ev = (Marca) em.find(Marca.class, 1);
		System.out.println(ev + "\n");
		em.getTransaction().commit();

		/*
		em.getTransaction().begin();
		Departamento d = (Departamento) em.find(Departamento.class, 1);
		System.out.println(d + "\n");
		em.getTransaction().commit();

		em.getTransaction().begin();
		List<Persona> l = (List<Persona>) em.createQuery(
				"Select e From Persona e").getResultList();
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i).toString());
		}
		em.getTransaction().commit();
		*/
		
		em.close();
		emf.close();
	}

}
