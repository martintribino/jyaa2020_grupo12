package com.DAOJPA;

import java.util.List;

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
		TypedQuery<Usuario> consulta = this.getEntityManager()
				.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsu", Usuario.class);
		consulta.setParameter("nombreUsu", userName);
		return (List<Usuario>) consulta.getResultList();
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
