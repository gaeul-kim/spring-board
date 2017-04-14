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
	<a href="/articles/qna">qna</a>
	<a href="/articles/free">free</a>
	<a href="/articles/notice">notice</a>
	<a href="/articles/market">market</a>
	<a href="/member/register">register</a>
	<sec:authorize access="isAnonymous()">
		<a href="/member/login">login</a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<a href="/j_spring_security_logout">logout</a>
	</sec:authorize>
</body>
</html>