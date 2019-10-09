package clasesObjetosSistema;

import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nombreUsuario;
	private String nombre;
	private String apellido;
	private String email;
	private String clave;
	private String rol;
	
	public Usuario() {
	}
	
	public Usuario(
			String nombreUsuario,
			String claveStr,
			String email,
			String rol) {
		String pass = Encrypt.encryptWithMD5(claveStr);
		this.setNombreUsuario(nombreUsuario);
		this.setNombre("");
		this.setApellido("");
		this.setEmail(email);
		this.setClave(pass);
		this.setRol(rol);
	}
	
	public Usuario(
			String nombreUsuario,
			String nombre,
			String apellido,
			String claveStr,
			String email,
			String rol) {
		String pass = Encrypt.encryptWithMD5(claveStr);
		this.setNombreUsuario(nombreUsuario);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEmail(email);
		this.setClave(pass);
		this.setRol(rol);
	}
	
	public Boolean verificarClave(String claveStr) {
		String pass = Encrypt.encryptWithMD5(claveStr);
		String clav = this.getClave();
		int returnCheck = clav.compareTo(pass);
		return returnCheck == 0;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
