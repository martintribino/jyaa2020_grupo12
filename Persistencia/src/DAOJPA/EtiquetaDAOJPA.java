package DAOJPA;

import org.jvnet.hk2.annotations.Service;

import IDAO.IEtiquetaDAO;
import modelo.Etiqueta;

@Service
public class EtiquetaDAOJPA extends GenericDAOJPA<Etiqueta> implements IEtiquetaDAO  {

	/**
	 * Etiqueta DAO JPA
	 */

	private static final long serialVersionUID = -6406732253149383426L;

	public EtiquetaDAOJPA() {
		super(Etiqueta.class);
	}

}
