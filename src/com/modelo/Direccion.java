package com.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "direccion", uniqueConstraints={@UniqueConstraint(name = "latitud_longitud", columnNames={"longitud", "latitud"})})
public class Direccion implements Serializable {

	/**
	 * Direccion
	 */
	private static final long serialVersionUID = -5081842452260474805L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Basic
    @Size(max = 100, message = "nombre debe tener entre menos de 100 caracteres")
    private String calle = "";
    @Basic
    @Size(max = 100, message = "ciudad debe tener entre menos de 100 caracteres")
    private String ciudad = "";
    @Basic
    @Size(max = 100, message = "estado debe tener entre menos de 100 caracteres")
    private String estado = "";
    @Basic
	@Column(name="cp")
    @Min(value = 1, message = "cp debe ser mayor que 0")
    @Max(value = 99999999, message = "cp no puede ser mayor a 99999999")
    private Integer codigoPostal;
	@Basic
	private double longitud;
	@Basic
	private double latitud;
	@OneToOne(mappedBy="direccion")
	private Espacio espacio;

	public Direccion() {
	}

	public Direccion(String calle, String ciudad, String estado, Integer codigoPostal, double longitud, double latitud) {
		this.setCalle(calle);
		this.setCiudad(ciudad);
		this.setEstado(estado);
		this.setCodigoPostal(codigoPostal);
		this.setLatitud(latitud);
		this.setLongitud(longitud);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

}
