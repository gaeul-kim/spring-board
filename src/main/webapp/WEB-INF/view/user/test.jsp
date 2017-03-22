<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
</head>
<body>
	<spring:form modelAttribute="member" method="post">

		<h4>
			<strong>회원가입</strong>
		</h4>
		<div class="clearfix">
			<div class="left">
				<spring:label path="id">아이디</spring:label>
			</div>
			<div class="left">
				<spring:input path="id" />
				<spring:errors path="id" />
			</div>
		</div>
		<div class="clearfix">
			<div class="left">
				<spring:label path="password">비밀번호</spring:label>
			</div>
			<div class="left">
				<spring:input path="password" />
				<spring:errors path="password" />
			</div>
		</div>
		<div class="clearfix">
			<div class="left">
				<spring:label path="email">이메일</spring:label>
			</div>
			<div class="left">
				<spring:input path="email" />
				<spring:errors path="email" />
			</div>
		</div>
		<div class="clearfix">
			<div class="left"></div>
			<div class="left"></div>
		</div>
		<input type="submit" value="업로드" />
	</spring:form>
</body>
</html>
