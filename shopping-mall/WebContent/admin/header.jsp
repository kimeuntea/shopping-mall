<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="admin/member/memberlist.js"></script> 
<script type="text/javascript" src="admin/product/product_list.js"></script> 
<script type="text/javascript" src="admin/order/order.js"></script> 
</head>
<body>
<div align="center">
	<c:choose>
		<c:when test="${adminid==null}">
			<a href="NonageServlet?command=admin_LoginForm">�α���</a>
		</c:when>
		<c:otherwise>
    ${adminid} �����ڴ�  / <a href="NonageServlet?command=Logout">�α׾ƿ�</a>
	</c:otherwise>
	</c:choose>
	������ ���������
	</div>
</body>
</html>