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
	<h3>��ǰ���</h3>
	<form method="post" name="formm">
		<table border="1">
			<tr>
				<td>��ǰ��</td>
				<td>${product.name}<input type="hidden" name="pseq"
					value="${product.pseq}"> <input type="hidden"
					name="pagenumber" value="${pageNumber}"> <input
					type="hidden" name="key2" value="${key2}"></td>
			</tr>
			<tr>
				<td>����</td>
				<td>${product.price2}</td>
			</tr>
			<tr>
				<td>����</td>
				<td>${product.kind}</td>
			</tr>
			<tr>
				<td>����</td>
				<td>${product.content}</td>
			</tr>
			<tr>   
				<td>����</td>
				<td><img width="20" height="20"
					src="product_img/${product.image}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="����"
					onclick="go_modify()"> &nbsp; <input type="button"
					value="���"
					onclick="location.href='NonageServlet?command=admin_product_list&pagenumber=${pageNumber}&key2=${key2}'"></td>
			</tr>
		</table>
	</form>
</body>
</html>