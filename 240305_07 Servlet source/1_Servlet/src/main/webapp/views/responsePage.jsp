<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POST 요청에 대한 응답페이지(jsp)</title>
<style>
	h2 {color:red}
	#name {color:orange}
	#gender {color:yellow}
	#age {color:green}
	#address {color:blue}
	#height {color:navy}
	#food {color:purple}
</style>
</head>
<body>
	<!-- HTML 주석 -->
	<%-- JSP 주석 --%>
	
	<!-- 아래에 자바 코드 가능 -->
	<%
		
		// System.out.println("hi? jsp!!");
		// 스크립트릿(scriptlet) : html 문서 내에 자바코드를 사용할 수 있는 영역
		//						 실행하고자 하는 자바코드
		
		// request.getAttribute("키값") : Object (해당 밸류 값)
		String name = (String)request.getAttribute("name");
		String gender = (String)request.getAttribute("gender");
		int age = (int)request.getAttribute("age");
		String address = (String)request.getAttribute("address");
		double height = (double)request.getAttribute("height");
		String[] foods = (String[])request.getAttribute("foods");		
	%>
	<h2>간단한 정보 응답페이지 - POST</h2>
	<!-- 변수 값을 출력하고자 할 때는 첫번째 % 뒤에 = 추가하기 -->
	<span id="name"><%= name %></span>님의 정보 <br>
	성별은
		<% if(gender != null) { %>
			<span id="gender"><%= gender %></span> 입니다. <br> <!-- 성별 선택 시 -->
		<% } else { %>
			선택하지 않았습니다. <br> <!-- 성별 선택 안 했을 경우 -->
		<% } %>
	나이는 <span id="age"><%= age %></span>살 입니다. <br>
	거주지는 <span id="address"><%= address %></span>입니다.<br>
	키는 <span id="height"><%= height %></span>cm 입니다. <br>
	좋아하는 음식은
		<% if(foods == null) { %>
			없습니다.<br> <!-- 선택하지 않았을 경우 -->
		<% } else { %>
			<ol>
				<% for(String food : foods) { %>
					<li><%= food %></li>
				<% } %>
			</ol>
		<% } %>
</body>
</html>