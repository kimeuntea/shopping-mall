<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="script/shopping.js">
</script>
</head>
<body>
	<form action="NonageServlet?command=findidpw&num=id" method="post"
		name="namephone">
		���̵� ã�� : <br> �� &nbsp;�� : <input type="text" name="name" value="">
		<br> ��ȭ��ȣ : <input type="text" name="phone" value=""> <br>
		<input type="submit" value="���̵� ã��" onclick="return findwindow1()">
	</form>
	<br>
	${message}

	<br>
	<br> 
	<form action="NonageServlet?command=findidpw&num=pw" method="post"
		name="idphone">
		���ã�� : <br> ���̵�: <input type="text" name="id"> <br>
		��ȭ��ȣ : <input type="text" name="phone"> <br> <input
			type="submit" value="��� ã��" onclick="return findwindow2()">
	</form>
	<input type="button" value="���" onclick="cancle()"> ${message1}
</body>
</html>