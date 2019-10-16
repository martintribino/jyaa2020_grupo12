package clasesObjetosModelo;

import java.util.ArrayList;
import java.util.List;

public class Duenio extends Persona {

	/**
	 * Clase Dueño
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Mascota> mascotas;
	
	public Duenio() {
		super();
		this.setMascotas(new ArrayList<Mascota>());
	}
	
	public Duenio( List<Mascota> mascotas ) {
		super();
		this.setMascotas(mascotas);
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

}
