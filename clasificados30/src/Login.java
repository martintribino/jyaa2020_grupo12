

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import clasificados30.User;

/**
 * Servlet implementation class Login
 * @param <HttpServletRequest>
 * @param <RequestDispatcher>
 */
@WebServlet("/Login")
public class Login<HttpServletRequest, RequestDispatcher> extends HttpServlet {
    private static final Boolean IS_FORWARD = true;
	private static final long serialVersionUID = 1L;
	private List<User> usersArray = new ArrayList<User>();

    /**
     * Default constructor. 
     */
    public Login() {
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
		ServletContext sc = config.getServletContext();
		String users = sc.getInitParameter("users");
		String[] usrs = users.split(";");
		for (int i = 0 ; i < usrs.length; i++) {
			String[] auxUsrs = usrs[i].split(","); 
			User aux = new User(auxUsrs[0], auxUsrs[1], auxUsrs[2]);
			this.usersArray.add(aux);
		}
    }
    
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.doGet(req, resp);
    }

	
	@Override
	protected void doPost(javax.servlet.http.HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletRequest req = ((ServletRequest) request);
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		String role = "";
		for (User u : this.usersArray) {
			if (u.name.equals(user.toString()) && u.pass.equals(pass.toString()) ) {
				role = u.role;
			}
		}
		if (Login.IS_FORWARD) {
			HttpServletRequest dispatcher = (HttpServletRequest) request.getRequestDispatcher("/Menu");
			if (dispatcher != null) {
				request.setAttribute("user", user);
				request.setAttribute("pass", pass);
				request.setAttribute("role", role);
				try {
					((javax.servlet.RequestDispatcher) dispatcher).forward(request, response);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		} else {
			useSendRedrect(role, response);
		}
	}

	protected void useSendRedrect(String role, HttpServletResponse response) {
		if (role.equals("admin")) {
			try {
				response.sendRedirect("administrador.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (role.contentEquals("public")) {
			try {
				response.sendRedirect("publicador.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.sendRedirect("error.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
