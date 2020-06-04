package DAOJPA;

import org.jvnet.hk2.annotations.Service;

import IDAO.IRolDAO;
import modelo.Rol;

@Service
public class RolDAOJPA extends GenericDAOJPA<Rol> implements IRolDAO  {

	/**
	 * Rol DAO JPA
	 */

	private static final long serialVersionUID = -7289218776157497399L;

	public RolDAOJPA() {
		super(Rol.class);
	}

}
