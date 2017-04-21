<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">
<title>SampleProject - 회원가입</title>
<!-- jQuery -->
<script src="/js/jquery-3.1.1.min.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/bootstrap/css//bootstrap-theme.min.css">
<script src="/bootstrap/js/bootstrap.min.js"></script>

<!--  register -->
<link rel="stylesheet" href="/css/input_form.css">
</head>
<body>
	<div class="container">
		<div class="content">
			<form:form modelAttribute="member" method="post" autocomplete="false">
				<div class="form-box">
					<div class="input-box">
						<form:input path="memberId" class="form-control" placeholder="아이디"
							maxlength="15" />
						<div class="info">
							<form:errors path="memberId" cssClass="errorMessage" />
						</div>

					</div>
					<div class="input-box">
						<form:password path="memberPassword" class="form-control"
							placeholder="비밀번호" maxlength="15" />
						<div class="info">
							<form:errors path="memberPassword" cssClass="errorMessage" />
						</div>
					</div>
					<div class="input-box">
						<form:password path="confirmPassword" class="form-control"
							placeholder="비밀번호 확인" maxlength="15" />
						<div class="info">
							<form:errors path="confirmPassword" cssClass="errorMessage" />
						</div>
					</div>
				</div>
				<div class="form-box">
					<div class="input-box">
						<form:input path="memberName" class="form-control"
							placeholder="이름" maxlength="10" />
						<div class="info">
							<form:errors path="memberName" cssClass="errorMessage" />
						</div>
					</div>
					<div class="input-box">
						<form:input path="memberEmail" class="form-control"
							placeholder="이메일 (선택)" maxlength="30" />
						<div class="info">
							<form:errors path="memberEmail" cssClass="errorMessage" />
						</div>
					</div>
				</div>
				<button class="btn btn-default btn-block" id="btn-register">회원가입</button>
<!-- 				<a class="btn btn-default btn-block"  href="/member/login">로그인</a>
				<a class="btn btn-default btn-block"  href="/">메인</a> -->
			</form:form>
		</div>
	</div>
			<script src="/js/user_register.js"></script>
</body>
</html>
