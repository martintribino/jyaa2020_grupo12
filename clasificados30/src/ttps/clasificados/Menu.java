package ttps.clasificados;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getAttribute("user").toString();
		String role = request.getAttribute("role").toString();
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		out.write("<!DOCTYPE html><html><head><meta charset=\\\"UTF-8\\\"><title>Admin</title></head><body>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Encabezado");
		if (role.equals("admin")) {
			if (dispatcher != null) {
				try {
					((javax.servlet.RequestDispatcher) dispatcher).include(request, response);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			this.printAdminProfile(user, role, out);
		} else if (role.equals("public")) {
			if (dispatcher != null) {
				try {
					((javax.servlet.RequestDispatcher) dispatcher).include(request, response);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			this.printPublicProfile(user, role, out);
		} else {
			this.printError(out);
		}
		out.println("</body>\\n</html>");
		
	}

	protected void printAdminProfile(String user, String role, PrintWriter out) {
		String adminProfile = String.format(
				"<p>Welcome %s (%s).</p>" +
				"<nav class=\"menu\">\n" + 
				"  <ul>\n" + 
				"    <li><a href=\"#\">Listar Usuarios Publicadores</a></li>\n" + 
				"    <li><a href=\"#\">ABM de Administradores</a></li>\n" + 
				"    <li><a href=\"#\">Ver Estadísticas</a></li>\n" + 
				"  </ul>\n" + 
				"</nav>\n",
				user,
				role
		);
		out.println(adminProfile);
		out.close();
	}
	
	protected void printPublicProfile(String user, String role, PrintWriter out) {
		String publicProfile = String.format(
				"<p>Welcome %s (%s).</p>" +
				"<nav class=\"menu\">\n" + 
				"  <ul>\n" + 
				"    <li><a href=\"#\">Actualizar Datos de Contacto</a></li>\n" + 
				"    <li><a href=\"#\">ABM de publicaciones</a></li>\n" + 
				"    <li><a href=\"#\">Contestar consultas</a></li>\n" + 
				"  </ul>\n" + 
				"</nav>\n",
				user,
				role
		);
		out.println(publicProfile);
		out.close();
	}
	
	protected void printError(PrintWriter out) {
		String errorMsg = String.format(
				"<p>Your username or password is/are incorrect.</p>" +
				"<p>Please try again.</p>"
		);
		out.println(errorMsg);
		out.close();
	}
	
}
