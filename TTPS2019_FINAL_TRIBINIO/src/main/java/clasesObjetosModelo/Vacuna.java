package clasesObjetosModelo;

import java.util.Date;

public class Vacuna extends Evento {
	/**
	 * Clase Vacuna
	 */

	protected Vacuna() {
		super();
	}

	protected Vacuna(
			Date fecha,
			String descripcion,
			Boolean concurrio,
			Veterinario veterinario,
			Mascota mascota) {
		super(fecha, descripcion, concurrio, veterinario, mascota);
	}

}
