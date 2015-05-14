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
	<h3>질문 상세보기</h3>
	<form action="NonageServlet?command=admin_qna_reply&qseq=${qna.qseq}" method="post"
		name="formm">
		<table border="1">
			<tr>
				<td>주제</td>
				<td>${qna.subject}<input type="hidden" name="qseq"
					value="${qna.qseq}">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${qna.content}</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>${qna.id}</td>
			</tr>
			<tr>
				<td>댓글</td>
				<td><textarea rows="10" cols="20" name="reply"></textarea></td>
			</tr>
			<tr>
				<td>날짜</td>
				<td><fmt:formatDate value="${qna.indate}" type="date" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="댓글올리기">
					&nbsp; <input type="button" value="목록"
					onclick="location.href='NonageServlet?command=admin_qna_list'"></td>
			</tr>
		</table>
	</form>
</body>
</html>