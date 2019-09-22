package cupones;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DatosPers
 */
@WebServlet("/DatosPers")
public class DatosPers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatosPers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        String names = request.getParameter("names");
        String surnames = request.getParameter("surnames");
        String dni = request.getParameter("dni");
        String email = request.getParameter("dni");
        HttpSession sesion = request.getSession();
        DatosCupon dc = (DatosCupon)sesion.getAttribute("dc");
        if (dc == null) {
        	dc = new DatosCupon();
        }
        dc.setNames(names);
        dc.setSurnames(surnames);
        dc.setDni(dni);
        dc.setEmail(email);
        sesion.setAttribute("dc", dc);
        response.sendRedirect("formuFechaSala.html");
	}

}
