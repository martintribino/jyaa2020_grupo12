package IDAO;

import java.util.List;

import org.jvnet.hk2.annotations.Contract;

import modelo.Actividad;
import modelo.Asistencia;
import modelo.Usuario;

@Contract
public interface IAsistenciaDAO extends IGenericDAO<Asistencia> {

	/**
	 * Asistencia DAO interface
	 */

	public List<Asistencia> recuperarXUsuario(Usuario usuario);
	public List<Asistencia> recuperarXActividad(Actividad actividad);
}
