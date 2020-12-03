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

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
        name = "artista_etiqueta", 
        joinColumns = { @JoinColumn(name = "artista_id", referencedColumnName = "id") }, 
        inverseJoinColumns = { @JoinColumn(name = "etiqueta_id", referencedColumnName = "id") }
    )
    @JsonIgnoreProperties(value="artistas")
    Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();
    @ManyToMany(mappedBy = "artistas")
    @JsonIgnore
	private Set<Obra> obras = new HashSet<Obra>();
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
        name = "usuario_artista_fav", 
        joinColumns = { @JoinColumn(name = "usuario_id", referencedColumnName = "id") }, 
        inverseJoinColumns = { @JoinColumn(name = "artista_id", referencedColumnName = "id") }
    )
    @JsonIgnoreProperties(value="artistasFav")
	private Set<Usuario> usuariosFav = new HashSet<Usuario>();

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
		this.obras.add(obra);
		obra.addArtista(this);
	}
	
	public void removeObra(Obra obra) {
		this.obras.remove(obra);
		obra.removeArtista(this);
	}

	public Set<Usuario> getUsuariosFav() {
		return usuariosFav;
	}

	public void setUsuariosFav(Set<Usuario> usuariosFav) {
		this.usuariosFav = usuariosFav;
	}

	public void addUsuarioFav(Usuario usuario) {
		if(!this.usuariosFav.contains(usuario)) {
			this.usuariosFav.add(usuario);
			usuario.addArtistaFav(this);
		}
	}
	
	public void removeUsuarioFav(Usuario usuario) {
		if(this.usuariosFav.contains(usuario)) {
			this.usuariosFav.remove(usuario);
			usuario.removeArtistaFav(this);
		}
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
		Artista other = (Artista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
			else if (!nombre.equals(other.nombre) || !apellido.equals(other.apellido) || !apodo.equals(other.apodo))
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
