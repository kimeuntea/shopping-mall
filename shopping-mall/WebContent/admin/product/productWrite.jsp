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
	<form action="NonageServlet?command=admin_product_write" method="post" name="formm"
		enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>��ǰ��</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><select name="kind">
						<option value="1">����
						<option value="2">����
						<option value="3">�Ǽ��縮
						<option value="4">����
				</select></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="file" name="image"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="���" onclick="return writecheck()"> &nbsp;
					<input type="reset" value="���"></td>
			</tr>
		</table>
	</form>
</body>
</html>