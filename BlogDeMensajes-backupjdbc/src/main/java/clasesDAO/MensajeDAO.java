package clasesDAO;

import java.util.List;

import clasesObjetosSistema.Mensaje;

public interface MensajeDAO {
	public List<Mensaje> cargar();
	public void guardar(Mensaje m);
	public void eliminar(Mensaje m);
	public Mensaje encontrar(Long id);
}
