package clasesDAOImplJdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clasesDAO.MensajeDAO;
import clasesDAO.MiDataSource;
import clasesObjetosSistema.Mensaje;
import clasesObjetosSistema.Usuario;

public class MensajeDAOJdbc implements MensajeDAO {

	@Override
	public List<Mensaje> cargar() {
		List<Mensaje> mensajes = new ArrayList<Mensaje>();
		try{
			 Connection con = MiDataSource.getDataSource().getConnection();
			 Statement st = (Statement) con.createStatement();
			 ResultSet rs = ((java.sql.Statement) st).executeQuery("Select * from mensajes");
			 while (rs.next()) {
				 Mensaje mensaje = new Mensaje();
				 mensaje.setNombreUsuario(rs.getString("nombre_usuario"));
				 mensaje.setMensaje(rs.getString("mensaje"));
				 mensajes.add(mensaje);
			 }
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		return mensajes;
	}

	@Override
	public void guardar(Mensaje m) {
		try{
			Connection con = MiDataSource.getDataSource().getConnection();
			Statement st = (Statement) con.createStatement();
			String sentenciaSql = String.format(
				"INSERT INTO mensajes(nombre_usuario, mensaje) VALUES ('%s', '%s')",
					m.getNombreUsuario(), m.getMensaje());
			((java.sql.Statement) st).executeUpdate(sentenciaSql);
			st.close();
			con.close();
		} catch (java.sql.SQLException e) {
			System.out.println("Error de SQL: "+e.getMessage());
		}
	}

	@Override
	public void eliminar(Mensaje m) {
		try{
			String sentenciaSql = String.format("DELETE FROM mensajes WHERE (id = %s)", m.getId());
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
	public Mensaje encontrar(Long id) {
		Mensaje mensaje = null;
		try{
			 Connection con = MiDataSource.getDataSource().getConnection();
			 Statement st = (Statement) con.createStatement();
			 String sentenciaSql = String.format("Select * from Mensajes where (id = %d)", id);
			 ResultSet rs = ((java.sql.Statement) st).executeQuery(sentenciaSql);
			 if (rs.next() == true) {
				 mensaje = new Mensaje();
				 mensaje.setNombreUsuario(rs.getString("nombre_usuario"));
				 mensaje.setMensaje(rs.getString("mensaje"));
			 }
			 rs.close();
			 st.close();
			 con.close();
		 } catch (java.sql.SQLException e) {
			 System.out.println("Error de SQL: "+e.getMessage());
		 }
		return mensaje;
	}

}
