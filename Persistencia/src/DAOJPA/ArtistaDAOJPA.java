package DAOJPA;

import org.jvnet.hk2.annotations.Service;

import IDAO.IArtistaDAO;
import modelo.Artista;

@Service
public class ArtistaDAOJPA extends GenericDAOJPA<Artista> implements IArtistaDAO {

	/**
	 * Artista DAO JPA
	 */

	private static final long serialVersionUID = 2033624595535639253L;

	public ArtistaDAOJPA() {
		super(Artista.class);
	}

}
