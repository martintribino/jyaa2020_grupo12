package com.dto.requests;

import javax.persistence.Basic;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.modelo.Rol;

public class UsuarioPutDtoRequest {

    @Size(min = 4, max = 50, message = "nombre debe tener entre 4 y 50 caracteres")
	private String nombreUsuario;
	@Basic
    @Size(min = 4, max = 150, message = "clave debe tener entre 4 y 150 caracteres")
	private String clave;
	@Basic
    @Size(min = 2, max = 100, message = "nombre debe tener entre 2 y 100 caracteres")
	private String nombre;
	@Basic
    @Size(min = 2, max = 100, message = "apellido debe tener entre 2 y 100 caracteres")
	private String apellido;
	@Basic
    @Min(value = 1, message = "Dni debe ser mayor que 0")
    @Max(value = 99999999, message = "Dni no puede ser mayor a 99999999")
	private int dni;
	@Basic
    @Email(message = "El mail debe ser válido")
	@NotBlank(message = "Por favor proporcione un email")
	private String email;
	@Basic
	private int telefono;
    private Rol.Tipos rol = null;

	public UsuarioPutDtoRequest() {
		// TODO Auto-generated constructor stub
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public Rol.Tipos getRol() {
		return rol;
	}
	public void setRol(Rol.Tipos rol) {
		this.rol = rol;
	}

}
