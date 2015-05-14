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
		<%@include file="sub_menu.html"%>
		<h1>ITEM</h1>
		<div id="itemdetil">
			<form method="post" name="formm">
				<fieldset>
					<legend>Item view Info</legend>
					<span style="float: left"> <img width="50" height="50"
						src="product_img/${product.image}.jpg"> </span>
						<a href="NonageServlet?command=productView&seq=${product.pseq}">
					<h2>${product.name }</h2>
					</a> 
					<label>가격 : </label>
					<p>${product.price1}</p>
					수량 :
					<input type="text" name="quantity" size="2" value="1">
					<input type="hidden" name="pseq" value="${product.pseq }">
				</fieldset>
				<div class="clear"></div>
				<div id="buttons" align="right">
				<input type="button" value="장바구니에 담기" class="submit" onclick="go_cart()">
				<input type="button" value="즉시 구매" class="submit" onclick="go_order()">
				<input type="reset" value="취소">
				</div>
			</form>
		</div>
		<jsp:include page="../footer.jsp" />
		</div>
</body>
</html>