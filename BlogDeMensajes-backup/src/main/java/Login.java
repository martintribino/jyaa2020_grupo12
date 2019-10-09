

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = request.getServletContext();
		List<User> users = (List<User>) sc.getAttribute("users");
		ServletRequest req = ((ServletRequest) request);
		String userName = req.getParameter("user");
		String passStr = req.getParameter("pass");
		String pass = Encrypt.encryptWithMD5(passStr);
		String page = "Login.jsp";
		for (User us : users) {
	        if (us.getName().equals(userName) && us.getPass().equals(pass)) {
	    		HttpSession session = request.getSession(true);
	    		session.setAttribute("userSession", us);
	        	page = "visualizarMensaje.jsp";
	        	break;
	        }
	    }
		response.sendRedirect(page);
	}

}
