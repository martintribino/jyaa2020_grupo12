package com.modelo;

import java.io.Serializable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "obra")
public class Obra implements Serializable {

	/**
	 * Obra
	 */

	private static final long serialVersionUID = -9156958770056784294L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
    @Size(min = 2, max = 100, message = "nombre debe tener entre 2 y 100 caracteres")
	private String nombre;
	@Basic
    @Size(max = 150, message = "descripcion debe tener como máximo 150 caracteres")
	private String descripcion = "";
	@Basic
    @Column(name = "duracion", nullable = false)
	private Duration duracion = Duration.ofMinutes(60);
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
    @JoinTable(
        name = "obra_artista", 
        joinColumns = { @JoinColumn(name = "obra_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "artista_id") }
    )
	private Set<Artista> artistas = new HashSet<Artista>();
	@JsonIgnore
	@ElementCollection
	@CollectionTable(
        name = "obra_fotos",
        joinColumns=@JoinColumn(name = "id", referencedColumnName = "id")
    )
	private Set<String> fotos = new HashSet<String>();
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
    @JoinTable(
        name = "obra_etiqueta", 
        joinColumns = { @JoinColumn(name = "obra_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "etiqueta_id") }
    )
    Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();
	@OneToMany(mappedBy="usuario",
			cascade={CascadeType.ALL},
			orphanRemoval = true
	)
	@JsonIgnore
	private List<Valoracion> valoraciones = new ArrayList<Valoracion>();

	public Obra() {
		this.setNombre("nombre");
	}

	public Obra(String nombre, String descripcion, Duration duracion) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setDuracion(duracion);
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Duration getDuracion() {
		return duracion;
	}

	public void setDuracion(Duration duracion) {
		this.duracion = duracion;
	}

	public Set<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(Set<Artista> artistas) {
		this.artistas = artistas;
	}

	public Set<String> getFotos() {
		return fotos;
	}

	public void setFotos(Set<String> fotos) {
		this.fotos = fotos;
	}

	public Set<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(Set<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

}
