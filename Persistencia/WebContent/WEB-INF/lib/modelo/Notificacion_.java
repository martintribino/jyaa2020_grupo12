package modelo;

import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Notificacion.Estados;
import modelo.Notificacion.Tipos;

@Generated(value="Dali", date="2020-05-31T19:27:26.402-0300")
@StaticMetamodel(Notificacion.class)
public class Notificacion_ {
	public static volatile SingularAttribute<Notificacion, Long> id;
	public static volatile SingularAttribute<Notificacion, String> nombre;
	public static volatile SingularAttribute<Notificacion, Tipos> tipo;
	public static volatile SingularAttribute<Notificacion, Estados> estado;
	public static volatile SingularAttribute<Notificacion, Actividad> actividad;
	public static volatile SingularAttribute<Notificacion, List> usuarios;
}
