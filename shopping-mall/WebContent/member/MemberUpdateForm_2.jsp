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
		<h1 align="center">ȸ����������</h1>
		<table align="center">
			<tr>
				<td>
				<form action="NonageServlet?command=MemberUpdate" name="frm" method="post" >
					<table border="1">
						<tr>
							<td>���̵�</td>
							<td><input type="hidden" name="id" value="${bean.id}"> ${bean.id}</td>
						</tr>
						<tr>
							<td>��ȣ</td>
							<td><input type="password" name="pwd" value=""></td>
						</tr>
						<tr>
							<td>��ȣȮ��</td>
							<td><input type="password" name="pwd_1" value=""></td>
						</tr>
						<tr>
							<td>�̸�</td>
							<td>${bean.name}</td>
						</tr>
						<tr>
							<td>�̸���</td>
							<td><input type="text" name="email" value="${bean.email}"></td>
						</tr>
						<tr>
							<td>�����ȣ</td>
							<td><input type="text" name="zipcode" value="${bean.zipcode}" readonly="readonly">
							<input type="button" value="����ã��" onclick="zipcode()"></td>
						</tr>
						<tr>
							<td>�ּ�</td>
							<td><input type="text" name="address" value="${bean.address}"></td>
						</tr>
						<tr>
							<td>��ȭ��ȣ</td>
							<td><input type="text" name="phone" value="${bean.phone}"></td>
						</tr>
						<tr>
						<td colspan="2" align="center">
						<input type="submit" value="����" onclick="return formcheck()" > &nbsp;&nbsp; 
					  <input type="reset" value="�ٽ��ۼ�"></td></tr>
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