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
	<h1>회원탈퇴 비번체크</h1>
	<form action="${pageContext.request.contextPath}/passwordCheckController" method="post">
		<input type="hidden" name="no" value="${no}">
		pw : <input type="text" name="pw">
		<input type="submit" value="비번체크">
	</form>
</body>
</html>