package modelo;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Direccion {

    @Basic
    private String calle;
    @Basic
    private String ciudad;
    @Basic
    private String estado;
    @Basic
    private Integer codigoPostal;
    @ManyToOne(cascade=CascadeType.ALL)
    Coordinadas coordinadas;

	public Direccion() {
	}

}
