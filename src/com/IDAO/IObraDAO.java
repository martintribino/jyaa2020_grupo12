package com.IDAO;

import java.util.List;

import org.jvnet.hk2.annotations.Contract;

import com.modelo.Obra;

@Contract
public interface IObraDAO extends IGenericDAO<Obra> {

	/**
	 * Obra DAO interface
	 */

	public List<Obra> recuperarPorArtista(Long idArtista);
}
