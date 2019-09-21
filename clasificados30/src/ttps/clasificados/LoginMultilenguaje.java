package ttps.clasificados;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginMultilenguaje
 */
@WebServlet(description = "Login Multilenguaje", urlPatterns = { "/LoginMultilenguaje" })
public class LoginMultilenguaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMultilenguaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		String leng = request.getAttribute("leng").toString();
		ResourceBundle rb = ResourceBundle.getBundle(leng);
	    String formPage = String.format("<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<title>%s</title>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"	<form action=\"Login\" method=\"POST\">\n" + 
				"		<div>\n" + 
				"			<label for=\"user\">%s</label>\n" + 
				"			<input id=\"user\" name=\"user\" type=\"text\"/>\n" + 
				"		</div>\n" + 
				"		<div>\n" + 
				"			<label for=\"pass\">%s</label>\n" + 
				"			<input id=\"pass\" name=\"pass\" type=\"password\"/>\n" + 
				"		</div>\n" + 
				"		<div>\n" + 
				"			<input type=\"submit\" value=\"%s\">\n" + 
				"		</div>\n" + 
				"	</form>\n" + 
				"</body>\n" + 
				"</html>",
				rb.getString("logintitle"),
				rb.getString("labelusuario"),
				rb.getString("labelpassword"),
				rb.getString("lblloginbutton")
			);
		out.write(formPage);
		out.close();
	}

}
