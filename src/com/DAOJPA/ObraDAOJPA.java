package com.DAOJPA;

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

}
