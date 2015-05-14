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
		<form action="NonageServlet?command=qnawrite" method="post"
			name="formm">
			<table border="1">
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="20" cols="10" name="content">
					</textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="작성" onclick="return check()">&nbsp; <input
						type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>