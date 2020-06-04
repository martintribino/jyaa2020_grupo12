package modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "asistencia")
public class Asistencia implements Serializable {

	/**
	 * Asistencia
	 */

	private static final long serialVersionUID = -8348333341617905617L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
	private String qrcode;
	@Basic
	@OneToOne(
			optional = false,
			fetch = FetchType.EAGER,
			cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			orphanRemoval = true
	)
	private Usuario usuario;
	@Basic
	@OneToOne(
			optional = false,
			fetch = FetchType.EAGER,
			cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			orphanRemoval = true
	)
	private Actividad actividad;

	public Asistencia() {
		this.setQrcode("");
		this.setUsuario(new Usuario());
		this.setActividad(new Actividad());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

}
