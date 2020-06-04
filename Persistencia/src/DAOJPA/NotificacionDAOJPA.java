package DAOJPA;

import org.jvnet.hk2.annotations.Service;

import IDAO.INotificacionDAO;
import modelo.Notificacion;

@Service
public class NotificacionDAOJPA extends GenericDAOJPA<Notificacion> implements INotificacionDAO  {

	/**
	 * Notificacion DAO JPA
	 */
	private static final long serialVersionUID = -133486596074746792L;

	public NotificacionDAOJPA() {
		super(Notificacion.class);
	}

}
