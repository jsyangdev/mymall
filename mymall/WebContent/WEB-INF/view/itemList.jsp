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
	<h1>Item List</h1>
	<!-- 주문하기 누르면 -> item의 pk, session의 member pk 넘김 -->
	<table border="1">
		<tr>
			<td>no</td><td>name</td><td>price</td><td>주문</td>
		</tr>
	<c:forEach items="${itemList}" var="list">
		<tr>
	  		<td><c:out value="${list.getNo()}"></c:out></td>
	  		<td><c:out value="${list.getName()}"></c:out></td>
	  		<td><c:out value="${list.getPrice()}"></c:out></td>
	  		<td><a href="${pageContext.request.contextPath}/OrderController?itemNo=${list.getNo()}&member=${loginMember.getNo()}">주문하기</a></td>
	  	</tr>
	</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/ItemController"><<</a>	<!-- 처음페이지로 -->
	<a href="${pageContext.request.contextPath}/ItemController"><</a>	<!-- 이전페이지로 -->
</body>
</html>