package clasesDAO;

import clasesDAOImplJPA.MensajeDAOJPA;
import clasesDAOImplJPA.UsuarioDAOJPA;
import clasesDAOImplJdbc.MensajeDAOJdbc;
import clasesDAOImplJdbc.UsuarioDAOJdbc;

public interface FactoryDAO {

	public static UsuarioDAOJdbc getUsuarioDAO(){
		return new UsuarioDAOJdbc();
	}

	public static MensajeDAOJdbc getMensajeDAO(){
		return new MensajeDAOJdbc();
	}

	public static UsuarioDAOJPA getUsuarioDAOJPA(){
		return new UsuarioDAOJPA();
	}

	public static MensajeDAOJPA getMensajeDAOJPA(){
		return new MensajeDAOJPA();
	}
}