<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.common.JDBCTemplate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Project</title>
</head>
<body>
	<%-- 
		* 회원 서비스
			   | C(Insert) | R(Select) | U(Update) | D(Delete)
		=====================================================
		로그인   |			|	  O		|			|
		회원가입 	   	 O		|	  		|			|	
		마이페이지 				|	  O		|			|
		회원정보변경     		|			|	  O		|
		회원탈퇴				|			|			|	  O
		중복 체크 (ID) 		|	  O		|			|
		================================
		
		* 공지사항 서비스
			- 공지사항 목록 조회 : R
					 상세 조회 : R
					 작성		 : C
					 수정		 : U
					 삭제		 : D 
	 --%>
	 <% JDBCTemplate.getConnection(); %>
	 <%@ include file="views/common/menubar.jsp" %>
</body>
</html>