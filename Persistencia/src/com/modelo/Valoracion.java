package com.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "valoracion")
public class Valoracion implements Serializable {

	/**
	 * Valoracion
	 */

	private static final long serialVersionUID = 7481157274087363378L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
    @Size(max = 150, message = "apellido debe tener como máximo 150 caracteres")
	private String descripcion = "";
	@Basic
    @Min(value = 1, message = "Puntaje debe ser mayor que 0")
    @Max(value = 100, message = "Puntaje no puede ser mayor que 100")
	private int puntaje = 70;
	@ManyToOne(optional = false)
	@JoinColumn(name="usuario_id", nullable = false)
	private Usuario usuario = new Usuario();
	@ManyToOne(optional = false)
	@JoinColumn(name="obra_id", nullable = false)
	private Obra obra = new Obra();

	public Valoracion() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
