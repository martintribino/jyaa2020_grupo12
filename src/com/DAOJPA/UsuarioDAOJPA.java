package com.DAOJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.jvnet.hk2.annotations.Service;

import com.IDAO.IUsuarioDAO;
import com.modelo.Usuario;

@Service
public class UsuarioDAOJPA extends GenericDAOJPA<Usuario> implements IUsuarioDAO  {

	/**
	 * Usuario DAO JPA
	 */

	private static final long serialVersionUID = 40395905312736204L;

	public UsuarioDAOJPA() {
		super(Usuario.class);
	}

	@Override
	public List<Usuario> recuperarUsuario(String userName) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		List<Usuario> list = new ArrayList<Usuario>();
		try
		{
			transaction.begin();
			TypedQuery<Usuario> consulta = this.getEntityManager()
					.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsu", Usuario.class);
			consulta.setParameter("nombreUsu", userName);
			list = consulta.getResultList();
			transaction.commit();
			return list;
		}
		catch (Exception ex)
		{
			transaction.rollback();
			throw ex;
		}
	}

	@Override
	public Usuario encontrarPorNombre(String userName) {
		List<Usuario> lista = this.recuperarUsuario(userName);
		Usuario usuario = null;
		if (!lista.isEmpty()) {
			usuario = lista.get(0);
		}
        return usuario;
	}

}
