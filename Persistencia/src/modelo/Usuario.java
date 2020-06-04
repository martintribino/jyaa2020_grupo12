package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * Usuario
	 */

	private static final long serialVersionUID = -8444347371961860710L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="nombre_usuario", unique=true, updatable= true)
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
	@Column(name="email", unique=true, updatable= true)
	@NotBlank(message = "Por favor proporcione un email")
	private String email;
	@Basic
	private int telefono;
	@OneToOne(
			optional = false,
			fetch = FetchType.EAGER,
			cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
			orphanRemoval = true
	)
	private Rol rol;
	@OneToMany(
			cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
			orphanRemoval = false
	)
	@JsonIgnore
	private List<Artista> artistasFav = new ArrayList<Artista>();
	@OneToMany(
			cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
			orphanRemoval = false
	)
	@JsonIgnore
	private List<Obra> obrasFav = new ArrayList<Obra>();
	@OneToMany(
			cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
			orphanRemoval = false
	)
	@JsonIgnore
	private List<Etiqueta> etiquetasFav = new ArrayList<Etiqueta>();
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Usuario_Notificacion", 
        joinColumns = { @JoinColumn(name = "usuario_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "notificacion_id") }
    )
	private Set<Notificacion> notificaciones = new HashSet<Notificacion>();
	@OneToMany(mappedBy="usuario",
			cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
			orphanRemoval = false
	)
	@JsonIgnore
	private List<Valoracion> valoraciones = new ArrayList<Valoracion>();

	public Usuario() {
		this.setNombre("nombre");
		this.setApellido("apellido");
	}

	public Usuario(String nombreUsuario, String clave, String nombre, String apellido, int dni, int telefono, String email, Rol rol) {
		this.setNombreUsuario(nombreUsuario);
		this.setClave(clave);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setRol(rol);
		this.setEmail(email);
		this.setDni(dni);
		this.setTelefono(telefono);
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Set<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(Set<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public List<Artista> getArtistasFav() {
		return artistasFav;
	}

	public void setArtistasFav(List<Artista> artistasFav) {
		this.artistasFav = artistasFav;
	}

	public List<Obra> getObrasFav() {
		return obrasFav;
	}

	public void setObrasFav(List<Obra> obrasFav) {
		this.obrasFav = obrasFav;
	}

	public List<Etiqueta> getEtiquetasFav() {
		return etiquetasFav;
	}

	public void setEtiquetasFav(List<Etiqueta> etiquetasFav) {
		this.etiquetasFav = etiquetasFav;
	}

	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}

}
