package com.IDAO;

import java.util.List;

import org.jvnet.hk2.annotations.Contract;

import com.modelo.Usuario;

@Contract
public interface IUsuarioDAO extends IGenericDAO<Usuario> {

	/**
	 * Usuario DAO interface
	 */

	public List<Usuario> recuperarUsuario(String userName);
	public Usuario encontrarPorNombre(String userName);
}
