package DAOJPA;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.TypedQuery;

import org.jvnet.hk2.annotations.Service;

import IDAO.IEdicionDAO;
import modelo.Edicion;

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
	public List<Edicion> recuperarXFecha(LocalDateTime fecha) {
		TypedQuery<Edicion> consulta = this.getEntityManager()
				.createQuery("SELECT e from Edicion e WHERE (e.desde <= :fecha and e.hasta >= :fecha )", Edicion.class);
		consulta.setParameter("fecha", fecha);
		return consulta.getResultList();
	}

}
