<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div align="center" id="wrap">
	<%@ include file="../header.jsp" %>
		<br>
		<table align="center">
			<tr>
				<td align="left">
					<table>
						<tr>
							<td><%@ include file="sub_menu.html" %></td>
						</tr>
					</table>
        
				</td>
                
				<td>회원가입전 동의 <br><br>
				<form action="NonageServlet?command=JoinForm" name="frm" method="post">
				<input type="radio" value="동의" name="radio" checked>동의
				<input type="radio" name="radio" value="동의안함" checked>동의안함
				<br>
				<input type="submit" value="확인" onclick="return RegisterCheck()">
				<input type="button" value="취소"> 
				</form>
				</td>
			</tr>
		</table>
		<br>
		</article>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>