package com.DAOJPA;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.jvnet.hk2.annotations.Service;

import com.IDAO.IGenericDAO;
import com.config.EMFFactory;
import com.config.EMFactory;

@Service
public class GenericDAOJPA<T> implements Serializable, IGenericDAO<T> {

	/**
	 * GenericDAOHibJPA
	 */

	private static final long serialVersionUID = 1566326305462430716L;

	private EntityManager entityManager;
	protected Class<T> entityClass;
	
	public GenericDAOJPA(Class<T> clase) {
		this.entityClass = clase;
	}
	
	@PostConstruct
	public void init() {
		EMFFactory emfFactory = new EMFFactory();
		this.entityManager = emfFactory.provide().createEntityManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public T guardar(T entity) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		try
		{
			transaction.begin();
			this.getEntityManager().persist(entity);
			transaction.commit();
			return entity;
		}
		catch (Exception ex)
		{
			transaction.rollback();
			throw ex;
		}
	}

	@Override
	public T actualizar(T entity) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		try
		{
			transaction.begin();
			this.getEntityManager().merge(entity);
			transaction.commit();
			return entity;
		}
		catch (Exception ex)
		{
			transaction.rollback();
			throw ex;
		}
	}

	@Override
	public T encontrar(Long id) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		try
		{
			transaction.begin();
			T objReturn = (T) this.getEntityManager().find(this.entityClass, id);
			transaction.commit();
			return objReturn;
		}
		catch (Exception ex)
		{
			transaction.rollback();
			throw ex;
		}
	}

	@Override
	public T obtenerReferencia(Long id) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		try
		{
			transaction.begin();
			T objReturn = (T) this.getEntityManager().getReference(this.entityClass, id);
			transaction.commit();
			return objReturn;
		}
		catch (Exception ex)
		{
			transaction.rollback();
			throw ex;
		}
	}

	@Override
	public Boolean existe(T entity) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		try
		{
			transaction.begin();
			Boolean ret = this.getEntityManager().contains(entity);
			transaction.commit();
			return ret;
		}
		catch (Exception ex)
		{
			transaction.rollback();
			throw ex;
		}
	}

	@Override
	public Boolean existe(Long id) {
		return this.encontrar(id) != null;
	}

	@Override
	public void eliminar(T entity) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		try
		{
			transaction.begin();
			this.getEntityManager().remove(
					this.getEntityManager().contains(entity) ? entity :
							this.getEntityManager().merge(entity));
			transaction.commit();
		}
		catch (Exception ex)
		{
			transaction.rollback();
			throw ex;
		}
	}

	public T eliminar(Long id) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		try
		{
			transaction.begin();
			 T entity = this.getEntityManager().find(this.entityClass, id);
			 if (entity != null) {
				 this.eliminar(entity);
			 }
			transaction.commit();
			return entity;
		}
		catch (Exception ex)
		{
			transaction.rollback();
			throw ex;
		}
	}

	@Override
	public List<T> listar(String columnOrder, String order) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		List<T> list = new ArrayList<T>();
		try
		{
			String strQuery = String.format("SELECT m FROM %s m ORDER BY m.%s %s",
					this.entityClass.getSimpleName(), columnOrder, order);
			transaction.begin();
			TypedQuery<T> q = this.getEntityManager().createQuery(strQuery, this.entityClass);
			list = (List<T>) q.getResultList();
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
	public List<T> listar() {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		List<T> list = new ArrayList<T>();
		try
		{
			String strQuery = String.format("SELECT m FROM %s m ORDER BY m.id", this.entityClass.getSimpleName());
			transaction.begin();
			TypedQuery<T> q = this.getEntityManager().createQuery(strQuery, this.entityClass);
			list = (List<T>) q.getResultList();
			transaction.commit();
			return list;
		}
		catch (Exception ex)
		{
			transaction.rollback();
			throw ex;
		}
	}

}
