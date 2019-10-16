package clasesObjetosModelo;

import java.util.Date;

public class Intervencion extends Evento {
	/**
	 * Clase Intervencion
	 */

	protected Intervencion() {
		super();
	}

	protected Intervencion(
			Date fecha,
			String descripcion,
			Boolean concurrio,
			Veterinario veterinario,
			Mascota mascota) {
		super(fecha, descripcion, concurrio, veterinario, mascota);
	}

}
