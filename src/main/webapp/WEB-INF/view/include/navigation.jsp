<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav>
	<div>
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
	</div>
	<br />
	<div>
		게시판
		<ul>
			<li><a href="/articles/notice">notice</a></li>
			<li><a href="/articles/free">free</a></li>
			<li><a href="/articles/qna">qna</a></li>
<!-- 			<li><a href="/articles/market">market</a></li> -->
		</ul>
	</div>

</nav>

