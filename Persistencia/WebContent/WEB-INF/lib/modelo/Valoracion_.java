package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-31T19:27:26.405-0300")
@StaticMetamodel(Valoracion.class)
public class Valoracion_ {
	public static volatile SingularAttribute<Valoracion, Long> id;
	public static volatile SingularAttribute<Valoracion, String> descripcion;
	public static volatile SingularAttribute<Valoracion, Integer> puntaje;
	public static volatile SingularAttribute<Valoracion, Usuario> usuario;
	public static volatile SingularAttribute<Valoracion, Obra> obra;
}
