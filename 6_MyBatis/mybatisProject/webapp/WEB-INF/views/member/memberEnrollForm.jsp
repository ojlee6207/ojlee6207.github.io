<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyBatis 회원가입</title>
</head>
<body>
	<jsp:include page = "../common/menubar.jsp" />
	<div class="outer">
		<br><h1 align="center">회원가입</h1><br>
		<form action="insert.me" method="post">
			<table align="center">
				<tr>
					<td>* 아이디</td>
					<td>
						<input type="text" name="userId" required>
					</td>
				</tr>
				<tr>
					<td>* 패스워드</td>
					<td>
						<input type="password" name="userPwd" required>
					</td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td>
						<input type="text" name="userName" required>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;이메일</td>
					<td>
						<input type="email" name="email">
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;생년월일</td>
					<td>
						<input type="text" name="birthday" placeholder="yymmdd(6자리)">
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;성별</td>
					<td align="center">
						<input type="radio" name="gender" value="M"> 남
						<input type="radio" name="gender" value="F"> 여
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;연락처</td>
					<td>
						<input type="text" name="phone" placeholder="-포함">
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;주소</td>
					<td>
						<input type="text" name="address">
					</td>
				</tr>
			</table>
			<br>
			<div align="center">
				<button type="reset">초기화</button>
				<button type="submit">회원가입</button>
			</div>
		</form>
	</div>
	
	
</body>
</html>