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
		아이디 찾기 : <br> 이 &nbsp;름 : <input type="text" name="name" value="">
		<br> 전화번호 : <input type="text" name="phone" value=""> <br>
		<input type="submit" value="아이디 찾기" onclick="return findwindow1()">
	</form>
	<br>
	${message}

	<br>
	<br> 
	<form action="NonageServlet?command=findidpw&num=pw" method="post"
		name="idphone">
		비번찾기 : <br> 아이디: <input type="text" name="id"> <br>
		전화번호 : <input type="text" name="phone"> <br> <input
			type="submit" value="비번 찾기" onclick="return findwindow2()">
	</form>
	<input type="button" value="취소" onclick="cancle()"> ${message1}
</body>
</html>