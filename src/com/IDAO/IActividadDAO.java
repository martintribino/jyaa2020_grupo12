package com.IDAO;

import org.jvnet.hk2.annotations.Contract;

import com.modelo.Actividad;

@Contract
public interface IActividadDAO extends IGenericDAO<Actividad> {

	/**
	 * Actividad DAO interface
	 */

	public Boolean esValida(Actividad actividad);
	public Boolean esValidaUpdate(Actividad actividad);
	public Actividad encontrarPorObra(Long idObra);

}
