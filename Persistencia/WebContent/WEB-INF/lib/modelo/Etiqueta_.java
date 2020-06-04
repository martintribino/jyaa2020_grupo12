package modelo;

import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-31T19:27:26.401-0300")
@StaticMetamodel(Etiqueta.class)
public class Etiqueta_ {
	public static volatile SingularAttribute<Etiqueta, Long> id;
	public static volatile SingularAttribute<Etiqueta, String> nombre;
	public static volatile SingularAttribute<Etiqueta, String> descripcion;
	public static volatile SingularAttribute<Etiqueta, Set> artistas;
	public static volatile SingularAttribute<Etiqueta, Set> espacios;
	public static volatile SingularAttribute<Etiqueta, Set> obras;
}
