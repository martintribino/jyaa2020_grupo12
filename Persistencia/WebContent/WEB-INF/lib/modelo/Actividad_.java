package modelo;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-31T19:27:26.346-0300")
@StaticMetamodel(Actividad.class)
public class Actividad_ {
	public static volatile SingularAttribute<Actividad, Long> id;
	public static volatile SingularAttribute<Actividad, String> nombre;
	public static volatile SingularAttribute<Actividad, String> descripcion;
	public static volatile SingularAttribute<Actividad, LocalDateTime> desde;
	public static volatile SingularAttribute<Actividad, LocalDateTime> hasta;
	public static volatile SingularAttribute<Actividad, Obra> obra;
	public static volatile SingularAttribute<Actividad, Espacio> espacio;
}
