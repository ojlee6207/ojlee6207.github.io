<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%-- errorPage="error500.jsp" --%>
<%-- 여러 개를 import 시 컴마(,)로 구분 --%>
<%@ page import="java.util.ArrayList, java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02 Directive Page</title>
</head>
<body>
	<h1>page 지시어</h1>
	<%
		ArrayList<String> list = new ArrayList<>();
		// 0번 위치에 "Servlet"
		list.add("Servlet");
		// 1번 위치에 JSP
		list.add("JSP");
		
		Date today = new Date();
	%>
	
	<p>
		리스트의 길이 : <%= list.size() %><br>
		0번 index 값 : <%= list.get(0) %> <br>
		1번 index 값 : <%= list.get(1) %>  <br>
		현재 날짜 및 시간 : <%= today %> <br>
	</p>
</body>
</html>