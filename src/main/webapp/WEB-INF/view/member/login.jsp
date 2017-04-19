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
<meta charset="UTF-8">
<!-- jQuery -->
<script src="/js/jquery-3.1.1.min.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/bootstrap/css//bootstrap-theme.min.css">
<script src="/bootstrap/js/bootstrap.min.js"></script>
<!--  register -->
<link rel="stylesheet" href="/css/input_form.css">
<!-- include summernote css/js-->
<link href="/summernote/summernote.css" rel="stylesheet">
<script src="/summernote/summernote.js"></script>

<!-- include summernote-ko-KR -->
<script src="/summernote/lang/summernote-ko-KR.js"></script>

<title>SampleProject - 로그인</title>
</head>
<body onload='document.f.j_username.focus();'>
<body>


	<div class="container">
		<div class="content">

			<form name="loginForm" action="/j_spring_security_check"
				method='POST'>




				<div class="form-box">
					<div class="input-box">

						<input type='text' id="memberId" name='memberId'
							value="${loginId}" class="form-control" placeholder="아이디">
					</div>
					<div class="input-box">


						<input type="password" id="memberPassword" name="memberPassword"
							value="" class="form-control" placeholder="비밀번호">
					</div>
				</div>

				<button class="btn btn-primary btn-block">Login</button>
			</form>

			<c:if test="${not empty securityExceptionMessage }">
				<p>Your login attempt was not successful, try again.</p>
				<p>
					<font color="red">${securityExceptionMessage}</font>
				</p>
			</c:if>
		</div>
	</div>


	<input type="hidden" name="loginRedirect" value="${loginRedirect}" />
</body>
</html>