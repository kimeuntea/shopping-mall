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
		<form action="NonageServlet?command=qnamodifyform"
			method="post">
			<table border="1" align="center">
				
				<tr>
					<td>����</td>
					<td>${qnaview.subject}<input type="hidden" name="qseq" value="${qnaview.qseq}"></td>

				</tr>
				<tr>
					<td>����</td>
					<td>${qnaview.content}</td>
				</tr>
				<%-- <tr>
					<td>�亯����</td>
					<td>${qnaview.reply}</td>
				</tr>
				 --%>
				<tr>
					<td colspan="2"><input type="submit" value="����"> <input
						type="button" value="�亯"
						onclick="location.href='NonageServlet?command=replyform&qseq=qseq'">
					</td>
				</tr>
			</table>
		</form>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>