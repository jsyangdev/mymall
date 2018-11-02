<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Form</h1>
	<form action="${pageContext.request.contextPath}/UpdateMemberController" method="post">
		<input type="hidden" name="no" value="${member.getNo()}">
		id : <input type="text" name="id" value="${member.getId()}" readonly><br>
		pw : <input type="text" name="pw"><br>
		level : <input type="text" name="level" value="${member.getLevel()}" readonly><br>
		<input type="submit" value="수정완료">
	</form>
</body>
</html>