package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {

	/**
	 * Rol
	 */

	private static final long serialVersionUID = 8810171671349896834L;

	public static enum Permisos {
		ALTA_ACTIVIDADES, BAJA_ACTIVIDADES, EDICION_ACTIVIDADES, LECTURA_ACTIVIDADES,
		ALTA_ARTISTAS, BAJA_ARTISTAS, EDICION_ARTISTAS, LECTURA_ARTISTAS,
		ALTA_ASISTENCIAS, BAJA_ASISTENCIAS, EDICION_ASISTENCIAS, LECTURA_ASISTENCIAS,
		ALTA_EDICIONES, BAJA_EDICIONES, EDICION_EDICIONES, LECTURA_EDICIONES,
		ALTA_ESPACIOS, BAJA_ESPACIOS, EDICION_ESPACIOS, LECTURA_ESPACIOS,
		ALTA_ETIQUETAS, BAJA_ETIQUETAS, EDICION_ETIQUETAS, LECTURA_ETIQUETAS,
		ALTA_INTERESES, BAJA_INTERESES, EDICION_INTERESES, LECTURA_INTERESES,
		ALTA_NOTIFICACIONES, BAJA_NOTIFICACIONES, EDICION_NOTIFICACIONES, LECTURA_NOTIFICACIONES,
		ALTA_OBRAS, BAJA_OBRAS, EDICION_OBRAS, LECTURA_OBRAS,
		ALTA_USUARIOS, BAJA_USUARIOS, EDICION_USUARIOS, LECTURA_USUARIOS,
		ALTA_VALORACIONES, BAJA_VALORACIONES, EDICION_VALORACIONES, LECTURA_VALORACIONES,
	};

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
    @Size(min = 2, max = 100, message = "nombre debe tener entre 2 y 100 caracteres")
	@Column(name="nombre", unique=true, updatable= true)
	private String nombre;
	@Basic
    @Size(max = 150, message = "descripcion debe tener como máximo 150 caracteres")
	private String descripción = "";
    @ElementCollection
    private Set<String> permisos = new HashSet<String>();

	public Rol() {
		this.setNombre("nombre");
	}

	public Rol(String nombre, String descripción) {
		this.setNombre(nombre);
		this.setDescripción(descripción);
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

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	public Boolean hasPermiso(String permiso) {
		return this.permisos.contains(permiso);
	}

	public Boolean addPermiso(String permiso) {
		return this.permisos.add(permiso);
	}

	public Boolean removePermiso(String permiso) {
		return this.permisos.remove(permiso);
	}

}
