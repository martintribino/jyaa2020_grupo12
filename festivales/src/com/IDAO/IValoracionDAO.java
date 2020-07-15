package com.IDAO;

import java.util.List;

import org.jvnet.hk2.annotations.Contract;

import com.modelo.Obra;
import com.modelo.Usuario;
import com.modelo.Valoracion;

@Contract
public interface IValoracionDAO extends IGenericDAO<Valoracion> {

	/**
	 * Valoracion DAO interface
	 */

	public Valoracion recuperarXObraYUsuario(Usuario usuario, Obra obra);
	public List<Valoracion> recuperarXUsuario(Usuario usuario);
	public List<Valoracion> recuperarXObra(Obra obra);

}
