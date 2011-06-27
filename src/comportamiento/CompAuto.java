package comportamiento;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;

import taller.Auto;
import taller.Cliente;
import taller.Presupuesto;
import taller.Marca;
import taller.Modelo;

public class CompAuto {
	@SuppressWarnings({ "rawtypes" })
	public void altaAuto(String matricula, Date año, String color, String chasis, Marca marca, Modelo modelo, Cliente cliente){
		//se chequea que no existe un auto con igual numero de matricula o chasis, en caso de que ya exista, no hago nada
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(
					"obligatorio", new HashMap());
			EntityManager em = emf.createEntityManager();
			try{
				em.getTransaction().begin();
		
				List<Auto> p = (List<Auto>) em
						.createQuery(
								"SELECT x FROM Auto a "
										+ "WHERE a.matricula = :matriculaAuto or a.chasis = :chasisAuto")
						.setParameter("matriculaAuto", matricula)
						.setParameter("chasisAuto", chasis).getResultList();
		
				em.getTransaction().commit();
		
				//si la lista es nula, es porque el auto no existe
				if (p==null){
					//asumimos que la marca, modelo y cliente que se pasan por parametro ya existen en la BD
					em.getTransaction().begin();
					Auto auto = new Auto(matricula, año, color, chasis, marca, modelo, cliente);
					em.persist(auto);
					em.getTransaction().commit();			
					em.close();
					emf.close();
				//si el auto existe, doy el mensaje de error correspondiente	
				}else{
					System.out.println("El auto ya existe");
				}
			}catch (javax.persistence.RollbackException ex)
			{
				System.out.println("Error: " + ex.getMessage());
			}finally{
				em.close();
				emf.close();
			}
		}catch (Exception ex)
		{
			System.out.println("Error: " + ex.getMessage());
		}
	}
}
