package com.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

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
	private int duracion = 60;
	@ManyToMany(
			fetch = FetchType.EAGER,
			cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			targetEntity = Artista.class)
    @JoinTable(
        name = "obra_artista", 
        joinColumns = { @JoinColumn(name = "obra_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "artista_id") },
        uniqueConstraints = {@UniqueConstraint(name = "obra_artista", columnNames={"obra_id", "artista_id"})})
	private Set<Artista> artistas = new HashSet<Artista>();
	@ElementCollection
	@CollectionTable(
        name = "obra_fotos",
        joinColumns=@JoinColumn(name = "id", referencedColumnName = "id")
    )
	private Set<String> fotos = new HashSet<String>();
    @ManyToMany(
    		fetch = FetchType.LAZY,
    		cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
			targetEntity = Etiqueta.class)
	@JoinTable(
        name = "obra_etiqueta", 
        joinColumns = { @JoinColumn(name = "obra_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "etiqueta_id") },
		uniqueConstraints = {@UniqueConstraint(name = "etiqueta_obra", columnNames={"etiqueta_id", "obra_id"})}
    )
    Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();
	@OneToOne(mappedBy="obra")
	private Actividad actividad;

	public Obra() {
		this.setNombre("nombre");
	}

	public Obra(String nombre, String descripcion, int duracion) {
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

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Set<Artista> getArtistas() {
		return new HashSet<Artista>(artistas);
	}

	public void setArtistas(Set<Artista> artistas) {
		this.artistas = artistas;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Set<String> getFotos() {
		return fotos;
	}

	public void setFotos(Set<String> fotos) {
		this.fotos = fotos;
	}

	public void addFoto(String foto) {
		this.fotos.add(foto);
	}

	public void removeFoto(String foto) {
		if(this.fotos.contains(foto))
			this.fotos.remove(foto);
	}

	public Set<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(Set<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

}
