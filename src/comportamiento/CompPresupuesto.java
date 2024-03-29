package comportamiento;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;

import taller.Auto;
import taller.Presupuesto;

public class CompPresupuesto {

	@SuppressWarnings("rawtypes")
	public void altaPresupuesto(Date fecha, int tiempoReparacion,
			int costoReparacion, Auto auto) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(
					"obligatorio", new HashMap());
			EntityManager em = emf.createEntityManager();
			try {
				em.getTransaction().begin();

				Presupuesto p = new Presupuesto();
				p.setFecha(fecha);
				p.setTiempoReparacion(tiempoReparacion);
				p.setCostoReparacion(costoReparacion);
				p.setAuto(auto);

				em.persist(p);

				em.getTransaction().commit();
			} catch (javax.persistence.RollbackException ex) {
				System.out.println("Error: " + ex.getMessage());
			} finally {
				em.close();
				emf.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public long reparacionesPeriodo(Date inicio, Date fin) {
		long p = 0;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(
					"obligatorio", new HashMap());
			EntityManager em = emf.createEntityManager();
			try {
				em.getTransaction().begin();

				p = (Long) em
						.createQuery(
								"SELECT SUM(x.costoReparacion) FROM Presupuesto x "
										+ "WHERE x.aceptado = true "
										+ "AND x.fecha BETWEEN :start AND :end")
						.setParameter("start", inicio, TemporalType.DATE)
						.setParameter("end", fin, TemporalType.DATE)
						.getResultList().get(0);

				em.getTransaction().commit();
			} catch (javax.persistence.RollbackException ex) {
				System.out.println("Error: " + ex.getMessage());
			} finally {
				em.close();
				emf.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public void aceptarPresupuesto(Presupuesto presupuesto){
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(
					"obligatorio", new HashMap());
			EntityManager em = emf.createEntityManager();
			try {
				em.getTransaction().begin();
				if (presupuesto.isAceptado()){
					System.out.println("El presupuesto ya esta aceptado");
				}else{
					presupuesto.setAceptado(true);
				}
				em.getTransaction().commit();
			}catch(javax.persistence.RollbackException ex)
			{
				System.out.println("Error: " + ex.getMessage());
			}
			finally
			{
				em.close();
				emf.close();
			}
		}catch(Exception ex)
		{
			System.out.println("Error: " + ex.getMessage());
		}
	}
}
