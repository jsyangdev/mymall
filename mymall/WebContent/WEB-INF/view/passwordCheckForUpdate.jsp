<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Password Check For Update</title>
</head>
<body>
	<h1>Password Check For Update</h1>
	<form action="${pageContext.request.contextPath}/PasswordCheckForUpdateController" method="post">
		<input type="hidden" name="no" value="${loginMember.getNo()}">
		pw : <input type="text" name="pw">
		<input type="submit" value="비번확인">
	</form>
</body>
</html>