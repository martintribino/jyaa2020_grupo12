<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login out ...</title>
</head>
<body>
	<h2>Login out ...</h2>
	<% session.setAttribute("userSession", null); %>
	<% response.sendRedirect("visualizarMensaje.jsp"); %>
</body>
</html>