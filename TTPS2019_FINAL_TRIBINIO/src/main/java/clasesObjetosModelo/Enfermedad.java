package clasesObjetosModelo;

import java.util.Date;

public class Enfermedad extends Evento {
	/**
	 * Clase abstracta Enfermedad
	 */

	protected Enfermedad() {
		super();
	}

	protected Enfermedad(
			Date fecha,
			String descripcion,
			Boolean concurrio,
			Veterinario veterinario,
			Mascota mascota) {
		super(fecha, descripcion, concurrio, veterinario, mascota);
	}

}
