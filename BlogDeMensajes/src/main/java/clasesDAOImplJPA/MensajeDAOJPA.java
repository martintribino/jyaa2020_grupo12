package clasesDAOImplJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import clasesDAO.MensajeDAO;
import clasesObjetosSistema.Mensaje;

public class MensajeDAOJPA implements MensajeDAO {
	private EntityManagerFactory emf;

    public MensajeDAOJPA() {
    	this.emf = Persistence.createEntityManagerFactory("miUP");
    }

	@Override
	public List<Mensaje> cargar() {
		List<Mensaje> mensajes = new ArrayList<Mensaje>();
		EntityManager manager = emf.createEntityManager();
		EntityTransaction etx = manager.getTransaction();
		etx.begin();
		mensajes = (List<Mensaje>)(manager.createQuery("SELECT m from Mensaje m order by m.mensaje asc")).getResultList();
		etx.commit();
		manager.close();
		return mensajes;
	}

	@Override
	public void guardar(Mensaje m) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction etx = manager.getTransaction();
		etx.begin();
		manager.persist(m);
		etx.commit();
		manager.close();
	}

	@Override
	public void eliminar(Mensaje m) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction etx = manager.getTransaction();
		etx.begin();
		manager.remove(m);
		etx.commit();
		manager.close();
	}

	@Override
	public Mensaje encontrar(Long id) {
		Mensaje mensaje = null;
		EntityManager manager = emf.createEntityManager();
		try{
			Query q = manager.createQuery("SELECT m from Mensaje m WHERE m.id = :id");
			q.setParameter("id", id);
			EntityTransaction etx = manager.getTransaction();
			etx.begin();
			mensaje = (Mensaje) q.getSingleResult();
			etx.commit();
			manager.close();
		} catch (NoResultException e) {
			System.out.println("No se encontraron resultados: "+e.getMessage());
		} catch (NonUniqueResultException e) {
			System.out.println("Se encontro mas de un resultado: "+e.getMessage());
		}
		return mensaje;
	}

}
