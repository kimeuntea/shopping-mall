<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	<div id="wrap">
		<%@ include file="../header.jsp"%>
		<%@include file="sub_menu.jsp" %>

		<form action="NonageServlet?command=order" name="formm" method="post">
			<c:choose>
				<c:when test="${cartlist.size()==0}">
					<h3 align="center">장바구니가 비어있습니다.</h3>
				</c:when>
				<c:otherwise>
					<table align="center">
						<tr>
							<td>상품명</td>
							<td>상품코드</td>
							<td>수량</td>
							<td>날짜</td>
						</tr>
						<c:forEach items="${cartlist}" var="cartlist">
							<tr>
								<td>${cartlist.pname}</td>
								<td>${cartlist.pseq}</td>
								<td>${cartlist.quantity}</td>
								<td><fmt:formatNumber
										value="${cartlist.price1*cartlist.quantity}" type="currency" />
								</td>
								<td><fmt:formatDate value="${cartlist.indate}" type="date" /></td>
								<td><input type="checkbox" name="cseq"
									value="${cartlist.cseq}"></td>
							</tr>
						</c:forEach>
						<tr>
							<th colspan="2">총액</th>
							<th><fmt:formatNumber value="${totalPrice}" type="currency" />
							</th>
							<th><a href="#" onclick="go_cart_delete()"><h3>삭제하기</h3></a></th>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
			<div id="clear"></div>
			<div style="float: right;">
				<input type="button" value="쇼핑계속하기"
					onclick="location.href='NonageServlet?command=index'">
				<c:if test="${cartlist.size() != 0 }">
					<input type="submit" value="주문하기" onclick="go_insert_order()">
				</c:if>
			</div>
		</form>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>