package com.DAOJPA;

import org.jvnet.hk2.annotations.Service;

import com.IDAO.IEspacioDAO;
import com.modelo.Espacio;

@Service
public class EspacioDAOJPA extends GenericDAOJPA<Espacio> implements IEspacioDAO  {

	/**
	 * Espacio DAO JPA
	 */
	private static final long serialVersionUID = 32908935125854912L;

	public EspacioDAOJPA() {
		super(Espacio.class);
	}

}
