package servlets;


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

import clasesDAO.FactoryDAO;
import clasesDAOImplJdbc.UsuarioDAOJdbc;
import clasesObjetosSistema.Encrypt;
import clasesObjetosSistema.Usuario;

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
		UsuarioDAOJdbc mensajesJdbc = FactoryDAO.getUsuarioDAO();
		List<Usuario> users = (List<Usuario>) mensajesJdbc.cargar();
		ServletRequest req = ((ServletRequest) request);
		String userName = req.getParameter("user");
		String pass = req.getParameter("pass");
		String page = "Login.jsp";
		for (Usuario us : users) {
	        if (us.getNombreUsuario().equals(userName) && us.verificarClave(pass)) {
	    		HttpSession session = request.getSession(true);
	    		session.setAttribute("userSession", us);
	        	page = "visualizarMensaje.jsp";
	        	break;
	        }
	    }
		response.sendRedirect(page);
	}

}
