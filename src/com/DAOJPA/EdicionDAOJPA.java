package com.DAOJPA;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.jvnet.hk2.annotations.Service;

import com.IDAO.IEdicionDAO;
import com.modelo.Edicion;

@Service
public class EdicionDAOJPA extends GenericDAOJPA<Edicion> implements IEdicionDAO  {

	/**
	 * Edicion DAO JPA
	 */

	private static final long serialVersionUID = -1374953311837165631L;

	public EdicionDAOJPA() {
		super(Edicion.class);
	}

	@Override
	public Boolean esValida(Edicion edicion) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		List<Edicion> list = new ArrayList<Edicion>();
		try
		{
			if (edicion.getDesde().isAfter(edicion.getHasta()))
				return false;
			transaction.begin();
			TypedQuery<Edicion> consulta = this.getEntityManager()
					.createQuery("SELECT e FROM Edicion e WHERE (:einicio <= e.hastaDate and :efin >= e.desdeDate)", Edicion.class);
			consulta.setParameter("einicio", edicion.getDesdeDate(), TemporalType.TIMESTAMP);
			consulta.setParameter("efin", edicion.getHastaDate(), TemporalType.TIMESTAMP);
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
	public Boolean esValidaUpdate(Edicion edicion) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		List<Edicion> list = new ArrayList<Edicion>();
		try
		{
			if (edicion.getDesde().isAfter(edicion.getHasta()))
				return false;
			transaction.begin();
			TypedQuery<Edicion> consulta = this.getEntityManager()
					.createQuery("SELECT e FROM Edicion e WHERE ( e.id <> :eid and (:einicio <= e.hastaDate and :efin >= e.desdeDate))", Edicion.class);
			consulta.setParameter("eid", edicion.getId());
			consulta.setParameter("einicio", edicion.getDesdeDate(), TemporalType.TIMESTAMP);
			consulta.setParameter("efin", edicion.getHastaDate(), TemporalType.TIMESTAMP);
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
	public List<Edicion> recuperarXFecha(LocalDateTime fecha) {
		TypedQuery<Edicion> consulta = this.getEntityManager()
				.createQuery("SELECT e from Edicion e WHERE (e.desde <= :fecha and e.hasta >= :fecha )", Edicion.class);
		consulta.setParameter("fecha", fecha);
		return consulta.getResultList();
	}

}
