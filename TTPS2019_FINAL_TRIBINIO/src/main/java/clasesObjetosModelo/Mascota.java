package clasesObjetosModelo;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Mascota {

	/**
	 * Clase Mascota
	 */
	
	private String nombre;
	private Date fechaNacimiento;
	private String especie;
	private String raza;
	private String sexo;
	private String color;
	private String senias;
	private URL imagen;
	private Duenio duenio;
	private Veterinario veterinario;
	private PermisoFichaPublica ficha;
	private List<Evento> eventos;
	private EstadoSolicitud solicitud;

	public  Mascota() {
		this.setNombre("");
		this.setFechaNacimiento(Calendar.getInstance().getTime());
		this.setEspecie("");
		this.setRaza("");
		this.setSenias("");
		this.setColor("");
		this.setSexo("");
		this.setImagen(null);
		this.setDuenio(null);
		this.setVeterinario(null);
		this.setSolicitud(null);
		this.setFicha(new PermisoFichaPublica());
		this.setEventos(new ArrayList<Evento>());
	}

	public  Mascota(
			String nombre,
			Date fechaNacimiento,
			String especie,
			String raza,
			String sexo,
			String color,
			String senias,
			URL imagen,
			Duenio duenio,
			Veterinario veterinario,
			PermisoFichaPublica ficha,
			EstadoSolicitud solicitud) {
		this.setNombre(nombre);
		this.setFechaNacimiento(fechaNacimiento);
		this.setEspecie(especie);
		this.setRaza(raza);
		this.setSenias(senias);
		this.setColor(color);
		this.setSexo(sexo);
		this.setImagen(imagen);
		this.setDuenio(duenio);
		this.setVeterinario(veterinario);
		this.setFicha(ficha);
		this.setSolicitud(solicitud);
		this.setEventos(new ArrayList<Evento>());
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSenias() {
		return senias;
	}
	public void setSenias(String senias) {
		this.senias = senias;
	}
	public URL getImagen() {
		return imagen;
	}
	public void setImagen(URL imagen) {
		this.imagen = imagen;
	}

	public Duenio getDuenio() {
		return duenio;
	}

	public void setDuenio(Duenio duenio) {
		this.duenio = duenio;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public PermisoFichaPublica getFicha() {
		return ficha;
	}

	public void setFicha(PermisoFichaPublica ficha) {
		this.ficha = ficha;
	}

	public EstadoSolicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(EstadoSolicitud solicitud) {
		this.solicitud = solicitud;
	}

}
