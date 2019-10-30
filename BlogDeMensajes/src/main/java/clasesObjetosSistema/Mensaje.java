package clasesObjetosSistema;

import javax.persistence.*;

@Entity
@Table(name = "mensajes")
public class Mensaje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensaje;
	@ManyToOne(optional = false)
	@JoinColumn(name="nombre_usuario")
	private Usuario usuario;

	public Mensaje() {
	}

	public Mensaje(Usuario usuario, String mensaje) {
		this.setUsuario(usuario);
		this.setMensaje(mensaje);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombreUsuario() {
		return this.usuario.getNombreUsuario();
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.usuario.setNombreUsuario(nombreUsuario);
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
