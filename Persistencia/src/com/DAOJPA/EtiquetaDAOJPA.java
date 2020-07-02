package com.DAOJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.jvnet.hk2.annotations.Service;

import com.IDAO.IEtiquetaDAO;
import com.modelo.Etiqueta;

@Service
public class EtiquetaDAOJPA extends GenericDAOJPA<Etiqueta> implements IEtiquetaDAO  {

	/**
	 * Etiqueta DAO JPA
	 */

	private static final long serialVersionUID = -6406732253149383426L;

	public EtiquetaDAOJPA() {
		super(Etiqueta.class);
	}

	@Override
	public Etiqueta etiquetaPorNombre(String nombre) {
		EntityTransaction transaction = this.getEntityManager().getTransaction();
		List<Etiqueta> list = new ArrayList<Etiqueta>();
		try
		{
			transaction.begin();
			TypedQuery<Etiqueta> consulta = this.getEntityManager()
					.createQuery("SELECT e FROM Etiqueta e WHERE e.nombre = :nombre", Etiqueta.class);
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

}
