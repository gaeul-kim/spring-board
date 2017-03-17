<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<script src="/js/jquery-3.1.1.min.js"></script>
</head>
<body>
	<div>
		<input type="text" placeholder="아이디" id="userId" name="userId">
	</div>
	<div>
		<input type="password" placeholder="비밀번호" id="userPassword"
			name="userPassword">
	</div>
	<div>
		<input type="password" placeholder="비밀번호 확인" id="checkPassword"
			name="checkPassword">
	</div>
	<div>
		<input type="text" placeholder="이름" id="userName" name="userName">
	</div>
	<div>
		<input type="email" placeholder="이메일" id="userEmail" name="userEmail">
	</div>
	<div>
		<input type="text" placeholder="별명" id="userNickname"
			name="userNickname">
	</div>
</body>
</html>
