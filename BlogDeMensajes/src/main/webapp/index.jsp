<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio - LogIn</title>
</head>
<body>
	<form action="Login" method="POST">
		<div>
			<label for="user">User</label>
			<input id="user" name="user" type="text"/>
		</div>
		<div>
			<label for="pass">Password</label>
			<input id="pass" name="pass" type="password"/>
		</div>
		<div>
			<input type="submit" value="Send">
		</div>
	</form>
</body>
</html>
