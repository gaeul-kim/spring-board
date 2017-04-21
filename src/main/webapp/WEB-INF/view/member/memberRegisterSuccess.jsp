<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
    uri="http://www.springframework.org/security/tags"%><!DOCTYPE html>
<html>
<head>
<!-- jQuery -->
<script src="/js/jquery-3.1.1.min.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/bootstrap/css//bootstrap-theme.min.css">
<script src="/bootstrap/js/bootstrap.min.js"></script>

<!--  register -->
<link rel="stylesheet" href="/css/input_form.css">
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">
<title>success</title>
</head>
<body>
	<div class="container">
		<div class="content">
			<div>회원가입이 정상적으로 완료되었습니다</div>
			<a class="btn btn-default btn-block" href="/member/login">로그인</a> 
			<a class="btn btn-default btn-block" href="/">메인</a>
		</div>
	</div>
</body>
</html>