package com.modelo;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "asistencia",uniqueConstraints={@UniqueConstraint(name = "usuario_obra", columnNames={"usuario_id", "obra_id"})})
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
	@JsonIgnore
	private Long id;
	@Column(name="qrcode", unique = true, updatable = true)
    @JsonProperty(access = Access.READ_ONLY)
	private String qrcode;
	@Basic
	private Asistencia.Estados estado;
	@OneToOne(
			optional = false,
			fetch = FetchType.EAGER,
			cascade = {CascadeType.REFRESH},
			orphanRemoval = true
	)
	@JsonIgnore
	@JoinColumn(name="usuario_id", nullable = false)
	private Usuario usuario;
	@OneToOne(
			optional = false,
			fetch = FetchType.EAGER,
			cascade = {CascadeType.REFRESH},
			orphanRemoval = true
	)
	@JsonIgnore
	@JoinColumn(name="obra_id", nullable = false)
	private Obra obra;

	public Asistencia() {
		UUID uuid = UUID.randomUUID();
		this.setQrcode(uuid.toString());
		this.setEstado(Asistencia.Estados.NOASISTIO);
		this.setUsuario(new Usuario());
		this.setObra(new Obra());
	}

	public Asistencia(Usuario usuario, Obra obra) {
		UUID uuid = UUID.randomUUID();
		this.setQrcode(uuid.toString());
		this.setEstado(Asistencia.Estados.ACTIVA);
		this.setUsuario(usuario);
		this.setObra(obra);
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

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
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

}
