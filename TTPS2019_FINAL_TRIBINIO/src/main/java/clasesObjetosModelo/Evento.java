package clasesObjetosModelo;

import java.util.Calendar;
import java.util.Date;

public abstract class Evento {
	/**
	 * Clase abstracta Evento
	 */
	
	private Date fecha;
	private String descripcion;
	private Boolean concurrio;
	private Veterinario veterinario;
	private Mascota mascota;

	protected Evento() {
		this.setFecha(Calendar.getInstance().getTime());
		this.setDescripcion("");
		this.setConcurrio(false);
		this.setVeterinario(null);
		this.setMascota(null);
	}

	protected Evento(
			Date fecha,
			String descripcion,
			Boolean concurrio,
			Veterinario veterinario,
			Mascota mascota) {
		this.setFecha(fecha);
		this.setDescripcion(descripcion);
		this.setConcurrio(concurrio);
		this.setVeterinario(veterinario);
		this.setMascota(mascota);
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getConcurrio() {
		return concurrio;
	}
	public void setConcurrio(Boolean concurrio) {
		this.concurrio = concurrio;
	}
	public Veterinario getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

}
