<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<%@ include file="../header.jsp"%>
		<%@ include file="sub_menu.html"%>
		<h1 align="center">�α���</h1>
		<form action="NonageServlet?command=Login" name="frmmm" method="post">
			<table align="center">
				<tr>
					<td>���̵�</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>��й�ȣ</td>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="�α���" onclick="return login()"> 
					<input type="reset" value="���"></td>
				</tr>
			</table>
		</form>
		<br>
		<form action="NonageServlet?command=find_id" method="post" name="find_frm">
		<center><input type="button" value="���̵�  / ���ã��" onclick="find_idpw()"></center>
		</form>	    
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>