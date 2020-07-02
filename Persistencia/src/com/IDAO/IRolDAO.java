package com.IDAO;

import org.jvnet.hk2.annotations.Contract;

import com.modelo.Rol;

@Contract
public interface IRolDAO extends IGenericDAO<Rol> {

	/**
	 * Rol DAO interface
	 */

	public Rol encontrarPorNombre(String nombre);
	public Rol encontrarPorTipo(Rol.Tipos tipo);

}
