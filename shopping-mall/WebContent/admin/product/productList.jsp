<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp"%>
	<%@include file="../sub_menu.jsp"%>
	<h3>��ǰ����Ʈ</h3>
	<form name="formm" method="post">
		<table border="1" align="center">
			<tr>
				<td>��ǰ�̸� �˻�</td>
				<td colspan="4"><input type="hidden" name="key2"
					value="${key2}"> <input type="text" name="key"><input
					type="button" value="�˻�" onclick="go_serach()"> &nbsp; <a
					href="NonageServlet?command=admin_product_writeform">��ǰ���</a>�ѰԽù�${bean.total}</td>
			</tr>
			<tr>
				<td>��ȣ</td>
				<td>��ǰ��ȣ</td>
				<td>��ǰ��</td>
				<td>����</td>
				<td>����</td>
			</tr>
			<c:forEach var="productlist" items="${productlist}"
				varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td>${productlist.pseq}</td>
					<td><a
						href="NonageServlet?command=admin_product_detail&pseq=${productlist.pseq}
						&pagenumber=${pageNumber}&key2=${key2}">${productlist.name}</a>
					</td>
					<td>${productlist.price2}</td>
					<td>${productlist.content}</td>
				</tr>
			</c:forEach>
		</table>
		<center>
			<c:if test="${pageNumber>pageCount}">
				<a
					href="?command=admin_product_list&pagenumber=${pageStart-1}&key2=${key2}">
					���� &nbsp;&nbsp; </a>
			</c:if>
			<c:if test="${pageNumber>1}">
				<a
					href="?command=admin_product_list&pagenumber=${pageNumber-1}&key2=${key2}">
					< </a>
			</c:if>
			<c:forEach begin="${pageStart}" end="${pageEnd}" var="i">
				<c:choose>
					<c:when test="${pageNumber==i}">
					[${i}]
					</c:when>
					<c:otherwise>
						<a href="?command=admin_product_list&pagenumber=${i}&key2=${key2}">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${pageNumber<totalpage}">
				<a
					href="?command=admin_product_list&pagenumber=${pageNumber+1}&key2=${key2}">
					> </a>
			</c:if>
			<c:if test="${pageEnd<totalpage}">
				<a
					href="?command=admin_product_list&pagenumber=${pageEnd+1}&key2=${key2}">����</a>
			</c:if>
		</center>
	</form>
</body>
</html>