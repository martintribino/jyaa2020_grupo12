package clasesObjetosSistema;

public class Mensaje {
	private static final long serialVersionUID = 1L;

	private long id;
	private String nombreUsuario;
	private String mensaje;

	public Mensaje() {
	}

	public Mensaje(String nombreUsuario, String mensaje) {
		this.setNombreUsuario(nombreUsuario);
		this.setMensaje(mensaje);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
