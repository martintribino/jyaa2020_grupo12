package com.DAOJPA;

import org.jvnet.hk2.annotations.Service;

import com.IDAO.IArtistaDAO;
import com.modelo.Artista;

@Service
public class ArtistaDAOJPA extends GenericDAOJPA<Artista> implements IArtistaDAO {

	/**
	 * Artista DAO JPA
	 */

	private static final long serialVersionUID = 2033624595535639253L;

	public ArtistaDAOJPA() {
		super(Artista.class);
	}
}
