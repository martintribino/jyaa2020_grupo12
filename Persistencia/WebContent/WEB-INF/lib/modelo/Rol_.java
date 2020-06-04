package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-31T19:27:26.403-0300")
@StaticMetamodel(Rol.class)
public class Rol_ {
	public static volatile SingularAttribute<Rol, Long> id;
	public static volatile SingularAttribute<Rol, String> nombre;
	public static volatile SingularAttribute<Rol, String> descripción;
	public static volatile SetAttribute<Rol, String> permisos;
}
