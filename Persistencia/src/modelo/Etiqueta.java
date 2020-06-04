package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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
    @Size(min = 2, max = 100, message = "nombre debe tener entre 2 y 100 caracteres")
	private String nombre;
	@Basic
    @Size(max = 150, message = "descripcion debe tener como máximo 150 caracteres")
	private String descripcion = "";
    @ManyToMany(mappedBy = "etiquetas")
    private Set<Artista> artistas = new HashSet<Artista>();
    @ManyToMany(mappedBy = "etiquetas")
    private Set<Espacio> espacios = new HashSet<Espacio>();
    @ManyToMany(mappedBy = "etiquetas")
    private Set<Obra> obras = new HashSet<Obra>();

	public Etiqueta() {
		this.setNombre("nombre");
	}

	public Etiqueta(String nombre, String descripcion) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
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

	public Set<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(Set<Artista> artistas) {
		this.artistas = artistas;
	}

	public Set<Espacio> getEspacios() {
		return espacios;
	}

	public void setEspacios(Set<Espacio> espacios) {
		this.espacios = espacios;
	}

	public Set<Obra> getObras() {
		return obras;
	}

	public void setObras(Set<Obra> obras) {
		this.obras = obras;
	}

}
