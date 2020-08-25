package com.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "etiqueta")
public class Etiqueta implements Serializable {

	/**
	 * Etiqueta
	 */

	private static final long serialVersionUID = 5861168527529103681L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
	@Column(name="nombre", unique=true, updatable= true)
    @Size(min = 1, max = 150, message = "nombre debe tener entre 1 y 150 caracteres")
	private String nombre;
	@JsonIgnore
    @ManyToMany(
    		fetch = FetchType.LAZY,
    		mappedBy = "etiquetas",
    		cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
			targetEntity = Artista.class)
    private Set<Artista> artistas = new HashSet<Artista>();
	@JsonIgnore
    @ManyToMany(
    		fetch = FetchType.LAZY,
    		mappedBy = "etiquetas",
    		cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
			targetEntity = Espacio.class)
    private Set<Espacio> espacios = new HashSet<Espacio>();
	@JsonIgnore
    @ManyToMany(
    		fetch = FetchType.LAZY,
    		mappedBy = "etiquetas",
    		cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
			targetEntity = Obra.class)
    private Set<Obra> obras = new HashSet<Obra>();

	public Etiqueta() {
		this.setNombre("");
	}

	public Etiqueta(String nombre) {
		this.setNombre(nombre);
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

	public Set<Artista> getArtistas() {
		return artistas;
	}

	public Set<Espacio> getEspacios() {
		return espacios;
	}

	public Set<Obra> getObras() {
		return obras;
	}

}
