package DAOJPA;

import org.jvnet.hk2.annotations.Service;

import IDAO.IValoracionDAO;
import modelo.Valoracion;

@Service
public class ValoracionDAOJPA extends GenericDAOJPA<Valoracion> implements IValoracionDAO  {

	/**
	 * Valoracion DAO JPA
	 */
	private static final long serialVersionUID = 7059885887788123453L;

	public ValoracionDAOJPA() {
		super(Valoracion.class);
	}

}
