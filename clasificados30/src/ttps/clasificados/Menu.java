package ttps.clasificados;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

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
		String leng = request.getAttribute("leng").toString();
		ResourceBundle rb = ResourceBundle.getBundle(leng);
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
			this.printAdminProfile(user, role, out, rb);
		} else if (role.equals("public")) {
			if (dispatcher != null) {
				try {
					((javax.servlet.RequestDispatcher) dispatcher).include(request, response);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			this.printPublicProfile(user, role, out, rb);
		} else {
			this.printError(out, rb);
		}
		out.println("</body>\\n</html>");
		
	}

	protected void printAdminProfile(String user, String role, PrintWriter out, ResourceBundle rb) {
		String adminProfile = String.format(
			"<p>%s %s (%s).</p>" +
			"<nav class=\"menu\">\n" + 
			"  <ul>\n" + 
			"    <li><a href=\"#\">%s</a></li>\n" + 
			"    <li><a href=\"#\">%s</a></li>\n" + 
			"    <li><a href=\"#\">%s</a></li>\n" + 
			"  </ul>\n" + 
			"</nav>\n",
			rb.getString("lblwelcome"),
			user,
			role,
			rb.getString("lbllisting"),
			rb.getString("lblabmAdmin"),
			rb.getString("lblstats")
		);
		out.println(adminProfile);
		out.close();
	}
	
	protected void printPublicProfile(String user, String role, PrintWriter out, ResourceBundle rb) {
		String publicProfile = String.format(
			"<p>%s %s (%s).</p>" +
			"<nav class=\"menu\">\n" + 
			"  <ul>\n" + 
			"    <li><a href=\"#\">%s</a></li>\n" + 
			"    <li><a href=\"#\">%s</a></li>\n" + 
			"    <li><a href=\"#\">%s</a></li>\n" + 
			"  </ul>\n" + 
			"</nav>\n",
			rb.getString("lblwelcome"),
			user,
			role,
			rb.getString("lblupdate"),
			rb.getString("lblabmuser"),
			rb.getString("lblresponse")
		);
		out.println(publicProfile);
		out.close();
	}
	
	protected void printError(PrintWriter out, ResourceBundle rb) {
		String errorMsg = String.format(
			"<p>%s</p>" +
			"<p>%s</p>",
			rb.getString("lblincorrect"),
			rb.getString("lbltry")
		);
		out.println(errorMsg);
		out.close();
	}
	
}
