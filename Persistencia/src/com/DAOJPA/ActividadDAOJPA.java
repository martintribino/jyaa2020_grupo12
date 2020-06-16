package com.DAOJPA;

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

}
