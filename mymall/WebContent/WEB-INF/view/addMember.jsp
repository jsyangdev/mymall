<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addMember</title>
</head>
<body>
	<h1>Add Member Form</h1>
	<form action="${pageContext.request.contextPath}/AddMemberController" method="post">
		id : <input type="text" name=id><br>
		pw : <input type="text" name=pw><br>
		level : <input type="text" name=level><br><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>