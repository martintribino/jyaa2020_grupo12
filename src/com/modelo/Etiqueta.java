package com.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @ManyToMany(mappedBy = "etiquetas")
	@JsonIgnore
    private Set<Artista> artistas = new HashSet<Artista>();
	@JsonIgnore
    @ManyToMany(mappedBy = "etiquetas")
    private Set<Espacio> espacios = new HashSet<Espacio>();
	@JsonIgnore
    @ManyToMany(mappedBy = "etiquetas")
    private Set<Obra> obras = new HashSet<Obra>();
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
        name = "etiqueta_usuario_fav", 
        joinColumns = { @JoinColumn(name = "etiqueta_id", referencedColumnName = "id") }, 
        inverseJoinColumns = { @JoinColumn(name = "usuario_id", referencedColumnName = "id") }
    )
    @JsonIgnoreProperties(value="etiquetasFav")
	private Set<Usuario> usuariosFav = new HashSet<Usuario>();

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

	public void setArtistas(Set<Artista> artistas) {
		this.artistas = artistas;
	}

	public Set<Espacio> getEspacios() {
		return espacios;
	}

	public Set<Obra> getObras() {
		return obras;
	}

	public void setEspacios(Set<Espacio> espacios) {
		this.espacios = espacios;
	}

	public void setObras(Set<Obra> obras) {
		this.obras = obras;
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

   public void addUsuarioFav(Usuario usuario) {
       if(!this.getUsuariosFav().contains(usuario)) {
           this.getUsuariosFav().add(usuario);
           usuario.addEtiquetaFav(this);
       }
	}

	public void removeUsuarioFav(Usuario usuario) {
	   if(this.getUsuariosFav().contains(usuario)) {
           this.getUsuariosFav().remove(usuario);
           usuario.removeEtiquetaFav(this);
       }
	}

	public Set<Usuario> getUsuariosFav() {
		return usuariosFav;
	}
	
	public void setUsuariosFav(Set<Usuario> usuariosFav) {
		this.usuariosFav = usuariosFav;
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
		Etiqueta other = (Etiqueta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
			else if (!nombre.equals(other.nombre))
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
