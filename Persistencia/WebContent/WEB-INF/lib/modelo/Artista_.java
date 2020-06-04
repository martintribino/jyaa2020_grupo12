package modelo;

import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-31T19:27:26.393-0300")
@StaticMetamodel(Artista.class)
public class Artista_ {
	public static volatile SingularAttribute<Artista, Long> id;
	public static volatile SingularAttribute<Artista, String> nombre;
	public static volatile SingularAttribute<Artista, String> apellido;
	public static volatile SingularAttribute<Artista, String> apodo;
	public static volatile SetAttribute<Artista, String> fotos;
	public static volatile SingularAttribute<Artista, Set> etiquetas;
}
