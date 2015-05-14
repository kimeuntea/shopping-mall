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
		<table border="1" align="center">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>답변유무</th>
				<th>작성일</th>
			</tr>
			<c:forEach items="${qnalist}" var="qnalist">
				<tr>
					<td>${qnalist.qseq}</td>
					<td><a
						href="NonageServlet?command=qnadetail&qseq=${qnalist.qseq}">${qnalist.subject}</a>
					</td>
					<td>${qnalist.id}</td>
					<td><c:choose>
							<c:when test='${qnalist.rep =="1"}'>
					답변미완료
					</c:when>
							<c:otherwise>
					답변완료
					</c:otherwise>
						</c:choose></td>
					<td><fmt:formatDate value="${qnalist.indate}" type="date"/></td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>