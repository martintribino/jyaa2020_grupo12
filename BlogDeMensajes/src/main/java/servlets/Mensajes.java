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
import clasesDAOImplJPA.MensajeDAOJPA;
import clasesDAOImplJdbc.MensajeDAOJdbc;
import clasesObjetosSistema.Mensaje;
import clasesObjetosSistema.Usuario;

/**
 * Servlet implementation class Mensajes
 */
@WebServlet("/Mensajes")
public class Mensajes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mensajes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MensajeDAOJPA mensajesJdbc = FactoryDAO.getMensajeDAOJPA();
		ServletRequest req = ((ServletRequest) request);
		String postStr = req.getParameter("post");
		HttpSession session = request.getSession(false);
		if (session != null) {
			Usuario user = (Usuario) session.getAttribute("userSession");
			Mensaje m = new Mensaje(user, postStr);
			mensajesJdbc.guardar(m);
		}
		response.sendRedirect("agregarMensaje.jsp");
	}

}
