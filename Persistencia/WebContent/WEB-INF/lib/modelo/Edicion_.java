package modelo;

import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-31T19:27:26.399-0300")
@StaticMetamodel(Edicion.class)
public class Edicion_ {
	public static volatile SingularAttribute<Edicion, Long> id;
	public static volatile SingularAttribute<Edicion, String> nombre;
	public static volatile SingularAttribute<Edicion, String> descripcion;
	public static volatile SingularAttribute<Edicion, LocalDateTime> desde;
	public static volatile SingularAttribute<Edicion, LocalDateTime> hasta;
	public static volatile SingularAttribute<Edicion, List> actividades;
	public static volatile SetAttribute<Edicion, String> fotos;
}
