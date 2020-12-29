<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>vList.jsp</title>
</head>
<body>
<body>
	<br>
	<div align="right">
	
	<a href="excerciseDiary?command=getUser&userId=${sessionScope.id}">마이페이지</a>
	</div>
	<center>
	${sessionScope.successMsg}
		<h3>운동 영상 list</h3>
		<hr>
		<!-- <form action="excercise" method="post">
			<input type="hidden" name="command" value="purpose"> 
			<select id="purpose" name="purpose">
				<option value="diet">다이어트</option>
				<option value="muscle">근육량증가</option>
				<option value="manage">체형관리</option>
			</select> <input type="submit" value="검색">
		</form> -->
		<p>
		<hr>
		<p>
		<table border="1">
			<tr>
				<th>프로그램 번호</th>
				<th>플레이리스트</th>
				<th>유튜브 url</th>
				<th>채널</th>
				<th>운동 목적</th>
			</tr>
			<c:forEach items="${sessionScope.vListPurpose}" var="data">
				<tr>
					<td>${data.programNo}</td>
					<td>${data.playlist}</td>
					<td><a href='${data.youtubeUrl}'>${data.youtubeUrl}</a></td>
					<td>${data.channel.getChannel()}</td>
					<td>${data.purpose.getPurpose()}</td>
					<%-- <td><a
						href="probono?command=activist&activistId=${data.activistId}">${data.activistId}</a></td>
					<td><a href="receiveDetail.jsp" target="_blank">${data.receiveId}</a></td>
					<td>${data.projectContent}</td> --%>
				</tr>
			</c:forEach>
		</table>
		<br> <br> <br>
	</center>
</body>
</body>
</html>