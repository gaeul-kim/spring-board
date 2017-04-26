<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/include/header.jspf"%>
<title>SampleProject - 로그인</title>
</head>
<body>
	<div class="container">
		<header>
            <h1><a href="/">SampleProject</a></h1>
		</header>
		<section class="content">
			<%@ include file="/WEB-INF/view/include/navigation.jsp"%>
			<main>
			<div class="box-small">
				<form name="loginForm" action="/member/loginProcess" method='POST'>
					<div class="form-box">
						<div class="input-box">
							<input type='text' id="memberId" name='memberId'
								value="${memberId}" class="form-control" placeholder="아이디">
						</div>
						<div class="input-box">
							<input type="password" id="memberPassword" name="memberPassword"
								value="" class="form-control" placeholder="비밀번호">
						</div>
					</div>
					<div class="info">
						<c:if test="${not empty securityExceptionMessage }">
							<p class="errorMessage">로그인 정보를 확인하세요</p>
						</c:if>
					</div>
					<button class="btn btn-default btn-block">로그인</button>
					<input type="hidden" name="loginRedirect" value="${loginRedirect}" />
				</form>
			</div>
			</main>
		</section>
		<footer>
			<a href="#">홈페이지</a>
		</footer>
	</div>
</body>
</html>