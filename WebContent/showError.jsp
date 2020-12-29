<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<% String url = application.getContextPath() + "/"; %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>error</title>
</head>

<body>
<br><br><br>

	<center>
	<h2>에러발생</h2>
		<h3>${sessionScope.errorMsg}</h3>
			
		<br><br><br>
		<a href="${pageContext.request.contextPath}/userLogin.html">로그인 화면으로 이동하기</a>
	</center>
	
</body>
</html>