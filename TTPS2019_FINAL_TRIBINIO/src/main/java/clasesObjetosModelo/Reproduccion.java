package clasesObjetosModelo;

import java.util.Calendar;
import java.util.Date;

public class Reproduccion extends Evento {
	/**
	 * Clase Reproduccion
	 */
	
	private Date fechaParto;
	private int nroCachorros;

	protected Reproduccion() {
		super();
		this.setFechaParto(Calendar.getInstance().getTime());
		this.setNroCachorros(0);
	}

	protected Reproduccion(
			Date fecha,
			String descripcion,
			Boolean concurrio,
			Veterinario veterinario,
			Mascota mascota,
			Date fechaParto,
			int nroCachorros) {
		super(fecha, descripcion, concurrio, veterinario, mascota);
		this.setFechaParto(fechaParto);
		this.setNroCachorros(nroCachorros);
	}

	public Date getFechaParto() {
		return fechaParto;
	}

	public void setFechaParto(Date fechaParto) {
		this.fechaParto = fechaParto;
	}

	public int getNroCachorros() {
		return nroCachorros;
	}

	public void setNroCachorros(int nroCachorros) {
		this.nroCachorros = nroCachorros;
	}

}
