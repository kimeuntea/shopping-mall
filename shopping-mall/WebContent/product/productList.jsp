<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	<div id="wrap">
		<%@ include file="../header.jsp"%>
		<%@ include file="sub_menu.html"%>
		<br>
		<c:set var="nn" value="${nn+nn}"></c:set>
		<c:forEach items="${productlist}" var="list">
		<div id="item">
			<a href="NonageServlet?command=productView&seq=${list.pseq}">
			<img src="product_img/${list.image}">
				<h3>${list.name}</h3>
				<p>${list.price1}</p></a>
			<c:set value="${nn+1}" var="nn"></c:set>
			<c:if test="${nn>2}"><br></c:if>
			</div>
		</c:forEach>
		 <div class="clear"></div>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>