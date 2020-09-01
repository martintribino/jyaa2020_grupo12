package com.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Size(min = 1, max = 150, message = "nombre debe tener entre 1 y 150 caracteres")
	@Column(name="nombre", unique=true, updatable= true)
	private String nombre;
	@JsonIgnore
    @ManyToMany(mappedBy = "etiquetas")
    private Set<Artista> artistas = new HashSet<Artista>();
	@JsonIgnore
    @ManyToMany(mappedBy = "etiquetas")
    private Set<Espacio> espacios = new HashSet<Espacio>();
	@JsonIgnore
    @ManyToMany(mappedBy = "etiquetas")
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

	public void addArtista(Artista artista) {
		if(!this.artistas.contains(artista)) {
			this.artistas.add(artista);
			artista.addEtiqueta(this);
		}
	}

	public void removeArtista(Artista artista) {
		if(this.artistas.contains(artista)) {
			this.artistas.remove(artista);
			artista.removeEtiqueta(this);
		}
	}

	public void addObra(Obra obra) {
		if(!this.obras.contains(obra)) {
			this.obras.add(obra);
			obra.addEtiqueta(this);
		}
	}

	public void removeObra(Obra obra) {
		if(this.obras.contains(obra)) {
			this.obras.remove(obra);
			obra.removeEtiqueta(this);
		}
	}

	public void addEspacio(Espacio espacio) {
		if(!this.espacios.contains(espacio)) {
			this.espacios.add(espacio);
			espacio.addEtiqueta(this);
		}
	}

	public void removeEspacio(Espacio espacio) {
		if(this.espacios.contains(espacio)) {
			this.espacios.remove(espacio);
			espacio.removeEtiqueta(this);
		}
	}

	public Set<Espacio> getEspacios() {
		return espacios;
	}

	public Set<Obra> getObras() {
		return obras;
	}

}
