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
	<h1>Index</h1>
	<c:if test="${loginMember != null }">
		${loginMember.getId()} 님 반갑습니다 !<br>
		<a href="${pageContext.request.contextPath}/ItemController">상품보기</a><br>
		<a href="${pageContext.request.contextPath}/SelectMemberController?memberNo=${loginMember.getNo()}">내 정보 보기</a><br>
		<a href="#">로그아웃</a>
	</c:if>
	<c:if test="${loginMember == null }">
		<a href="${pageContext.request.contextPath}/ItemController">상품보기</a><br>
		<a href="${pageContext.request.contextPath}/AddMemberController">회원가입</a><br>
		<a href="${pageContext.request.contextPath}/LoginController">로그인</a><br>
	</c:if>
</body>
</html>