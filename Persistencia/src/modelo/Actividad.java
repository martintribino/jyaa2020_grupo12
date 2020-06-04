package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import helpers.GenericHelper;
import helpers.LocalDateTimeToStringConverter;
import helpers.StringToLocalDateTimeConverter;

@Entity
@Table(name = "actividad")
public class Actividad implements Serializable {

	/**
	 * Actividad
	 */

	private static final long serialVersionUID = -1767958037215573700L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
    @Size(min = 2, max = 100, message = "nombre debe tener entre 2 y 100 caracteres")
	private String nombre;
	@Basic
    @Size(max = 150, message = "apellido debe tener como máximo 150 caracteres")
	private String descripcion;
	@Basic
    @Column(name = "desde", nullable = false)
    @JsonSerialize(converter = LocalDateTimeToStringConverter.class)
    @JsonDeserialize(converter = StringToLocalDateTimeConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = GenericHelper.LOCALDATETIME_FORMAT)
	private LocalDateTime desde;
	@Basic
    @Column(name = "hasta", nullable = false)
    @JsonSerialize(converter = LocalDateTimeToStringConverter.class)
    @JsonDeserialize(converter = StringToLocalDateTimeConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = GenericHelper.LOCALDATETIME_FORMAT)
	private LocalDateTime hasta;
	@OneToOne(
			optional = true,
			fetch = FetchType.EAGER,
			cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH},
			orphanRemoval = false
	)
	private Obra obra;
	@OneToOne(
			optional = false,
			fetch = FetchType.EAGER,
			cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
			orphanRemoval = false
	)
	private Espacio espacio;
	@ManyToOne(
			optional = true
	)
	private Edicion edicion;

	public Actividad() {
		this.setNombre("nombre");
		this.setDescripcion("");
		this.setDesde(LocalDateTime.now());
		this.setHasta(LocalDateTime.now());
		this.setObra(null);
		this.setEspacio(new Espacio());
	}

	public Actividad(String nombre, String descripcion, LocalDateTime desde, LocalDateTime hasta) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setDesde(LocalDateTime.now());
		this.setHasta(LocalDateTime.now());
		this.setObra(null);
		this.setEspacio(new Espacio());
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

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public Espacio getEspacio() {
		return espacio;
	}

	public void setEspacio(Espacio espacio) {
		this.espacio = espacio;
	}

	public LocalDateTime getDesde() {
		return desde;
	}

	public void setDesde(LocalDateTime desde) {
		this.desde = desde;
	}

	public LocalDateTime getHasta() {
		return hasta;
	}

	public void setHasta(LocalDateTime hasta) {
		this.hasta = hasta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Edicion getEdicion() {
		return edicion;
	}

	public void setEdicion(Edicion edicion) {
		this.edicion = edicion;
	}

}
