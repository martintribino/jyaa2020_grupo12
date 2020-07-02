package com.IDAO;

import java.util.List;

import org.jvnet.hk2.annotations.Contract;

import com.modelo.Asistencia;
import com.modelo.Obra;
import com.modelo.Usuario;

@Contract
public interface IAsistenciaDAO extends IGenericDAO<Asistencia> {

	/**
	 * Asistencia DAO interface
	 */

	public Asistencia recuperarXObraYUsuario(Usuario usuario, Obra obra);
	public List<Asistencia> recuperarXUsuario(Usuario usuario);
	public List<Asistencia> recuperarXObra(Obra obra);
}
