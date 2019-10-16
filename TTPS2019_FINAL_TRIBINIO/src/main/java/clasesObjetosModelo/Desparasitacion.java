package clasesObjetosModelo;

import java.util.Date;

public class Desparasitacion extends Evento {
	/**
	 * Clase Desparasitacion
	 */
	
	private String droga;
	private String resultado;

	protected Desparasitacion() {
		super();
		this.setDroga("");
		this.setResultado("");
	}

	protected Desparasitacion(
			Date fecha,
			String descripcion,
			Boolean concurrio,
			Veterinario veterinario,
			Mascota mascota,
			String droga,
			String resultado) {
		super(fecha, descripcion, concurrio, veterinario, mascota);
		this.setDroga(droga);
		this.setResultado(resultado);
	}

	public String getDroga() {
		return droga;
	}

	public void setDroga(String droga) {
		this.droga = droga;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
