package com.IDAO;

import java.util.List;

import org.jvnet.hk2.annotations.Contract;

import com.modelo.Actividad;
import com.modelo.Asistencia;
import com.modelo.Usuario;

@Contract
public interface IAsistenciaDAO extends IGenericDAO<Asistencia> {

	/**
	 * Asistencia DAO interface
	 */

	public List<Asistencia> recuperarXUsuario(Usuario usuario);
	public List<Asistencia> recuperarXActividad(Actividad actividad);
}
