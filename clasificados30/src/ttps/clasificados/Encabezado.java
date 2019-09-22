package ttps.clasificados;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Encabezado
 */
@WebServlet("/Encabezado")
public class Encabezado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Encabezado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		ResourceBundle rb = ResourceBundle.getBundle((String) request.getAttribute("lenguaje"));
		ServletContext sc = getServletContext();
		String nombre = sc.getAttribute("nombre").toString();
		String email = sc.getAttribute("email").toString();
		String telefono = sc.getAttribute("telefono").toString();
	    PrintWriter out = response.getWriter();
		out.println(String.format("<h3>%s</h3>", rb.getString("titulo")));
		out.println(String.format("<p>%s: %s.</p>", rb.getString("lblnombre"), nombre));
		out.println(String.format("<p>%s: %s.</p>", rb.getString("lblemail"), email));
		out.println(String.format("<p>%s: %s.</p>", rb.getString("lbltelefono"), telefono));
	}

}