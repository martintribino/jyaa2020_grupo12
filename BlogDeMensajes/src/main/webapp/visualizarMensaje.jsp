<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	  <h2><a href="#">${userSession.name}</a></h2>
	  <h2><a href="Salir.jsp">Log Out</a></h2>
  <%} else {%>
  	<h2><a href="Login.jsp">Log In</a></h2>
  <%}%>
</nav>
<div class="messages">
  <% 
  	ServletContext sc = request.getServletContext();
  	java.util.List<String> posts = (java.util.List<String>)sc.getAttribute("posts");
  	 for (String post : posts) {%>
	  	<article>
	  		<p><%=post%></p>
		</article>
  <%}%>
  <%if (isLoggedIn) {%>
		<p>Add a post:</p>
		<form action="Mensajes" method="POST">
			<div>
				<label for="post">Post:</label>
				<textarea id="post" name="post"></textarea>
			</div>
			<div>
				<input type="submit" value="Send">
			</div>
		</form>
  <%}%>
</div>
</body>
</html>