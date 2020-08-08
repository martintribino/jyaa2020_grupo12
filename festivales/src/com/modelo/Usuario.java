package com.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.security.Encrypt;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * Usuario
	 */

	private static final long serialVersionUID = -8444347371961860710L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	@Column(name="nombre_usuario", unique=true, updatable= true)
    @Size(min = 4, max = 50, message = "nombre debe tener entre 4 y 50 caracteres")
	private String nombreUsuario;
	@Basic
    @Size(min = 4, max = 150, message = "clave debe tener entre 4 y 150 caracteres")
    @JsonProperty(access = Access.WRITE_ONLY)
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
	@Column(name="email", unique=true, updatable= true)
	@NotBlank(message = "Por favor proporcione un email")
	private String email;
	@Basic
	private int telefono;
	@ManyToOne(
			fetch=FetchType.EAGER,
			cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}
	)
    private Rol rol = null;
	@ManyToOne(
			fetch=FetchType.EAGER,
			cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}
	)
    private Direccion direccion = null;
	@OneToMany(
			cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
			orphanRemoval = false
	)
	@JsonIgnore
	private Set<Artista> artistasFav = new HashSet<Artista>();
	@OneToMany(
			cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
			orphanRemoval = false
	)
	@JsonIgnore
	private Set<Obra> obrasFav = new HashSet<Obra>();
	@OneToMany(
			cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
			orphanRemoval = false
	)
	@JsonIgnore
	private Set<Etiqueta> etiquetasFav = new HashSet<Etiqueta>();
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "usuario_notificacion", 
        joinColumns = { @JoinColumn(name = "usuario_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "notificacion_id") }
    )
	private Set<Notificacion> notificaciones = new HashSet<Notificacion>();

	public Usuario() {
		this.setNombre("nombre");
		this.setApellido("apellido");
	}

	public Usuario(String nombreUsuario, String clave, String nombre, String apellido, int dni, int telefono,
					String email) {
		this.setNombreUsuario(nombreUsuario);
		this.setClave(clave);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEmail(email);
		this.setDni(dni);
		this.setTelefono(telefono);
	}

	public Usuario(String nombreUsuario, String clave, String nombre, String apellido, int dni, int telefono,
					String email, Rol rol) {
		this.setNombreUsuario(nombreUsuario);
		this.setClave(clave);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setRol(rol);
		this.setEmail(email);
		this.setDni(dni);
		this.setTelefono(telefono);
	}

	public Usuario(String nombreUsuario, String clave, String nombre, String apellido, int dni, int telefono,
					String email, Rol rol, Direccion direccion) {
		this.setNombreUsuario(nombreUsuario);
		this.setClave(clave);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setRol(rol);
		this.setEmail(email);
		this.setDni(dni);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
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

	public Set<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(Set<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public Set<Artista> getArtistasFav() {
		return artistasFav;
	}

	public void setArtistasFav(Set<Artista> artistasFav) {
		this.artistasFav = artistasFav;
	}

	public void addArtistaFav(Artista artista) {
		this.getArtistasFav().add(artista);
	}

	public Set<Obra> getObrasFav() {
		return obrasFav;
	}

	public void setObrasFav(Set<Obra> obrasFav) {
		this.obrasFav = obrasFav;
	}

	public void addObraFav(Obra obra) {
		this.getObrasFav().add(obra);
	}

	public Set<Etiqueta> getEtiquetasFav() {
		return etiquetasFav;
	}

	public void setEtiquetasFav(Set<Etiqueta> etiquetasFav) {
		this.etiquetasFav = etiquetasFav;
	}

	public void addEtiquetaFav(Etiqueta etiqueta) {
		this.getEtiquetasFav().add(etiqueta);
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Boolean verificarClave(String clave) {
		return Encrypt.matches(clave, this.getClave());
	}
	
	public Boolean esAdministrador() {
		return (this.getRol() != null && this.getRol().esAdministrador() );
	}

}
