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
				<td>�ֹ���ȣ</td>
				<td>${order.oseq}</td>
			</tr>
			<tr>
				<td>�ֹ��󼼹�ȣ</td>
				<td>${order.odseq}<input type="hidden" name="odseq" value="${order.odseq}"> </td>
			</tr>
			<tr>
				<td>���̵�</td>
				<td>${order.id}</td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td>${order.mname}</td>
			</tr>
			<tr>
				<td>��ǰ��</td>
				<td>${order.pname}</td>
			</tr>
			<tr>
				<td>�ֹ�����</td>
				<td><fmt:formatDate value="${order.indate}" type="date" /></td>
			</tr>
			<tr>
				<td>����</td>
				<td>${order.quantity}</td>
			</tr>
			<tr>
				<td>�ּ�</td>
				<td>${order.address}</td>
			</tr>
			<tr>
				<td>����</td>
				<td><fmt:formatNumber value="${order.price2*order.quantity}"
						type="currency" /></td>
			</tr>
			<tr>
				<td>ó��</td>
				<td><c:choose>
						<c:when test="${order.result=='1'}">
					��ó��
					</c:when>
						<c:otherwise>
					ó���Ϸ�
					</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td colspan=""><input type="button" value="���"
					onclick="location.href='NonageServlet?command=admin_order_list'">
					&nbsp;<input type="button" name="result" value="ó��" onclick="go_result()"></td>
			</tr>
		</table>
	</form>
	<%@include file="../footer.jsp"%>
</body>
</html>