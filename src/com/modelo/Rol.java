package com.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {

	/**
	 * Rol
	 */

	private static final long serialVersionUID = 8810171671349896834L;

	public static enum Tipos {
		ADMINISTRADOR, OPERADOR, PARTICIPANTE, VISITANTE,
	};

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Size(min = 2, max = 100, message = "nombre debe tener entre 2 y 100 caracteres")
	@Column(name="nombre", unique=true, updatable= true)
	private String nombre;
	@Column(name="tipo", unique=true, updatable= false)
    private Rol.Tipos tipo = Rol.Tipos.VISITANTE;
	@OneToMany(
		mappedBy="rol",
		cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
        orphanRemoval = false
    )
	@JsonIgnore
	private Set<Usuario> usuarios = new HashSet<Usuario>();

	public Rol() {
		this.setNombre("nombre");
	}

	public Rol(String nombre, Rol.Tipos tipo) {
		this.setNombre(nombre);
		this.setTipo(tipo);
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

	public Rol.Tipos getTipo() {
		return tipo;
	}

	public void setTipo(Rol.Tipos tipo) {
		this.tipo = tipo;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@JsonIgnore
	public Boolean esOperador() {
		return this.tipo.equals(Rol.Tipos.OPERADOR);
	}

	@JsonIgnore
	public Boolean esAdministrador() {
		return this.tipo.equals(Rol.Tipos.ADMINISTRADOR);
	}

	@JsonIgnore
	public Boolean esParticipante() {
		return this.tipo.equals(Rol.Tipos.PARTICIPANTE);
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
		Rol other = (Rol) obj;
		if (id == null) {
			if (other.id != null)
				return false;
			else if (!nombre.equals(other.nombre))
				return false;
			else if (!tipo.equals(other.tipo))
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
