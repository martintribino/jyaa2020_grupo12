package clasesObjetosModelo;

import java.io.Serializable;

import clasesObjetosModelo.Encrypt;

public class Persona implements Serializable {
	/**
	 * Clase Persona
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellido;
	private int dni;
	private int telefono;
	private String email;
	private String domicilio;
	private Usuario usuario;
	
	protected Persona() {
		this.setNombre("");
		this.setApellido("");
		this.setEmail("");
		this.setDni(0);
		this.setTelefono(0);
		this.setDomicilio("");
		this.setUsuario(null);
	}
	
	protected Persona(
			String nombreUsuario,
			String nombre,
			String apellido,
			String claveStr,
			String email,
			int dni,
			int telefono,
			String domicilio) {
		String pass = Encrypt.encryptWithMD5(claveStr);
		Usuario u = new Usuario(nombreUsuario, pass);
		this.setUsuario(u);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEmail(email);
		this.setDni(dni);
		this.setTelefono(telefono);
		this.setDomicilio(domicilio);
	}

	
	protected Boolean verificarClave(String claveStr) {
		String pass = Encrypt.encryptWithMD5(claveStr);
		String clav = this.getUsuario().getClave();
		int returnCheck = clav.compareTo(pass);
		return returnCheck == 0;
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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
