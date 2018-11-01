<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
	<h1>Login Form</h1>
	<form action="${pageContext.request.contextPath}/LoginController" method="post">
		id : <input type="text" name="id">
		pw : <input type="text" name="pw">
		<input type="submit" value="Login">
	</form>
</body>
</html>