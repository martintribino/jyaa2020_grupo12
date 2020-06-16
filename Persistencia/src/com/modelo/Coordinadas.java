package com.modelo;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "coordinadas",uniqueConstraints={@UniqueConstraint(columnNames={"longitud", "latitud"})})
public class Coordinadas {

	/**
	 * Coordinadas
	 */	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Basic
	private double longitud;
	@Basic
	private double latitud;

	public Coordinadas(){
	}

	public Long getId() {
		return id;
	}

	public Coordinadas(double lon, double lat){
		this.setLongitud(lon);
	    this.setLatitud(lat);;
	}

	public void setId(Long id) {
		this.id = id;
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
