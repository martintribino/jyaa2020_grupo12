package modelo;

import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Espacio.Estados;
import org.apache.tomcat.jni.Address;

@Generated(value="Dali", date="2020-05-31T19:27:26.400-0300")
@StaticMetamodel(Espacio.class)
public class Espacio_ {
	public static volatile SingularAttribute<Espacio, Long> id;
	public static volatile SingularAttribute<Espacio, String> nombre;
	public static volatile SingularAttribute<Espacio, String> descripcion;
	public static volatile SingularAttribute<Espacio, Address> direccion;
	public static volatile SingularAttribute<Espacio, Integer> capacidad;
	public static volatile SingularAttribute<Espacio, Estados> condicion;
	public static volatile SingularAttribute<Espacio, Set> etiquetas;
}
