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
 <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">
<title>SampleProject - 메인</title>
</head>
<body>
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.memberName" />님 반갑습니다.
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<form name="loginForm" action="/j_spring_security_check" method='POST'>

			<div>
				<span><input type="text" id="memberId" name='memberId'
					value="" class="form-control" placeholder="아이디" /></span> <span><input
					type="password" id="memberPassword" name="memberPassword" value=""
					class="form-control" placeholder="비밀번호"></span> <span><input
					name="submit" type="submit" value="Login" /></span>
			</div>
			<input type="hidden" name="loginRedirect" value="${loginRedirect}" />

		</form>
	</sec:authorize>
	<br />
	<hr />

	게시판
	<ul>
		<li><a href="/articles/notice">notice</a></li>
		<li><a href="/articles/free">free</a></li>
		<li><a href="/articles/qna">qna</a></li>
		<li><a href="/articles/market">market</a></li>
	</ul>


	회원관리
	<ul>
		<sec:authorize access="isAnonymous()">
			<li><a href="/member/register">register</a></li>
			<li><a href="/member/login">login</a></li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<li><a href="/j_spring_security_logout">logout</a></li>
		</sec:authorize>
	</ul>



</body>
</html>