package com.IDAO;

import java.time.LocalDateTime;
import java.util.List;

import org.jvnet.hk2.annotations.Contract;

import com.modelo.Edicion;

@Contract
public interface IEdicionDAO extends IGenericDAO<Edicion> {

	/**
	 * Edicion DAO interface
	 */

	public List<Edicion> recuperarXFecha(LocalDateTime fecha);
}
