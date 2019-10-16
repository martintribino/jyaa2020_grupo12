package clasesDAO;

import java.util.List;

import clasesObjetosSistema.Usuario;

public interface UsuarioDAO {
	public List<Usuario> cargar();
	public Usuario encontrar(String username);
	public void guardar(Usuario u);
	public void eliminar(Usuario u);
}
