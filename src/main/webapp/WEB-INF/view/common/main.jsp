<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/include/header.jspf" %>
<title>SampleProject - 메인</title>
</head>
<body>
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.memberName" />님 반갑습니다.
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<form name="loginForm" action="/member/loginProcess" method='POST'>

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