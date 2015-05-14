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
		<%@include file="sub_menu.jsp"%>
		<form method="post" name="formm">
			<table>
				<tr>
					<th>�ֹ�����</th>
					<th>�ֹ���ȣ</th>
					<th>��ǰ��</th>
					<th>�����ݾ�</th>
					<th>�ֹ���</th>
					<th>ó�����</th>
				</tr>
				<c:forEach items="${orderlist}" var="orderbean">
					<tr>
						<td><fmt:formatDate value="${orderbean.indate}" type="date" /></td>
						<td>${orderbean.oseq}</td>
						<td>${orderbean.pname}</td>
						<td><fmt:formatNumber value="${orderbean.price2}"
								type="currency" /></td>
						<td><a
							href="NonageServlet?command=order_detail&oseq=${orderbean.oseq}">
								��ȸ </a></td>
						<td><c:choose>
								<c:when test='${orderbean.result=="1"}'>
								ó����
								</c:when>
								<c:otherwise>
								ó���Ϸ�
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
				<tr>
					<td><input type="button" value="���ΰ���ϱ�"
						onclick="location.href='NonageServlet?command=index'"></td>
				</tr>
			</table>
		</form>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>