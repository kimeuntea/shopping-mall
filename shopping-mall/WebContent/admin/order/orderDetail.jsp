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
	<h3 align="center">주문리스트</h3>
	<form action="" name="formm">
		<table border="1" align="center">
			<tr>
				<td>주문번호</td>
				<td>${order.oseq}</td>
			</tr>
			<tr>
				<td>주문상세번호</td>
				<td>${order.odseq}<input type="hidden" name="odseq" value="${order.odseq}"> </td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>${order.id}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${order.mname}</td>
			</tr>
			<tr>
				<td>상품명</td>
				<td>${order.pname}</td>
			</tr>
			<tr>
				<td>주문일자</td>
				<td><fmt:formatDate value="${order.indate}" type="date" /></td>
			</tr>
			<tr>
				<td>수량</td>
				<td>${order.quantity}</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${order.address}</td>
			</tr>
			<tr>
				<td>가격</td>
				<td><fmt:formatNumber value="${order.price2*order.quantity}"
						type="currency" /></td>
			</tr>
			<tr>
				<td>처리</td>
				<td><c:choose>
						<c:when test="${order.result=='1'}">
					미처리
					</c:when>
						<c:otherwise>
					처리완료
					</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td colspan=""><input type="button" value="목록"
					onclick="location.href='NonageServlet?command=admin_order_list'">
					&nbsp;<input type="button" name="result" value="처리" onclick="go_result()"></td>
			</tr>
		</table>
	</form>
	<%@include file="../footer.jsp"%>
</body>
</html>