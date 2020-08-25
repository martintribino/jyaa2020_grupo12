package com.dto.responses;

import com.modelo.Direccion;
import com.modelo.Rol;

public class PerfilDTOResponse {

	private Long id;
	private String nombreUsuario;
	private String nombre;
	private String apellido;
	private Rol rol;
	private Direccion direccion;

	public PerfilDTOResponse() {
		this.id = null;
		this.nombreUsuario = "";
		this.rol = null;
	}
	
	public PerfilDTOResponse(Long id, String nombre, Rol rol) {
		this.setId(id);;
		this.setNombreUsuario(nombre);
		this.setRol(rol);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

}
