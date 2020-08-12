package com.DAOJPA;

import org.jvnet.hk2.annotations.Service;

import com.IDAO.INotificacionDAO;
import com.modelo.Notificacion;

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
