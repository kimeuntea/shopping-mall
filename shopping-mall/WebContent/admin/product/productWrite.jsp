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
	<h3>상품등록</h3>
	<form action="NonageServlet?command=admin_product_write" method="post" name="formm"
		enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>상품명</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>종류</td>
				<td><select name="kind">
						<option value="1">상위
						<option value="2">하위
						<option value="3">악세사리
						<option value="4">세일
				</select></td>
			</tr>
			<tr>
				<td>설명</td>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><input type="file" name="image"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록" onclick="return writecheck()"> &nbsp;
					<input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>