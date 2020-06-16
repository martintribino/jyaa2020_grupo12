package com.DAOJPA;

import org.jvnet.hk2.annotations.Service;

import com.IDAO.IValoracionDAO;
import com.modelo.Valoracion;

@Service
public class ValoracionDAOJPA extends GenericDAOJPA<Valoracion> implements IValoracionDAO  {

	/**
	 * Valoracion DAO JPA
	 */
	private static final long serialVersionUID = 7059885887788123453L;

	public ValoracionDAOJPA() {
		super(Valoracion.class);
	}

}
