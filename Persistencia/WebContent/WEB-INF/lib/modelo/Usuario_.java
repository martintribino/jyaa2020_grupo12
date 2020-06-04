package modelo;

import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-05-31T19:27:26.404-0300")
@StaticMetamodel(Usuario.class)
public class Usuario_ {
	public static volatile SingularAttribute<Usuario, Long> id;
	public static volatile SingularAttribute<Usuario, String> nombreUsuario;
	public static volatile SingularAttribute<Usuario, String> clave;
	public static volatile SingularAttribute<Usuario, String> nombre;
	public static volatile SingularAttribute<Usuario, String> apellido;
	public static volatile SingularAttribute<Usuario, Integer> dni;
	public static volatile SingularAttribute<Usuario, String> email;
	public static volatile SingularAttribute<Usuario, Integer> telefono;
	public static volatile SingularAttribute<Usuario, Rol> rol;
	public static volatile SingularAttribute<Usuario, List> artistasFav;
	public static volatile SingularAttribute<Usuario, List> obrasFav;
	public static volatile SingularAttribute<Usuario, List> etiquetasFav;
	public static volatile SingularAttribute<Usuario, List> notificaciones;
	public static volatile SingularAttribute<Usuario, List> valoraciones;
}
