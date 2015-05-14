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
		<%@include file="../header.jsp"%>
		<%@include file="sub_menu.jsp" %>
		<table>
			<tr>
				<th>��ǰ��</th>
				<th>����</th>
				<th>����</th>
				<th>�ֹ���</th>
				<th>�������</th>
			</tr>
			<c:forEach items="${orderlist}" var="list">
				<tr>
					<td><a
						href="NonageServler?command=productView&pseq=${list.pseq}">
					</a> ${list.pname}</td>
					<td>${list.quantity}</td>
					<td>${list.price2}</td>
					<td><fmt:formatDate value="${list.indate}" type="date" />
					</td>
					<td>ó��������</td>
				</tr>
			</c:forEach>
			<tr>
				<th colspan="2">�Ѿ�</th>
				<th colspan="2"><fmt:formatNumber value="${totalprice}" type="currency"/> </th>
			</tr>
		</table>
		<div class="clear">
		</div>
		<input type="button" value="���ΰ���ϱ�" onclick="location.href='NonageServlet?command=index'">
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>