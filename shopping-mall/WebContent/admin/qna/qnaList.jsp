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

	<h3>��������Ʈ</h3>
	<form name="formm" method="post">
		<table border="1" align="center">
			<tr>
				<td>��ǰ�̸� �˻�</td>
				<td colspan="4"><input type="text" name="key"><input
					type="button" value="�˻�" onclick="go_qna()"></td>
			</tr>
			<tr>
				<td>����</td>
				<td>����</td>
				<td>���̵�</td>
				<td>��¥</td>
				<td>���</td>
				<td>��� ����</td>
			</tr>
			<c:forEach var="qnalist" items="${qnalist}" varStatus="status">
				<tr>
					<td><a
						href="NonageServlet?command=admin_qna_view&qseq=${qnalist.qseq}">${qnalist.subject}</a>
					</td>
					<td>${qnalist.content}</td>
					<td>${qnalist.id}</td>
					<td><fmt:formatDate value="${qnalist.indate}" type="date" /></td>
					<td>${qnalist.reply}</td>
					<td><c:choose>
							<c:when test="${qnalist.rep == '1'}">
							X
							</c:when>
							<c:otherwise>
							O
							</c:otherwise>
						</c:choose> </td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>