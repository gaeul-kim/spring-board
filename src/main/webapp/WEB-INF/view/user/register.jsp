<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<script src="/js/jquery-3.1.1.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/user_register.css">
</head>
<body>
	<div class="container">
		<div class="content">
			<form class="form-signUp" action="register" method="post">
				<div class="form-box">
					<div class="input-box">
						<input class="form-control" type="text" placeholder="아이디"
							id="user_id" name="user_id" maxlength="15">
						<div class="info"></div>
					</div>
					<div class="input-box">
						<input class="form-control" type="password" placeholder="비밀번호"
							id="user_password" name="user_password" maxlength="15">
						<div class="info"></div>
					</div>
					<div class="input-box">
						<input class="form-control" type="password" placeholder="비밀번호 확인"
							id="check_password" name="check_password" maxlength="15">
						<div class="info"></div>
					</div>
				</div>
				<div class="form-box">
					<div class="input-box">
						<input class="form-control" type="text" placeholder="이름"
							id="user_name" name="user_name" maxlength="10">
						<div class="info"></div>
					</div>
					<div class="input-box">
						<input class="form-control" type="text" placeholder="이메일"
							id="user_email" name="user_email" maxlength="30">
						<div class="info"></div>
					</div>
				</div>
				<button class="btn btn-primary btn-block" id="signUp" name="signUp">회원가입</button>
			</form>
		</div>
	</div>
	<script src="/js/user_register.js"></script>
</body>
</html>
