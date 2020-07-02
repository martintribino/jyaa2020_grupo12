package com.modelo;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "direccion")
public class Direccion {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
    @Basic
    private String calle = "";
    @Basic
    private String ciudad = "";
    @Basic
    private String estado = "";
    @Basic
	@Column(name="cp")
    private Integer codigoPostal;
	@OneToOne(
			optional = true,
			cascade = {CascadeType.ALL},
			orphanRemoval = true
	)
    Coordinadas coordinadas = null;

	public Direccion() {
	}

	public Direccion(String calle, String ciudad, String estado, Integer codigoPostal) {
		this.setCalle(calle);
		this.setCiudad(ciudad);
		this.setEstado(estado);
		this.setCodigoPostal(codigoPostal);
	}

	public Direccion(String calle, String ciudad, String estado, Integer codigoPostal, Coordinadas coord) {
		this.setCalle(calle);
		this.setCiudad(ciudad);
		this.setEstado(estado);
		this.setCodigoPostal(codigoPostal);
		this.setCoordinadas(coord);
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

	public Coordinadas getCoordinadas() {
		return coordinadas;
	}

	public void setCoordinadas(Coordinadas coordinadas) {
		this.coordinadas = coordinadas;
	}

}
