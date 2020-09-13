package com.DAOJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.jvnet.hk2.annotations.Service;

import com.IDAO.IActividadDAO;
import com.modelo.Actividad;

@Service
public class ActividadDAOJPA extends GenericDAOJPA<Actividad> implements IActividadDAO {

	/**
	 * Actividad DAO JPA
	 */

	private static final long serialVersionUID = -1514248059399487427L;

	public ActividadDAOJPA() {
		super(Actividad.class);
	}

	@Override
	public Boolean esValida(Actividad actividad) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		List<Actividad> list = new ArrayList<Actividad>();
		try
		{
			if (actividad.getDesde().isAfter(actividad.getHasta()))
				return false;
			transaction.begin();
			TypedQuery<Actividad> consulta = this.getEntityManager()
					.createQuery("SELECT a FROM Actividad a WHERE (:ainicio <= a.hastaDate and :afin >= a.desdeDate and a.espacio.id = :aespacio)", Actividad.class);
			consulta.setParameter("ainicio", actividad.getDesdeDate(), TemporalType.TIMESTAMP);
			consulta.setParameter("afin", actividad.getHastaDate(), TemporalType.TIMESTAMP);
			consulta.setParameter("aespacio", actividad.getEspacio().getId());
			list = consulta.getResultList();
			transaction.commit();
			return list.isEmpty();
		}
		catch (Exception ex)
		{
			transaction.rollback();
			throw ex;
		}
	}

	@Override
	public Boolean esValidaUpdate(Actividad actividad) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		List<Actividad> list = new ArrayList<Actividad>();
		try
		{
			if (actividad.getDesde().isAfter(actividad.getHasta()))
				return false;
			transaction.begin();
			TypedQuery<Actividad> consulta = this.getEntityManager()
					.createQuery("SELECT a FROM Actividad a WHERE ((:ainicio <= a.hastaDate and :afin >= a.desdeDate and a.espacio.id = :aespacio) and (a.id <> :aid))", Actividad.class);
			consulta.setParameter("ainicio", actividad.getDesdeDate(), TemporalType.TIMESTAMP);
			consulta.setParameter("afin", actividad.getHastaDate(), TemporalType.TIMESTAMP);
			consulta.setParameter("aespacio", actividad.getEspacio().getId());
			consulta.setParameter("aid", actividad.getId());
			list = consulta.getResultList();
			transaction.commit();
			return list.isEmpty();
		}
		catch (Exception ex)
		{
			transaction.rollback();
			throw ex;
		}
	}

	@Override
	public Actividad encontrarPorObra(Long idObra) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		List<Actividad> list = new ArrayList<Actividad>();
		try
		{
			transaction.begin();
			TypedQuery<Actividad> consulta = this.getEntityManager()
					.createQuery("SELECT a FROM Actividad a WHERE a.obra.id = :idobra", Actividad.class);
			consulta.setParameter("idobra", idObra);
			list = consulta.getResultList();
			transaction.commit();
			return list.isEmpty() ? null : list.get(0);
		}
		catch (Exception ex)
		{
			transaction.rollback();
			throw ex;
		}
	}

}
