package com.modelo;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "asistencia",uniqueConstraints={@UniqueConstraint(name = "usuario_actividad", columnNames={"usuario_id", "actividad_id"})})
public class Asistencia implements Serializable {

	/**
	 * Asistencia
	 */

	public static enum Estados {
		ACTIVA, ASISTIO, INACTIVA, NOASISTIO,
	};

	private static final long serialVersionUID = -8348333341617905617L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="qrcode", unique = true, updatable = true)
	private String qrcode;
	@Basic
	private Asistencia.Estados estado;
	@ManyToOne(optional = false)
	@JoinColumn(name="usuario_id", nullable = false)
	private Usuario usuario;
	@ManyToOne(optional = false)
	@JoinColumn(name="actividad_id", nullable = false)
	private Actividad actividad;

	public Asistencia() {
		UUID uuid = UUID.randomUUID();
		this.setQrcode(uuid.toString());
		this.setEstado(Asistencia.Estados.ACTIVA);
		this.setUsuario(null);
		this.setActividad(null);
	}

	public Asistencia(Usuario usuario, Actividad actividad) {
		UUID uuid = UUID.randomUUID();
		this.setQrcode(uuid.toString());
		this.setEstado(Asistencia.Estados.ACTIVA);
		this.setUsuario(usuario);
		this.setActividad(actividad);
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

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public Asistencia.Estados getEstado() {
		return estado;
	}

	public void setEstado(Asistencia.Estados estado) {
		this.estado = estado;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asistencia other = (Asistencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
			else if (!qrcode.equals(other.qrcode))
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
