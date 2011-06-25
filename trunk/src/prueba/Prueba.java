package prueba;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import taller.Auto;
import taller.Cliente;
import taller.Marca;
import taller.Modelo;
import taller.Presupuesto;

public class Prueba {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public static void main(String[] args) {
		/*
		System.out.println("Buenos días Vietman!!!!");
		Date a = new Date(-604070999750L);
		a.setYear(2012);
		System.out.println(a.getYear() + "\n");
		*/
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"obligatorio", new HashMap());
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		List<Marca> l = (List<Marca>) em
				.createQuery("Select m From Marca m").getResultList();
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i).getMarca());
		}
		em.getTransaction().commit();

		System.out.println();
		
		em.getTransaction().begin();
		List<Modelo> l0 = (List<Modelo>) em
				.createQuery("Select m From Modelo m").getResultList();
		for (int i = 0; i < l0.size(); i++) {
			System.out.println(l0.get(i).getModelo());
		}
		em.getTransaction().commit();

		System.out.println();
		
		em.getTransaction().begin();
		List<Cliente> l1 = (List<Cliente>) em
				.createQuery("Select m From Cliente m").getResultList();
		for (int i = 0; i < l1.size(); i++) {
			System.out.println(l1.get(i).getNombre());
		}
		em.getTransaction().commit();
		
		System.out.println();
		
		em.getTransaction().begin();
		List<Auto> l2 = (List<Auto>) em
				.createQuery("Select m From Auto m").getResultList();
		for (int i = 0; i < l2.size(); i++) {
			System.out.println(l2.get(i).getMatricula());
		}
		em.getTransaction().commit();
		
		System.out.println();
	
		em.getTransaction().begin();
		List<Presupuesto> l3 = (List<Presupuesto>) em
				.createQuery("Select m From Presupuesto m").getResultList();
		for (int i = 0; i < l3.size(); i++) {
			System.out.println(l3.get(i).getFecha());
		}
		em.getTransaction().commit();
		
		System.out.println();
	
		/*
		 * em.getTransaction().begin(); Modelo mo = (Modelo)
		 * em.find(Modelo.class, 1); System.out.println(mo.getModelo() + "\n");
		 * em.getTransaction().commit();
		 * 
		 * /* em.getTransaction().begin(); Departamento d = (Departamento)
		 * em.find(Departamento.class, 1); System.out.println(d + "\n");
		 * em.getTransaction().commit();
		 * 
		 * em.getTransaction().begin(); List<Persona> l = (List<Persona>)
		 * em.createQuery( "Select e From Persona e").getResultList(); for (int
		 * i = 0; i < l.size(); i++) { System.out.println(l.get(i).toString());
		 * } em.getTransaction().commit();
		 */

		em.close();
		emf.close();
	}

}
