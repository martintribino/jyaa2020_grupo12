package com.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "artista")
public class Artista implements Serializable {

	/**
	 * Artista
	 */

	private static final long serialVersionUID = -6776675650555567966L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
    @Size(min = 2, max = 100, message = "nombre debe tener entre 2 y 100 caracteres")
	private String nombre;
	@Basic
    @Size(min = 2, max = 100, message = "apellido debe tener entre 2 y 100 caracteres")
	private String apellido;
	@Basic
    @Size(min = 2, max = 50, message = "apodo debe tener entre 2 y 50 caracteres")
	private String apodo;
	@ElementCollection
	@CollectionTable(
        name = "artista_fotos",
        joinColumns=@JoinColumn(name = "id", referencedColumnName = "id")
    )
	private Set<String> fotos = new HashSet<String>();
    @ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
        name = "artista_etiqueta", 
        joinColumns = { @JoinColumn(name = "artista_id", referencedColumnName = "id") }, 
        inverseJoinColumns = { @JoinColumn(name = "etiqueta_id", referencedColumnName = "id") }
    )
    Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();
	//@JsonIgnore
    @ManyToMany(mappedBy = "artistas")
    @JsonIgnoreProperties(value="artistas")
	private Set<Obra> obras = new HashSet<Obra>();

	public Artista() {
		this.setNombre("nombre");
		this.setApellido("apellido");
		this.setApodo("apodo");
	}

	public Artista(String nombre, String apellido, String apodo) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setApodo(apodo);
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
        this.apellido = apellido;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
        this.apodo = apodo;
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

	public void addEtiqueta(Etiqueta etiqueta) {
		if(!this.etiquetas.contains(etiqueta)) {
			this.etiquetas.add(etiqueta);
			etiqueta.addArtista(this);
		}
	}

	public void removeEtiqueta(Etiqueta etiqueta) {
		if(this.etiquetas.contains(etiqueta)) {
			this.etiquetas.remove(etiqueta);
			etiqueta.removeArtista(this);
		}
	}

	public Set<Obra> getObras() {
		return obras;
	}

	public void setObras(Set<Obra> obras) {
		this.obras = obras;
	}

	public void addObra(Obra obra) {
		if(!this.obras.contains(obra)) {
			this.obras.add(obra);
			obra.addArtista(this);
		}
	}
	
	public void removeObra(Obra obra) {
		if(this.obras.contains(obra)) {
			this.obras.remove(obra);
			obra.removeArtista(this);
		}
	}

}
