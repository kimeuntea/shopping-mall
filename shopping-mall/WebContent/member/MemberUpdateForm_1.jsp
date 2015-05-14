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
	<div id="wrap" align="center">
		<%@include file="../header.jsp"%>
		<h1 align="center">회원정보수정 확인암호</h1>
		<form action="NonageServlet?command=MemberUpdateForm_2" method="post" name="U_f">
			<table border="1" align="center">
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pwd"> ${message}</td>
				</tr>
			</table>
			<center>
			<input type="submit" value="확인"  align="middle" onclick="U_fcheck()">
			</center>
		</form>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>