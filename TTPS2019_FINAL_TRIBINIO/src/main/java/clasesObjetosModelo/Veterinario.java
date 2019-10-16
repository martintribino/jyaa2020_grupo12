package clasesObjetosModelo;

import java.util.ArrayList;
import java.util.List;

public class Veterinario extends Persona {

	/**
	 * Clase Veterinario
	 */
	private static final long serialVersionUID = 1L;

	private String nombreClinica;
	private String domicilioClinica;
	private Boolean validado;
	private List<Mascota> mascotas;
	private List<EstadoSolicitud> solicitudes;
	private List<Evento> eventos;
	
	public Veterinario() {
		super();
		this.setNombreClinica("");
		this.setDomicilioClinica("");
		this.setValidado(false);
		this.setEventos(new ArrayList<Evento>());
		this.setMascotas(new ArrayList<Mascota>());
		this.setSolicitudes(new ArrayList<EstadoSolicitud>());
	}
	
	public Veterinario(
			String nombre,
			String domicilio,
			Boolean validado) {
		super();
		this.setNombreClinica(nombre);
		this.setDomicilioClinica(domicilio);
		this.setValidado(validado);
		this.setEventos(new ArrayList<Evento>());
		this.setMascotas(new ArrayList<Mascota>());
		this.setSolicitudes(new ArrayList<EstadoSolicitud>());
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public String getDomicilioClinica() {
		return domicilioClinica;
	}

	public void setDomicilioClinica(String domicilio) {
		this.domicilioClinica = domicilio;
	}

	public Boolean getValidado() {
		return validado;
	}

	public void setValidado(Boolean validado) {
		this.validado = validado;
	}

	public String getNombreClinica() {
		return nombreClinica;
	}

	public void setNombreClinica(String nombreClinica) {
		this.nombreClinica = nombreClinica;
	}

	public List<EstadoSolicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<EstadoSolicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

}
