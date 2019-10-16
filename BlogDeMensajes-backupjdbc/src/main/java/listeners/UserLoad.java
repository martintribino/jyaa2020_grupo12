package listeners;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import clasesDAO.FactoryDAO;
import clasesDAOImplJdbc.UsuarioDAOJdbc;
import clasesObjetosSistema.Usuario;

/**
 * Application Lifecycle Listener implementation class UserLoad
 *
 */
@WebListener
public class UserLoad implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public UserLoad() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	UsuarioDAOJdbc usuario = FactoryDAO.getUsuarioDAO();
    	Usuario u = new Usuario("admin", "Admin", "Admin", "admin123", "admin@admin.ad", "admin");
    	usuario.guardar(u);
    }
	
}
