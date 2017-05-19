<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/include/header.jspf"%>
<title>SampleProject - 메인</title>
</head>
<body>
	<div class="container">
		<header>
			<h1>
				<a href="/">SampleProject</a>
			</h1>
		</header>
		<section class="content">
			<%@ include file="/WEB-INF/view/include/navigation.jsp"%>
			<main>
			<div class="text-center">
				<img style="width: 50%;" src="/img/computer.png" />
			</div>
			</main>
		</section>
		<footer>
			<a href="#">홈페이지</a>
		</footer>
	</div>
</body>
</html>