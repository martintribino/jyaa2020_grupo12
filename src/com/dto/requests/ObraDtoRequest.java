package com.dto.requests;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.Size;

import com.modelo.Actividad;
import com.modelo.Artista;
import com.modelo.Etiqueta;
import com.modelo.Usuario;

public class ObraDtoRequest {

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
	private Set<Artista> artistas = new HashSet<Artista>();
	private Set<String> fotos = new HashSet<String>();
    Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();
	private Actividad actividad;
	private Set<Usuario> usuariosFav = new HashSet<Usuario>();

	public ObraDtoRequest() {
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
		return artistas;
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

	public Set<Usuario> getUsuariosFav() {
		return usuariosFav;
	}

	public void setUsuariosFav(Set<Usuario> usuariosFav) {
		this.usuariosFav = usuariosFav;
	}
}
