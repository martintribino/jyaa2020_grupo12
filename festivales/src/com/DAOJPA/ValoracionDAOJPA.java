package com.DAOJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.jvnet.hk2.annotations.Service;

import com.IDAO.IValoracionDAO;
import com.modelo.Obra;
import com.modelo.Usuario;
import com.modelo.Valoracion;

@Service
public class ValoracionDAOJPA extends GenericDAOJPA<Valoracion> implements IValoracionDAO  {

	/**
	 * Valoracion DAO JPA
	 */
	private static final long serialVersionUID = 7059885887788123453L;

	public ValoracionDAOJPA() {
		super(Valoracion.class);
	}

	@Override
	public Valoracion recuperarXObraYUsuario(Usuario usuario, Obra obra) {
		List<Valoracion> list = new ArrayList<Valoracion>();
		String strQuery = String.format("SELECT a FROM Valoracion a WHERE a.obra.id = :obraid and a.usuario.id = :usuarioid", Valoracion.class);
		TypedQuery<Valoracion> q = this.getEntityManager().createQuery(strQuery, Valoracion.class);
		q.setParameter("obraid", obra.getId());
		q.setParameter("usuarioid", usuario.getId());
		list = q.getResultList();
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<Valoracion> recuperarXUsuario(Usuario usuario) {
		List<Valoracion> list = new ArrayList<Valoracion>();
		String strQuery = String.format("SELECT a FROM Valoracion a WHERE a.usuario.id = :id", Valoracion.class);
		TypedQuery<Valoracion> q = this.getEntityManager().createQuery(strQuery, Valoracion.class);
		q.setParameter("id", usuario.getId());
		list = q.getResultList();
		return list;
	}

	@Override
	public List<Valoracion> recuperarXObra(Obra obra) {
		List<Valoracion> list = new ArrayList<Valoracion>();
		String strQuery = String.format("SELECT a FROM Valoracion a WHERE a.obra.id = :id", Valoracion.class);
		TypedQuery<Valoracion> q = this.getEntityManager().createQuery(strQuery, Valoracion.class);
		q.setParameter("id", obra.getId());
		list = q.getResultList();
		return list;
	}

}
