package comportamiento;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import taller.Cliente;

public class CompCliente {

	@SuppressWarnings("rawtypes")
	public void bajaCliente(Cliente cliente, Date baja){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"obligatorio", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		cliente.setBaja(baja);

		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
