package comportamiento;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import taller.Auto;
import taller.Cliente;
import taller.Marca;
import taller.Modelo;

public class CompAuto {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void altaAuto(String matricula, int a�o, String color, String chasis, Marca marca, Modelo modelo, Cliente cliente){
		//se chequea que no existe un auto con igual numero de matricula o chasis, en caso de que ya exista, no hago nada
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(
					"obligatorio", new HashMap());
			EntityManager em = emf.createEntityManager();
			try{
				em.getTransaction().begin();
		
				List<Auto> p = (List<Auto>) em
						.createQuery(
								"SELECT a FROM Auto a "
										+ "WHERE a.matricula = :matriculaAuto or a.chasis = :chasisAuto")
						.setParameter("matriculaAuto", matricula)
						.setParameter("chasisAuto", chasis).getResultList();
		
				em.getTransaction().commit();
		
				//si la lista es nula, es porque el auto no existe
				if (p.size()==0){
					//asumimos que la marca, modelo y cliente que se pasan por parametro ya existen en la BD
					em.getTransaction().begin();
					
					Auto auto = new Auto();
					auto.setMatricula(matricula);
					auto.setA�o(a�o);
					auto.setColor(color);
					auto.setChasis(chasis);
					auto.setMarca(marca);
					auto.setModelo(modelo);
					auto.setCliente(cliente);
					
					em.persist(auto);
					em.getTransaction().commit();			
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
		}catch (org.hibernate.exception.GenericJDBCException ex)
		{
			System.out.println("Error: " + ex.getMessage());
		}
	}
}
