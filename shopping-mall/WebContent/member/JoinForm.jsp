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
		<%@ include file="../header.jsp"%>
		<table align="center">
			<tr>
				<td><%@include file="sub_menu.html"%></td>
				<td>
				<form action="NonageServlet?command=Join" name="frm" method="post" >
					<table border="1">
						<tr>
							<td>아이디</td>
							<td><input type="text" name="id" value="">
							<input type="button" value="중복체크" onclick="idcheck()">
							<input type="hidden" name="reid" value="${id}"></td>
						</tr>
						<tr>
							<td>암호</td>
							<td><input type="password" name="pwd" value=""></td>
						</tr>
						<tr>
							<td>암호확인</td>
							<td><input type="password" name="pwd_1" value=""></td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input type="text" name="email"></td>
						</tr>
						<tr>
							<td>우편번호</td>
							<td><input type="text" name="zipcode" readonly="readonly">
							<input type="button" value="우편찾기" onclick="zipcode()"></td>
						</tr>
						<tr>
							<td>주소</td>
							<td><input type="text" name="address"></td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td><input type="text" name="phone"></td>
						</tr>
						<tr>
						<td colspan="2" align="center">
						<input type="submit" value="가입" onclick="return formcheck()" > &nbsp;&nbsp; 
					  <input type="reset" value="다시작성"></td></tr>
					</table>
					  <br>
					  <br>
					  
					</form>
				</td>
			</tr>
		</table>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>