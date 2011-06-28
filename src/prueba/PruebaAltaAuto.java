package prueba;

import java.util.Date;
import java.util.HashMap;

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
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"obligatorio", new HashMap());
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// TODO Auto-generated method stub

		//Cargo: marca, modelo, cliente
		Marca marca = em.find(Marca.class, 1);
		Modelo modelo = em.find(Modelo.class, 1);
		Cliente cliente = em.find(Cliente.class, 4);
		Date anio = new Date(Date.UTC(111, 5, 26, 12, 0, 0));
		CompAuto compAuto = new CompAuto();
		compAuto.altaAuto("AAB-3070", anio, "blanco", "1111111111", marca, modelo, cliente);
		em.close();
		emf.close();
	}

}
