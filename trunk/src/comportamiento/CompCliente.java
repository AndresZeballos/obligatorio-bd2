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

public class CompCliente {
	@SuppressWarnings({ "rawtypes" })
	public void altaCliente(String nombre, String apellido, String direccion,
			int telefono, List<Auto> autos) {
		// asumimos que los autos que se pasan por parametro ya existen en la BD
		// no se hace control sobre duplicados de personas ya que no se cuenta
		// con el documento de la misma
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(
					"obligatorio", new HashMap());
			EntityManager em = emf.createEntityManager();
			try {
				em.getTransaction().begin();
				Cliente cliente = new Cliente();
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setDireccion(direccion);
				cliente.setTelefono(telefono);

				em.persist(cliente);

				em.getTransaction().commit();

				em.getTransaction().begin();
				for (int i = 0; i < autos.size(); i++) {

					autos.get(i).setCliente(cliente);
					em.persist(autos.get(i));
				}
				em.getTransaction().commit();

				em.getTransaction().begin();
				cliente.setAutos(autos);

			} catch (javax.persistence.RollbackException ex) {
				System.out.println("Error: " + ex.getMessage());
				System.out.println("Causa: " + ex.getCause());
			} finally {
				em.close();
				emf.close();
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}

	@SuppressWarnings("rawtypes")
	public void bajaCliente(Cliente cliente, Date baja) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(
					"obligatorio", new HashMap());
			EntityManager em = emf.createEntityManager();
			try {
				em.getTransaction().begin();

				cliente.setBaja(baja);

				em.getTransaction().commit();
			} catch (javax.persistence.RollbackException ex) {
				System.out.println("Error: " + ex.getMessage());
			} finally {
				em.close();
				emf.close();
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Presupuesto> reparacionesCliente(Cliente cliente, Date inicio,
			Date fin) {
		List<Presupuesto> p;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(
					"obligatorio", new HashMap());
			EntityManager em = emf.createEntityManager();
			try {
				em.getTransaction().begin();

				p = (List<Presupuesto>) em
						.createQuery(
								"SELECT x FROM Presupuesto x, Auto a "
										+ "WHERE a.cliente.id = :id "
										+ "AND x.auto.id = a.id "
										+ "AND x.aceptado = true "
										+ "AND x.fecha BETWEEN :start AND :end ORDER BY x.fecha")
						.setParameter("start", inicio, TemporalType.DATE)
						.setParameter("end", fin, TemporalType.DATE)
						.setParameter("id", cliente.getId()).getResultList();

				em.getTransaction().commit();
			} catch (javax.persistence.RollbackException ex) {
				System.out.println("Error: " + ex.getMessage());
				p = null;
			} finally {
				em.close();
				emf.close();
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			p = null;
		}
		return p;
	}
}
