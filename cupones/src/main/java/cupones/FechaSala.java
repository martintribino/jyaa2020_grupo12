package cupones;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FechaSala
 */
@WebServlet("/FechaSala")
public class FechaSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FechaSala() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        HttpSession sesion = request.getSession();
        DatosCupon dc = (DatosCupon)sesion.getAttribute("dc");
        if (dc == null) {
            response.sendRedirect("FormuDatosPers.html");
        } else {
			request.setCharacterEncoding("UTF-8");
            String date = request.getParameter("date");
            String sala = request.getParameter("room");
        	dc.setDate(date);
        	dc.setSala(sala);
            sesion.setAttribute("dc", dc);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/CuponDescuento");
			try {
				dispatcher.forward(request, response);
			} catch (Exception e) {
				System.out.println(e);
			}
        }
	}

}
