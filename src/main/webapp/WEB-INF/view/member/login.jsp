<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SampleProject - 로그인</title>
</head>
<body onload='document.f.j_username.focus();'>
<body>
	<form name="loginForm" action="/j_spring_security_check" method='POST'>
		<div>
			사용자:<input type='text' id="memberId" name='memberId'
				value="${loginId}">
		</div>
		<div>
			비밀번호:<input type="password" id="memberPassword" name="memberPassword"
				value="">
		</div>
		<input name="submit" type="submit" value="Login" />
	</form>

	<c:if test="${not empty securityExceptionMessage }">
		<p>Your login attempt was not successful, try again.</p>
		<p>
			<font color="red">${securityExceptionMessage}</font>
		</p>
	</c:if>
	<input type="hidden" name="loginRedirect" value="${loginRedirect}" />
</body>
</html>