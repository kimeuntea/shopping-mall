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
		<%@include file="sub_menu.jsp"%>
		<table border="1">
			<tr>
				<th>�ֹ���ȣ</th>
				<th>�̸�</th>
				<th>�ּ�</th>
				<th>�ֹ�����</th>
			</tr>

			<tr>
				<td>${orderdetail.oseq}</td>
				<td>${orderdetail.mname }</td>
				<td>${orderdetail.zipNum}</td>
				<td>${orderdetail.indate}</td>
			</tr>
			<tr>
				<th>�ֹ��󼼹�ȣ</th>
				<th>��ǰ��</th>
				<th>����</th>
				<th>�ֹ�����</th>
			</tr>
			<c:forEach items="${orderlist}" var="orderlist">
				<tr>
					<td>${orderlist.odseq}</td>
					<td>${orderlist.pname}</td>
					<td>${orderlist.price2}</td>
					<td>${orderlist.indate}</td>
					<td><c:choose>
							<c:when test='${orderlist.result=="1"}'>
						������
						</c:when>
							<c:otherwise>
						ó���Ϸ�
						</c:otherwise>
						</c:choose>
					<td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="button" value="���ΰ���ϱ�"
					onclick="location.href='NonageServlet?command=index'"></td>
			</tr>
		</table>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>