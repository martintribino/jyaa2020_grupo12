package clasesDAO;

import clasesDAOImplJdbc.MensajeDAOJdbc;
import clasesDAOImplJdbc.UsuarioDAOJdbc;

public interface FactoryDAO {

	public static UsuarioDAOJdbc getUsuarioDAO(){
		return new UsuarioDAOJdbc();
	}

	public static MensajeDAOJdbc getMensajeDAO(){
		return new MensajeDAOJdbc();
	}
}
