package ttps.clasificados;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class SitioClasificadoListener
 *
 */
@WebListener
public class SitioClasificadoListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SitioClasificadoListener() {
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
         // TODO Auto-generated method stub
		ServletContext sc = sce.getServletContext();
		String nombre = sc.getInitParameter("nombre");
		String email = sc.getInitParameter("email");
		String telefono = sc.getInitParameter("telefono");
		SitioClasificado sitio = new SitioClasificado(nombre, email, telefono);
		sc.setAttribute("nombre", sitio.nombre.toString());
		sc.setAttribute("email", sitio.email.toString());
		sc.setAttribute("telefono", sitio.telefono.toString());
    }
	
}
