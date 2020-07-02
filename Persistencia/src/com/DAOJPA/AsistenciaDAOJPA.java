package com.DAOJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.jvnet.hk2.annotations.Service;

import com.IDAO.IAsistenciaDAO;
import com.modelo.Asistencia;
import com.modelo.Obra;
import com.modelo.Usuario;

@Service
public class AsistenciaDAOJPA extends GenericDAOJPA<Asistencia> implements IAsistenciaDAO {

	/**
	 * Asistencia DAO JPA
	 */
	private static final long serialVersionUID = 3571461071287820763L;

	public AsistenciaDAOJPA() {
		super(Asistencia.class);
	}

	@Override
	public List<Asistencia> recuperarXUsuario(Usuario usuario) {
		List<Asistencia> list = new ArrayList<Asistencia>();
		String strQuery = String.format("SELECT a FROM Asistencia a WHERE a.usuario.id = :id", Asistencia.class);
		TypedQuery<Asistencia> q = this.getEntityManager().createQuery(strQuery, Asistencia.class);
		q.setParameter("id", usuario.getId());
		list = q.getResultList();
		return list;
	}

	@Override
	public List<Asistencia> recuperarXObra(Obra obra) {
		List<Asistencia> list = new ArrayList<Asistencia>();
		String strQuery = String.format("SELECT a FROM Asistencia a WHERE a.obra.id = :id", Asistencia.class);
		TypedQuery<Asistencia> q = this.getEntityManager().createQuery(strQuery, Asistencia.class);
		q.setParameter("id", obra.getId());
		list = q.getResultList();
		return list;
	}

	@Override
	public Asistencia recuperarXObraYUsuario(Usuario usuario, Obra obra) {
		List<Asistencia> list = new ArrayList<Asistencia>();
		String strQuery = String.format("SELECT a FROM Asistencia a WHERE a.obra.id = :obraid and a.usuario.id = :usuarioid", Asistencia.class);
		TypedQuery<Asistencia> q = this.getEntityManager().createQuery(strQuery, Asistencia.class);
		q.setParameter("obraid", obra.getId());
		q.setParameter("usuarioid", usuario.getId());
		list = q.getResultList();
		return list.isEmpty() ? null : list.get(0);
	}

}
