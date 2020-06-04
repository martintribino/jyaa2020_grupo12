package IDAO;

import java.util.List;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface IGenericDAO<T> {

	/**
	 * Generic DAO interface
	 */

	T guardar(T entity);
	T actualizar(T entity);
	Boolean existe(Long id);
	Boolean existe(T entity);
	T obtenerReferencia(Long id);
	void eliminar(T entity);
	T eliminar(Long id);
	List<T> listar(String columnOrder, String order);
	T encontrar(Long id);
}
