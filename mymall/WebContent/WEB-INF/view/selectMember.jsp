<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Member</title>
</head>
<body>
	<h1>내 정보 보기</h1>
	<form action="${pageContext.request.contextPath}/SelectMemberController" method="post">
		<input type="hidden" name="no" value="${member.getNo()}">
		id : <input type="text" name="id" value="${member.getId()}" readonly><br>
		level : <input type="text" name="level" value="${member.getLevel()}" readonly><br>
		<input type="submit" value="회원수정">
	</form>
	<a href="${pageContext.request.contextPath}/passwordCheckController?memberNo=${member.getNo()}"><button>회원탈퇴</button></a>
</body>
</html>