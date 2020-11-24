package com.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "notificacion")
public class Notificacion implements Serializable {

	/**
	 * Notificacion
	 */

	private static final long serialVersionUID = 8326691181072321783L;

	public static enum Estados {
		NOLEIDA,
		LEIDA,
		ELIMINADA,
	};

	public static enum Tipos {
		URGENTE,
		CUSTOM,
		INFO,
	};

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
    @Size(min = 2, max = 100, message = "nombre debe tener entre 2 y 100 caracteres")
	private String nombre;
	@Basic
	private Notificacion.Tipos tipo = Notificacion.Tipos.INFO;
	@Basic
	private Notificacion.Estados estado = Notificacion.Estados.NOLEIDA;
	@OneToOne(
			optional = true,
			fetch = FetchType.EAGER,
			cascade = {CascadeType.REFRESH, CascadeType.MERGE},
			orphanRemoval = false
	)
	@JsonIgnore
	private Actividad actividad;
    @ManyToMany(mappedBy = "notificaciones")
	@JsonIgnore
	private Set<Usuario> usuarios = new HashSet<Usuario>();

	public Notificacion() {
		this.setNombre("nombre");
	}

	public Notificacion(
			String nombre,
			Notificacion.Tipos tipo,
			Notificacion.Estados estado
		) {
		this.setNombre(nombre);
		this.setTipo(tipo);
		this.setEstado(estado);
	}

	public Notificacion(
			String nombre,
			Notificacion.Tipos tipo,
			Notificacion.Estados estado,
			Actividad actividad
		) {
		this.setNombre(nombre);
		this.setTipo(tipo);
		this.setEstado(estado);
		this.setActividad(actividad);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Notificacion.Tipos getTipo() {
		return tipo;
	}

	public void setTipo(Notificacion.Tipos tipo) {
		this.tipo = tipo;
	}

	public Notificacion.Estados getEstado() {
		return estado;
	}

	public void setEstado(Notificacion.Estados estado) {
		this.estado = estado;
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
		Notificacion other = (Notificacion) obj;
		if (id == null) {
			return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
