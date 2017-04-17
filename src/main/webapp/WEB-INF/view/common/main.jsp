<%@page import="sampleProject.member.domain.Member"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>


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
<title>SampleProject - 메인</title>
</head>
<body>
	<%
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    Object principal = auth.getPrincipal();
	    String name = "";

	    if (principal != null && principal instanceof Member) {
	        name = ((Member) principal).getMemberName();
	    }
	%>
	<sec:authorize access="isAuthenticated()">
		<%=name%> 님 반갑습니다.
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<form name="loginForm" action="/j_spring_security_check" method='POST'>

			<div>
				<span>사용자:<input type='text' id="memberId" name='memberId'
					value=""></span> <span>비밀번호:<input type="password"
					id="memberPassword" name="memberPassword" value=""></span> <span><input
					name="submit" type="submit" value="Login" /></span>
			</div>
			<input type="hidden" name="loginRedirect" value="${loginRedirect}" />

		</form>
		<c:if test="${not empty param.fail }">
			<p>Your login attempt was not successful, try again.</p>
			<p>Reason:
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }</p>
			<c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION" />
		</c:if>
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