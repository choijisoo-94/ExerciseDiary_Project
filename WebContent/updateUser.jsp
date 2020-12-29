<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updateUser.jsp</title>
</head>
<body>
<center>
${sessionScope.successMsg}
<br><br><br>
<h3>회원정보 수정</h3>
<hr><p>

<form action="excerciseDiary" method="post">
	<input type="hidden" name="command" value="updateUser">
	<input type="hidden" name="userId" value="${id.userId}">
	 
	<table border="1">
		<tr>
			<td>id</td><td>${id.userId}</td>
		</tr>
		<tr>	
			<td>pw</td><td>${id.userPassword}</td>
	 	</tr>
	 	<tr>
	 		<td>name</td><td>${id.userName}</td>
		</tr>
	 	<tr>
	 		<td>gender</td><td>${id.userGender}</td>
		</tr>
		<tr>
	 		<td>age</td><td>${id.userAge}</td>
		</tr>
		<tr>
	 		<td>height</td><td>${id.userHeight}</td>
		</tr>
		<tr>
	 		<td>weight</td><td>${id.userWeight}</td>
		</tr>
		<tr>
			<td>purpose</td><td><select id="purpose" name="purpose">
							    <option value="다이어트">다이어트</option>
							    <option value="근육량 증가">근육량증가</option>
							    <option value="체형관리">체형관리</option>
							  </select></td>
		</tr>
	 	<tr align="center">
	 		<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<input type="button" value="취소" onclick="location.href='myPage.jsp'"></td>
	 	</tr>
	</table>
	</form>

<br><br><br>

</center>
</body>
</html>