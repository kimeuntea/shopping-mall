<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
function idcheck()
{
	var id = document.frmm.id.value;
	if (id.length <= 4 || id.length > 9) 
	{
		alert("아이디를 4자이상 9자이하 입력해주세요");
		document.frmm.id.focus();
		return false;
	}
}

function idok()
{
	  opener.frm.id.value="${id}"; 
	  opener.frm.reid.value="${id}";
	  self.close();
}
function cancel()
{
	self.close();
}
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>아이디 중복체크</h1>
	<br>
	<form action="NonageServlet?command=IdCheckForm" name="frmm" method="post">
		<input type="text" name="id" value="${id}"> &nbsp; <input
			type="submit" value="중복체크" onclick="return idcheck()">
		<c:if test="${result == -1}">
		<br>
			<input type="button" value="확인" onclick="idok()">
		</c:if>
		<input type="button" value="취소" onclick="cancel()"> ${message}
	</form>
</body>
</html>