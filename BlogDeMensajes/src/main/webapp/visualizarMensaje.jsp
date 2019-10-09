<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="clasesObjetosSistema.Mensaje" %>
<%@ page import="clasesDAO.FactoryDAO" %>
<%@ page import="clasesDAOImplJdbc.MensajeDAOJdbc" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Visualizar</title>
</head>
<body>
<nav>
  <h2><a href="#">Home</a></h2>
  <%Boolean isLoggedIn = session.getAttribute("userSession") != null;%>
  <%if (isLoggedIn) {%>
	  <h2><a href="#">${userSession.getNombreUsuario()}</a></h2>
	  <h2><a href="Salir.jsp">Log Out</a></h2>
  <%} else {%>
  	<h2><a href="Login.jsp">Log In</a></h2>
  <%}%>
  <h2><a href="agregarMensaje.jsp">Add Post</a></h2>
</nav>
<div class="messages">
  <% 
	MensajeDAOJdbc postsJdbc = FactoryDAO.getMensajeDAO();
  	java.util.List<Mensaje> posts = postsJdbc.cargar();
  	 for (Mensaje post : posts) {%>
	  	<article>
	  		<p><%=post.getNombreUsuario() %> - <strong><%=post.getMensaje()%></strong></p>
		</article>
  <%}%>
</div>
</body>
</html>