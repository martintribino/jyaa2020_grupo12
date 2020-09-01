package com.IDAO;

import org.jvnet.hk2.annotations.Contract;

import com.modelo.Artista;

@Contract
public interface IArtistaDAO extends IGenericDAO<Artista> {

	/**
	 * Artista DAO interface
	 */

	void eliminarObras(Long idArtista);
}
