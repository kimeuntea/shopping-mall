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
	<h3 align="center">�ֹ�����Ʈ</h3>
	<form action="" name="formm">
		<table border="1" align="center">
			<tr>
				<td colspan="8"><input type="text" name="key"><input
					type="button" name="btn" value="�˻�" onclick="go_findorder()"></td>
			</tr>
			<tr>
				<td>�ֹ���ȣ</td>
				<td>�ֹ��󼼹�ȣ</td>
				<td>���̵�</td>
				<td>�̸�</td>
				<td>��ǰ��</td>
				<td>�ֹ�����</td>
				<td>����</td>
				<td>ó��</td>
			</tr>
			<c:forEach items="${orderlist}" var="order">
				<tr>
					<td>${order.oseq}</td>
					<td><a
						href="NonageServlet?command=admin_order_detail&odseq=${order.odseq}">${order.odseq}</a>
					</td>
					<td>${order.id}</td>
					<td>${order.mname}</td>
					<td>${order.pname}</td>
					<td><fmt:formatDate value="${order.indate}" type="date" /></td>
					<td>${order.quantity}</td>
					<td><c:choose>
							<c:when test="${order.result=='1'}">
					��ó��
					</c:when>
							<c:otherwise>
					ó���Ϸ�
					</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<%@include file="../footer.jsp"%>
</body>
</html>