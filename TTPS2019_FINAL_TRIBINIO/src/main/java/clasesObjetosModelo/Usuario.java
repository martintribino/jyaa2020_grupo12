package clasesObjetosModelo;

public class Usuario {

	/**
	 * Clase Usuario
	 */

	private String nombre;
	private String clave;
	
	public Usuario() {
		this.setNombre("");
		this.setClave("");
	}
	
	public Usuario(
			String nombre,
			String clave) {
		this.setNombre(nombre);
		this.setClave(clave);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
}
