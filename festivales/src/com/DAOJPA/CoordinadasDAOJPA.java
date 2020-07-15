package com.DAOJPA;

import org.jvnet.hk2.annotations.Service;

import com.IDAO.ICoordinadasDAO;
import com.modelo.Coordinadas;

@Service
public class CoordinadasDAOJPA extends GenericDAOJPA<Coordinadas> implements ICoordinadasDAO  {

	/**
	 * Coordinadas DAO JPA
	 */

	private static final long serialVersionUID = -6210061198864261941L;

	public CoordinadasDAOJPA() {
		super(Coordinadas.class);
	}

}
