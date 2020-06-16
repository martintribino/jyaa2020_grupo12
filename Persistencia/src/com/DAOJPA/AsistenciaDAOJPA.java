package com.DAOJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.jvnet.hk2.annotations.Service;

import com.IDAO.IAsistenciaDAO;
import com.modelo.Actividad;
import com.modelo.Asistencia;
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
		String strQuery = String.format("SELECT a FROM %s a WHERE a.usuario.id = :id", Asistencia.class);
		TypedQuery<Asistencia> q = this.getEntityManager().createQuery(strQuery, Asistencia.class);
		q.setParameter("id", usuario.getId());
		list = q.getResultList();
		return list;
	}

	@Override
	public List<Asistencia> recuperarXActividad(Actividad actividad) {
		List<Asistencia> list = new ArrayList<Asistencia>();
		String strQuery = String.format("SELECT a FROM %s a WHERE a.actividad.id = :id", Asistencia.class);
		TypedQuery<Asistencia> q = this.getEntityManager().createQuery(strQuery, Asistencia.class);
		q.setParameter("id", actividad.getId());
		list = q.getResultList();
		return list;
	}

}
