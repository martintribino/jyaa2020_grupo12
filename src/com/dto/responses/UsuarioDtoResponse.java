package com.dto.responses;

import com.modelo.Rol;

public class UsuarioDtoResponse {

	private String nombreUsuario;
	private String token;
	private Rol.Tipos rol;

	public UsuarioDtoResponse() {
		this.nombreUsuario = "";
		this.token = "";
		this.rol = Rol.Tipos.VISITANTE;
	}
	
	public UsuarioDtoResponse(String nombre, String token, Rol.Tipos rol) {
		this.setNombreUsuario(nombre);
		this.setToken(token);
		this.setRol(rol);
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Rol.Tipos getRol() {
		return rol;
	}

	public void setRol(Rol.Tipos rol) {
		this.rol = rol;
	}

}
