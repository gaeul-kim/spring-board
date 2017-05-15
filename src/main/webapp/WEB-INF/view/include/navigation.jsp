<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav>
	<ul>
		<li>회원관리</li>
		<c:choose>
			<c:when test="${not isLogin }">
				<li><a href="/member/register">register</a></li>
				<li><a href="/member/login">login</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="/j_spring_security_logout">logout</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
	<br />
	<ul>
		<li>게시판</li>
		<li><a href="/articles/notice">notice</a></li>
		<li><a href="/articles/free">free</a></li>
		<li><a href="/articles/qna">qna</a></li>
	</ul>
</nav>

