package com.DAOJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.jvnet.hk2.annotations.Service;

import com.IDAO.IRolDAO;
import com.modelo.Rol;
import com.modelo.Rol.Tipos;

@Service
public class RolDAOJPA extends GenericDAOJPA<Rol> implements IRolDAO  {

	/**
	 * Rol DAO JPA
	 */

	private static final long serialVersionUID = -7289218776157497399L;

	public RolDAOJPA() {
		super(Rol.class);
	}

	@Override
	public Rol encontrarPorNombre(String nombre) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		List<Rol> list = new ArrayList<Rol>();
		try
		{
			transaction.begin();
			TypedQuery<Rol> consulta = this.getEntityManager()
					.createQuery("SELECT r FROM Rol r WHERE r.nombre = :nombre", Rol.class);
			consulta.setParameter("nombre", nombre);
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

	@Override
	public Rol encontrarPorTipo(Tipos tipo) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		List<Rol> list = new ArrayList<Rol>();
		try
		{
			transaction.begin();
			TypedQuery<Rol> consulta = this.getEntityManager()
					.createQuery("SELECT r FROM Rol r WHERE r.tipo = :tipo", Rol.class);
			consulta.setParameter("tipo", tipo);
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
