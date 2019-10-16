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

import clasesDAO.UsuarioDAO;
import clasesObjetosSistema.Usuario;

public class UsuarioDAOJPA implements UsuarioDAO {
	private EntityManagerFactory emf;

    public UsuarioDAOJPA() {
    	this.emf = Persistence.createEntityManagerFactory("miUP");
    }
    
	@Override
	public List<Usuario> cargar() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		EntityManager manager = emf.createEntityManager();
		EntityTransaction etx = manager.getTransaction();
		etx.begin();
		//Obtengo todos los usuarios
		usuarios = (List<Usuario>)(manager.createQuery("SELECT u from Usuario u order by u.nombreUsuario asc")).getResultList();
		etx.commit();
		manager.close();
		return usuarios;
	}

	@Override
	public Usuario encontrar(String username) {
		Usuario usuario = null;
		EntityManager manager = emf.createEntityManager();
		try{
			Query q = manager.createQuery("SELECT u from Usuario u WHERE u.nombreUsuario = :nombreUsu");
			q.setParameter("nombreUsu", username);
			EntityTransaction etx = manager.getTransaction();
			etx.begin();
			usuario = (Usuario) q.getSingleResult();
			etx.commit();
			manager.close();
		} catch (NoResultException e) {
			System.out.println("No se encontraron resultados: "+e.getMessage());
		} catch (NonUniqueResultException e) {
			System.out.println("Se encontro mas de un resultado: "+e.getMessage());
		}
		return usuario;
	}

	@Override
	public void guardar(Usuario u) {
		Usuario usuario = (Usuario)this.encontrar(u.getNombreUsuario());
		EntityManager manager = emf.createEntityManager();
		EntityTransaction etx = manager.getTransaction();
		etx.begin();
		if (usuario == null) {
			manager.persist(u);
		} else {
			manager.merge(u);
		}
		etx.commit();
		manager.close();
	}

	@Override
	public void eliminar(Usuario u) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction etx = manager.getTransaction();
		etx.begin();
		manager.remove(u);
		etx.commit();
		manager.close();
	}

}
