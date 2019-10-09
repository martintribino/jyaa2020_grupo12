

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ListenerUserLoad
 *
 */
@WebListener
public class ListenerUserLoad implements ServletContextListener {
	
    /**
     * Default constructor. 
     */
    public ListenerUserLoad() {
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
		String pass1 = Encrypt.encryptWithMD5("martin123");
		String pass2 = Encrypt.encryptWithMD5("admin123");
    	List<User> users = new ArrayList<User>();
    	List<String> posts = new ArrayList<String>();
    	users.add(new User("martin.tribino", pass1, "user"));
    	users.add(new User("admin", pass2, "admin"));
    	ServletContext contexto = sce.getServletContext();
    	contexto.setAttribute("users", users);
    	contexto.setAttribute("posts", posts);
    }
	
}
