package comportamiento;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;

import taller.Auto;
import taller.Cliente;
import taller.Presupuesto;
import taller.Marca;
import taller.Modelo;

public class CompAuto {
	public void altaAuto(String matricula, int año, String color, String chasis, Marca marca, Modelo modelo, Cliente cliente){
		//se chequea que no existe un auto con igual numero de matricula o chasis, en caso de que ya exista, no hago nada
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(
					"obligatorio", new HashMap());
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
		}
		//asumimos que la marca, modelo y cliente que se pasan por parametro ya existen en la BD
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(
					"obligatorio", new HashMap());
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Cliente cliente = new Cliente(nombre, apellido, direccion, telefono, autos);
			em.persist(cliente);
			em.getTransaction().commit();			
			em.close();
			emf.close();
		}
		catch (javax.persistence.RollbackException ex)
		{
			System.out.println("Error: " + ex.getMessage());
		}
	}
}
