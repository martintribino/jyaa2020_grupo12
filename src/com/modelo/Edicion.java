package com.modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.helpers.GenericHelper;
import com.helpers.LocalDateTimeToStringConverter;
import com.helpers.StringToLocalDateTimeConverter;

@Entity
@Table(name = "edicion")
public class Edicion implements Serializable {

	/**
	 * Edicion
	 */

	private static final long serialVersionUID = 4792793260099004360L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
    @Column(name = "nombre", unique= true, updatable= true)
    @Size(min = 2, max = 100, message = "nombre debe tener entre 2 y 100 caracteres")
	private String nombre;
	@Basic
    @Size(max = 150, message = "descripcion debe tener como máximo 150 caracteres")
	private String descripcion;
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
	@OneToMany(
			mappedBy="edicion",
			cascade={CascadeType.ALL},
			orphanRemoval = true
	)
	@JsonIgnore
	private Set<Actividad> actividades = new HashSet<Actividad>();
	@ElementCollection
	@CollectionTable(
        name = "edicion_fotos",
        joinColumns=@JoinColumn(name = "id", referencedColumnName = "id")
    )
	private Set<String> fotos = new HashSet<String>();

	public Edicion() {
		this.setNombre("nombre");
		this.setDescripcion("");
		this.setDesde(LocalDateTime.now());
		this.setHasta(LocalDateTime.now());
	}

	public Edicion(String nombre, String descripcion, LocalDateTime desde, LocalDateTime hasta) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setDesde(desde);
		this.setHasta(hasta);
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

	public Set<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(Set<Actividad> actividades) {
		this.actividades = actividades;
	}

	public Timestamp getDesdeDate() {
		return desdeDate;
	}

	public void setDesdeDate(Timestamp desdeDate) {
		this.desdeDate = desdeDate;
	}

	@JsonIgnore
	public Timestamp getHastaDate() {
		return hastaDate;
	}

	@JsonIgnore
	public void setHastaDate(Timestamp hastaDate) {
		this.hastaDate = hastaDate;
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
		Edicion other = (Edicion) obj;
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
