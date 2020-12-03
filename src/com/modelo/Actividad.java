package com.modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.helpers.GenericHelper;
import com.helpers.LocalDateTimeToStringConverter;
import com.helpers.StringToLocalDateTimeConverter;

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
    @Size(max = 150, message = "descripcion debe tener como máximo 150 caracteres")
	private String descripcion = "";
    @Column(name = "desde", nullable = false)
    @JsonSerialize(converter = LocalDateTimeToStringConverter.class)
    @JsonDeserialize(converter = StringToLocalDateTimeConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = GenericHelper.LOCALDATETIME_FORMAT)
	private LocalDateTime desde;
    @Column(name = "hasta", nullable = false)
    @JsonSerialize(converter = LocalDateTimeToStringConverter.class)
    @JsonDeserialize(converter = StringToLocalDateTimeConverter.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = GenericHelper.LOCALDATETIME_FORMAT)
	private LocalDateTime hasta;
    @Column(name = "desde_date", nullable = false)
	@JsonIgnore
	private Timestamp desdeDate;
    @Column(name = "hasta_date", nullable = false)
	@JsonIgnore
	private Timestamp hastaDate;
	@Basic
    @Min(value = 0, message = "Entradas debe ser mayor o igual que 0")
    @Column(name = "entradas_vendidas")
	private int entradasVendidas = 0;
	@OneToOne(
			optional = true,
			cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE}
	)
	private Obra obra = null;
	@ManyToOne(optional = false)
	@JoinColumn(name="espacio")
	private Espacio espacio;
	@ManyToOne(optional = false)
	@JoinColumn(name="edicion")
	private Edicion edicion;
	@OneToMany(
			mappedBy="actividad",
			cascade={CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE}
	)
	@JsonIgnore
    private Set<Asistencia> asistencias = new HashSet<Asistencia>();

	public Actividad() {
		this.setNombre("nombre");
	}

	public Actividad(String nombre, String descripcion, LocalDateTime desde, LocalDateTime hasta) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setDesde(desde);
		this.setHasta(hasta);
	}

	public Actividad(String nombre, String descripcion, LocalDateTime desde, LocalDateTime hasta, Espacio espacio) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setDesde(desde);
		this.setHasta(hasta);
		this.setEspacio(espacio);
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

	public Long getObraId() {
		return obra!=null ? obra.getId() : null;
	}

	@JsonIgnore
	public Obra getObra() {
		return obra;
	}

	@JsonProperty
	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public Long getEspacioId() {
		return espacio!=null ? espacio.getId() : null;
	}

	@JsonIgnore
	public Espacio getEspacio() {
		return espacio;
	}

	@JsonProperty
	public void setEspacio(Espacio espacio) {
		this.espacio = espacio;
	}

	public LocalDateTime getDesde() {
		return desde;
	}

	public void setDesde(LocalDateTime desde) {
		this.desde = desde;
		Timestamp ts = Timestamp.valueOf(desde);
		this.desdeDate = ts;
	}

	public LocalDateTime getHasta() {
		return hasta;
	}

	public void setHasta(LocalDateTime hasta) {
		this.hasta = hasta;
		Timestamp ts = Timestamp.valueOf(hasta);
		this.hastaDate = ts;
	}

	@JsonIgnore
	public Timestamp getDesdeDate() {
		return desdeDate;
	}

	@JsonIgnore
	public Timestamp getHastaDate() {
		return hastaDate;
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

	public int getEntradasVendidas() {
		return entradasVendidas;
	}

	public void setEntradasVendidas(int entradasVendidas) {
		this.entradasVendidas = entradasVendidas;
	}

	public Set<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(Set<Asistencia> asistencias) {
		this.asistencias = asistencias;
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
		Actividad other = (Actividad) obj;
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
