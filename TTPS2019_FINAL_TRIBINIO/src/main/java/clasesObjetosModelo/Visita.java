package clasesObjetosModelo;

import java.util.Date;

public class Visita extends Evento {
	/**
	 * Clase Visita
	 */
	
	private double peso;
	private String motivo;
	private String diagnostico;
	private String indicaciones;

	protected Visita() {
		super();
		this.setPeso(0.0);
		this.setMotivo("");
		this.setDiagnostico("");
		this.setIndicaciones("");
	}

	protected Visita(
			Date fecha,
			String descripcion,
			Boolean concurrio,
			Veterinario veterinario,
			Mascota mascota,
			String droga,
			double peso,
			String motivo,
			String diagnostico,
			String indicaciones) {
		super(fecha, descripcion, concurrio,veterinario, mascota);
		this.setPeso(peso);
		this.setMotivo(motivo);
		this.setDiagnostico(diagnostico);
		this.setIndicaciones(indicaciones);
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double d) {
		this.peso = d;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getIndicaciones() {
		return indicaciones;
	}

	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}

}
