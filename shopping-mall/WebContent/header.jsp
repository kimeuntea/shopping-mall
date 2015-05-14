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
<script type="text/javascript" src="script/shopping.js"></script>
<script type="text/javascript" src="member/member.js"></script>
<script type="text/javascript" src="product/product.js"></script>
<script type="text/javascript" src="qna/qna.js"></script>
</head>
<body>
	<a href="NonageServlet?command=index">메인페이지</a>
	<center>
		<c:choose>
			<c:when test="${sessionScope.id ==null}">
		 상단 <a href="NonageServlet?command=LoginForm">고객로그인</a> / 
		 <a href="NonageServlet?command=admin_LoginForm">관리인</a>
			</c:when>
			<c:otherwise>
				<a href="NonageServlet?command=Logout"> 로그아웃</a>
			</c:otherwise>
		</c:choose>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<c:choose>
			<c:when test="${sessionScope.id ==null}">
				<a href="NonageServlet?command=Contract">Join</a>
			</c:when>
			<c:otherwise>
				<a href="NonageServlet?command=MemberUpdateForm_1">회원정보수정</a>
			</c:otherwise>
		</c:choose>
		/<a href="NonageServlet?command=cartlist">CART</a>/<a
			href="NonageServlet?command=mypage">MYPAGE</a>/<a
			 href="NonageServlet?command=qna">Q&A</a>
	</center>
	<br>
	<br>
	<center>
		<a href="NonageServlet?command=category&kind=1">TOP</a> &nbsp; &nbsp;<a
			href="NonageServlet?command=category&kind=2">BOTTOM</a> &nbsp; &nbsp;<a
			href="NonageServlet?command=category&kind=3">SHOSE</a> &nbsp; &nbsp;<a
			href="NonageServlet?command=category&kind=4">ACCESSARIES</a> &nbsp;
		&nbsp;<a href="NonageServlet?command=category&kind=5">ONSALE</a>
	</center>
</body>
</html>