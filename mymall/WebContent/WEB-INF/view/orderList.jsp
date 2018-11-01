<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>orderList</title>
</head>
<body>
	<h1>Order List</h1>
	<table border="1">
		<tr>
			<td>주문번호</td><td>상품번호</td><td>상품명</td><td>상품가격</td><td>주문일</td><td>삭제</td>
		</tr>
	<c:forEach items="${orderList}" var="list">
		<tr>
			<td><c:out value="${list.memberItemNo}"></c:out></td>
			<td><c:out value="${list.itemNo}"></c:out></td>
			<td><c:out value="${list.itemName}"></c:out></td>
			<td><c:out value="${list.itemPrice}"></c:out></td>
			<td><c:out value="${list.orderDate}"></c:out></td>
			<td><a href="#">주문삭제</a></td>
		</tr>
	</c:forEach>		
	</table>
</body>
</html>