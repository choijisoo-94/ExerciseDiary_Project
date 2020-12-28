<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<title>video</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<style>
body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}

.w3-quarter img {
	margin-bottom: -6px;
	cursor: pointer
}

.w3-quarter img:hover {
	opacity: 0.6;
	transition: 0.3s
}
</style>
<body class="w3-light-grey">

	<!-- Sidebar/menu -->
	<nav
		class="w3-sidebar w3-bar-block w3-black w3-animate-right w3-top w3-text-light-grey w3-large"
		style="z-index: 3; width: 250px; font-weight: bold; display: none; right: 0;"
		id="mySidebar">
		<a href="javascript:void()" onclick="w3_close()"
			class="w3-bar-item w3-button w3-center w3-padding-32">CLOSE</a> <a
			href="diat.jsp" onclick="w3_close()"
			class="w3-bar-item w3-button w3-center w3-padding-16">다이어트</a> <a
			href="muscle.jsp" onclick="w3_close()"
			class="w3-bar-item w3-button w3-center w3-padding-16">근육량 증가</a> <a
			href="bodyshape.jsp" onclick="w3_close()"
			class="w3-bar-item w3-button w3-center w3-padding-16">체형 교정</a>
	</nav>

	<!-- Top menu on small screens -->
	<header class="w3-container w3-top w3-white w3-xlarge w3-padding-16">
		<span class="w3-left w3-padding">Exercise Diary</span> <a
			href="javascript:void(0)" class="w3-right w3-button w3-white"
			onclick="w3_open()">☰</a>
	</header>

	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-animate-opacity" onclick="w3_close()"
		style="cursor: pointer" title="close side menu" id="myOverlay"></div>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main w3-content"
		style="max-width: 1600px; margin-top: 83px">

		<div class="w3-bar w3-border w3-black">
			<a href="video.jsp" class="w3-bar-item w3-button">Main</a> <a
				href="mypage.jsp"
				class="w3-bar-item w3-button w3-hover-none w3-text-grey w3-hover-text-white">회원가입</a>
			<a href="mypage2.jsp"
				class="w3-bar-item w3-button w3-hover-none w3-text-grey w3-hover-text-white">마이
				페이지</a> <a href="diary.jsp"
				class="w3-bar-item w3-button w3-hover-none w3-text-grey w3-hover-text-white">일기
				관리</a>
		</div>


<input class="w3-input w3-border w3-padding" type="text" placeholder="Search for names.." id="myInput" onkeyup="myFunction()">
  <ul class="w3-ul w3-margin-top" id="myUL">

  
  </ul>
</div>

<script>
function myFunction() {
  var input, filter, ul, li, a, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  ul = document.getElementById("myUL");
  li = ul.getElementsByTagName("li");
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
</script>

		<div class="w3-container">
			<table class="w3-table-all">
				<thead>
					<tr class="w3-light-grey w3-hover-red">
						<th>일기번호</th>
						<th>일기제목</th>
						<th>작성날짜</th>
					</tr>
				</thead>

				<c:forEach items="${sessionScope.daryAll}" var="data">
					<tr class="w3-hover-green">
						<td>${data.diaryNo}</td>
					</tr>
					<tr class="w3-hover-blue">
						<td>${data.diaryTitle}</td>
					</tr>
					<tr class="w3-hover-black">
						<td>${data.writeDate}</td>
					</tr>

				</c:forEach>

			</table>
			<p>
				<button class="w3-button w3-block w3-red">수정하기</button>
			</p>
			
			<p>
				<button class="w3-button w3-block w3-red" onclick = "location.href='newdiaryform.jsp'">새 글 작성</button>
			</p>
		</div>


		<!-- Footer -->
		<footer class="w3-container w3-padding-32 w3-grey">
			<div class="w3-row-padding">
				<div class="w3-third">
					<h3>INFO</h3>
					<p>
						Exercise diary 고객만족센터<br> 운영시간 : 평일 10 : 00 - 18 : 00<br>
						점심시간 : 평일 12 : 30 - 13: 30(주말, 공휴일 휴무)<br>
					<hr>
					대표 번호 : 0000 - 1111
					</p>
				</div>
			</div>
	</div>

	<script>
		function myFunction() {
			var x = document.getElementById("Demo");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}
	</script>
	</footer>

	<div class="w3-black w3-center w3-padding-24">
		Made by <a href="https://www.w3schools.com/w3css/default.asp"
			title="W3.CSS" target="_blank" class="w3-hover-opacity">박다영, 박민영,
			최지수</a>
	</div>

	<!-- End page content -->
	</div>

	<script>
		// Script to open and close sidebar
		function w3_open() {
			document.getElementById("mySidebar").style.display = "block";
			document.getElementById("myOverlay").style.display = "block";
		}

		function w3_close() {
			document.getElementById("mySidebar").style.display = "none";
			document.getElementById("myOverlay").style.display = "none";
		}

		// Modal Image Gallery
		function onClick(element) {
			document.getElementById("img01").src = element.src;
			document.getElementById("modal01").style.display = "block";
			var captionText = document.getElementById("caption");
			captionText.innerHTML = element.alt;
		}
	</script>


</body>
</html>