package clasesDAOImplJdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import clasesDAO.MiDataSource;
import clasesDAO.UsuarioDAO;
import clasesObjetosSistema.Usuario;

public class UsuarioDAOJdbc implements UsuarioDAO {

	@Override
	public List<Usuario> cargar() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try{
			 Connection con = MiDataSource.getDataSource().getConnection();
			 Statement st = (Statement) con.createStatement();
			 ResultSet rs = ((java.sql.Statement) st).executeQuery("Select * from usuario");
			 while (rs.next()) {
				 Usuario usuario = new Usuario();
				 usuario.setNombreUsuario(rs.getString("nombre_usuario"));
				 usuario.setNombre(rs.getString("nombre"));
				 usuario.setApellido(rs.getString("apellido"));
				 usuario.setEmail(rs.getString("email"));
				 usuario.setClave(rs.getString("clave"));
				 usuario.setRol(rs.getString("rol"));
				 usuarios.add(usuario);
			 }
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		return usuarios;
	}

	@Override
	public Usuario encontrar(String username) {
		Usuario usuario = null;
		try{
			 Connection con = MiDataSource.getDataSource().getConnection();
			 Statement st = (Statement) con.createStatement();
			 String sentenciaSql = String.format("Select * from usuario where (nombre_usuario = '%s')", username);
			 ResultSet rs = ((java.sql.Statement) st).executeQuery(sentenciaSql);
			 if (rs.next() == true) {
				 usuario = new Usuario();
				 usuario.setNombreUsuario(rs.getString("nombre_usuario"));
				 usuario.setNombre(rs.getString("nombre"));
				 usuario.setApellido(rs.getString("apellido"));
				 usuario.setEmail(rs.getString("email"));
				 usuario.setClave(rs.getString("clave"));
				 usuario.setRol(rs.getString("rol"));
			 }
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		return usuario;
	}

	@Override
	public void guardar(Usuario u) {
		try{
			Usuario us = this.encontrar(u.getNombreUsuario());
			String sentenciaSql = "";
			if (us == null) {
				sentenciaSql = String.format(
					"INSERT INTO usuario(nombre_usuario, nombre, apellido, email, clave, rol) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
						u.getNombreUsuario(), u.getNombre(), u.getApellido(), u.getEmail(), u.getClave(), u.getRol());
			} else {
				sentenciaSql = String.format(
					"UPDATE usuario SET nombre='%s', apellido='%s', email='%s', clave='%s', rol='%s' WHERE (nombre_usuario='%s')",
						u.getNombre(), u.getApellido(), u.getEmail(), u.getClave(), u.getRol(),u.getNombreUsuario());
			}
			Connection con = MiDataSource.getDataSource().getConnection();
			Statement st = (Statement) con.createStatement();
			((java.sql.Statement) st).executeUpdate(sentenciaSql);
			st.close();
			con.close();
		} catch (java.sql.SQLException e) {
			System.out.println("Error de SQL: "+e.getMessage());
		}
	}

	@Override
	public void eliminar(Usuario u) {
		try{
			String sentenciaSql = String.format("DELETE FROM usuario WHERE (nombre_usuario = '%s')", u.getNombreUsuario());
			Connection con = MiDataSource.getDataSource().getConnection();
			Statement st = (Statement) con.createStatement();
			((java.sql.Statement) st).executeUpdate(sentenciaSql);
			st.close();
			con.close();
		} catch (java.sql.SQLException e) {
			System.out.println("Error de SQL: "+e.getMessage());
		}
	}

}
