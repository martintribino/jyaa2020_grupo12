package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-31T19:27:26.398-0300")
@StaticMetamodel(Direccion.class)
public class Direccion_ {
	public static volatile SingularAttribute<Direccion, String> calle;
	public static volatile SingularAttribute<Direccion, String> ciudad;
	public static volatile SingularAttribute<Direccion, String> estado;
	public static volatile SingularAttribute<Direccion, Integer> codigoPostal;
	public static volatile SingularAttribute<Direccion, Coordinadas> coordinadas;
}
