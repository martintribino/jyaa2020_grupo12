package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "espacio")
public class Espacio implements Serializable {

	/**
	 * Espacio
	 */

	private static final long serialVersionUID = -6098904203104537407L;

	public static enum Estados {
		ABIERTO,
		CERRADO,
	};

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
    @Size(min = 2, max = 100, message = "nombre debe tener entre 2 y 100 caracteres")
	private String nombre;
	@Basic
    @Size(max = 100, message = "descripcion debe tener como máximo 150 caracteres")
	private String descripcion = "";
	@Basic
    @Min(value = 0, message = "Capacidad debe ser mayor que 0")
	private int capacidad = 0;
	@Basic
	private Espacio.Estados condicion = Espacio.Estados.ABIERTO;
	@OneToOne(
			optional = false,
			fetch = FetchType.EAGER,
			cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
			orphanRemoval = false
	)
    private Direccion direccion = new Direccion();
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
    @JoinTable(
        name = "espacio_etiqueta", 
        joinColumns = { @JoinColumn(name = "espacio_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "etiqueta_id") }
    )
    Set<Etiqueta> etiquetas = new HashSet<Etiqueta>();

	public Espacio() {
		this.setNombre("nombre");
	}

	public Espacio(String nombre, String descripcion, int capacidad, Espacio.Estados condicion,
					Direccion direccion) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setCapacidad(capacidad);
		this.setCondicion(condicion);
		this.setDireccion(direccion);
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

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Espacio.Estados getCondicion() {
		return condicion;
	}

	public void setCondicion(Espacio.Estados condicion) {
		this.condicion = condicion;
	}

	public Set<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(Set<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

}
