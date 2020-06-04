package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-31T19:27:26.394-0300")
@StaticMetamodel(Asistencia.class)
public class Asistencia_ {
	public static volatile SingularAttribute<Asistencia, Long> id;
	public static volatile SingularAttribute<Asistencia, String> qrcode;
	public static volatile SingularAttribute<Asistencia, Usuario> usuario;
	public static volatile SingularAttribute<Asistencia, Actividad> actividad;
}
