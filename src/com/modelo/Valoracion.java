package com.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "valoracion",uniqueConstraints={@UniqueConstraint(name = "usuario_obra", columnNames={"usuario_id", "obra_id"})})
public class Valoracion implements Serializable {

	/**
	 * Valoracion
	 */

	private static final long serialVersionUID = 7481157274087363378L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
    @Min(value = 0, message = "Puntaje debe ser mayor o igual que 0")
    @Max(value = 10, message = "Puntaje no puede ser mayor que 10")
	private int puntaje = 7;
	@OneToOne(
			optional = false,
			fetch = FetchType.EAGER,
			cascade = {CascadeType.REFRESH},
			orphanRemoval = true
	)
	@JsonIgnore
	@JoinColumn(name="usuario_id", nullable = false)
	private Usuario usuario = new Usuario();
	@OneToOne(
			optional = false,
			fetch = FetchType.EAGER,
			cascade = {CascadeType.REFRESH},
			orphanRemoval = true
	)
	@JsonIgnore
	@JoinColumn(name="obra_id", nullable = false)
	private Obra obra = new Obra();

	public Valoracion() {
	}

	public Valoracion(int puntaje, Usuario usuario, Obra obra) {
		this.setPuntaje(puntaje);
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

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
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
		Valoracion other = (Valoracion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
			else if (!usuario.getId().equals(other.getUsuario().getId()) ||
					!obra.getId().equals(other.getObra().getId()))
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
