package com.DAOJPA;

import java.util.List;

import javax.persistence.TypedQuery;

import org.jvnet.hk2.annotations.Service;

import com.IDAO.IObraDAO;
import com.modelo.Obra;

@Service
public class ObraDAOJPA extends GenericDAOJPA<Obra> implements IObraDAO  {

	/**
	 * Obra DAO JPA
	 */

	private static final long serialVersionUID = -1228543384742229645L;

	public ObraDAOJPA() {
		super(Obra.class);
	}

	@Override
	public List<Obra> recuperarPorArtista(Long idArtista) {
		String strQuery = String.format("SELECT DISTINCT(o) FROM Obra o WHERE EXISTS (SELECT a FROM Artista a WHERE a.id = :aid AND a MEMBER OF o.artistas)", Obra.class);
		TypedQuery<Obra> q = this.getEntityManager().createQuery(strQuery, Obra.class);
		q.setParameter("aid", idArtista);
		return q.getResultList();
	}

}
