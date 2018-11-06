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
	${5%currentPage}<br>
	${currentPage}<br>
	${currentPage+4}
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
	<!-- 처음페이지, 이전페이지 링크 -->
	<c:if test="${currentPage>1}">
		<a href="${pageContext.request.contextPath}/ItemController?currentPage=1"><<</a>				<!-- 처음페이지로 -->
		<a href="${pageContext.request.contextPath}/ItemController?currentPage=${currentPage-1}"><</a>	<!-- 이전페이지로 -->
	</c:if>
	&emsp;&emsp;&emsp;
	<!-- 첫 페이지부터 마지막 페이지까지 5개로 끊어서 보여주기 -->
	<c:if test="${currentPage<=lastPage-4}">
		<c:forEach begin="${currentPage}" end="${currentPage+4}" var="currentPage" step="1" >
			<a href="${pageContext.request.contextPath}/ItemController?currentPage=${currentPage}">${currentPage}</a>
		</c:forEach>
	</c:if>
	<c:if test="${currentPage>lastPage-4}">
		<c:forEach begin="${currentPage}" end="${currentPage+(lastPage-currentPage)}" var="currentPage" step="1" >
			<a href="${pageContext.request.contextPath}/ItemController?currentPage=${currentPage}">${currentPage}</a>
		</c:forEach>
	</c:if>
	&emsp;&emsp;&emsp;
	<!-- 다음페이지, 마지막페이지 링크 -->
	<c:if test="${currentPage<lastPage}">
		<a href="${pageContext.request.contextPath}/ItemController?currentPage=${currentPage+1}">></a>	<!-- 다음페이지로 -->
		<a href="${pageContext.request.contextPath}/ItemController?currentPage=${lastPage}">>></a>		<!-- 마지막페이지로 -->
	</c:if>
	<br>&emsp;&emsp;&emsp;- 현재페이지 : ${currentPage} -
</body>
</html>