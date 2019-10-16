package clasesObjetosModelo;

import java.util.Date;

public class EstadoSolicitud {
	/**
	 * Clase Estado Solicitud
	 */

	enum Estados {
	  ESPERA,
	  APROBADO,
	  RECHAZADO
	}

	private Date fecha;
	private Estados estado;
	
	public EstadoSolicitud() {
	}
	
	public EstadoSolicitud(
			Date fecha,
			Estados estado) {
		this.setFecha(fecha);
		this.setEstado(estado);
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Estados getEstado() {
		return estado;
	}
	public void setEstado(Estados estado) {
		this.estado = estado;
	}

}
