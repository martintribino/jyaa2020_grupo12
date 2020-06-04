package modelo;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-31T19:27:26.403-0300")
@StaticMetamodel(Obra.class)
public class Obra_ {
	public static volatile SingularAttribute<Obra, Long> id;
	public static volatile SingularAttribute<Obra, String> nombre;
	public static volatile SingularAttribute<Obra, String> descripcion;
	public static volatile SingularAttribute<Obra, Duration> duracion;
	public static volatile SingularAttribute<Obra, List> artistas;
	public static volatile SingularAttribute<Obra, List> fotos;
	public static volatile SingularAttribute<Obra, Set> etiquetas;
	public static volatile SingularAttribute<Obra, List> valoraciones;
}
