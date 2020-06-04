package DAOJPA;

import org.jvnet.hk2.annotations.Service;

import IDAO.IActividadDAO;
import modelo.Actividad;

@Service
public class ActividadDAOJPA extends GenericDAOJPA<Actividad> implements IActividadDAO {

	/**
	 * Actividad DAO JPA
	 */

	private static final long serialVersionUID = -1514248059399487427L;

	public ActividadDAOJPA() {
		super(Actividad.class);
	}

}
