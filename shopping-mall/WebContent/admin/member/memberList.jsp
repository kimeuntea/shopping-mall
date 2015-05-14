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
	<h3>회원리스트</h3>
	<form name="formm" method="post">
		<table border="1">
			<tr>
				<td>회원이름 검색</td>
				<td><input type="text" name="id"><input type="button"
					value="검색" onclick="go_serach()"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td>아이디</td>
				<td>이메일</td>
				<td>주소</td>
				<td>번호</td>
				<td>가입날짜</td>
			</tr>
			<c:forEach var="member" items="${memberlist}" >
				<tr>
					<td>${member.name}</td>
					<td>${member.id}</td>
					<td>${member.email}</td>
					<td>${member.address}</td>
					<td>${member.phone}</td>
					<td>${member.date}</td>
				</tr>
			</c:forEach>

		</table>
	</form>
</body>
</html>