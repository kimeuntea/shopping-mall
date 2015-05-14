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
	<form action="NonageServlet?command=admin_modify" method="post" name="formm" 
	enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>상품명</td>
				<td><input type="text" name="name" value="${product.name}">
					<input type="hidden" name="pseq" value="${product.pseq}">
					<input type="hidden" name="nomakeimg" value="${product.image}"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price2" value="${product.price2}"></td>
			</tr>
			<tr>
				<td>종류</td>
				<td><select><c:forEach items="${kindlist}" varStatus="status"
						var="kind">
						<c:choose>
							<c:when test="${status.count == product.kind}">
                              <option value="${product.kind}" selected="selected">${kind}
							</c:when>
							<c:otherwise>
							<option value="${product.kind}">${kind}
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>설명</td>
				<td><input type="text" name="content" value="${product.content}"></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><input type="file" name="img"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정완료"> &nbsp; <input type="button"
					value="목록"
					onclick="location.href='NonageServlet?command=admin_product_list'"></td>
			</tr>
		</table>
	</form>
</body>
</html>