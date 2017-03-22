<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
</head>
<body>
	<form:form modelAttribute="user" autocomplete="off">

		<h4>
			<strong>회원가입</strong>
		</h4>
		<div class="clearfix">
			<div class="left">
				<form:label path="id">아이디</form:label>
			</div>
			<div class="left">
				<form:input path="id" />
				<form:errors path="id" />
			</div>
		</div>
		<div class="clearfix">
			<div class="left">
				<form:label path="password">비밀번호</form:label>
			</div>
			<div class="left">
				<form:input path="password" />
				<form:errors path="password" />
			</div>
		</div>
		<div class="clearfix">
			<div class="left">
				<form:label path="email">이메일</form:label>
			</div>
			<div class="left">
				<form:input path="email" />
				<form:errors path="email" />
			</div>
		</div>
		<div class="clearfix">
			<div class="left"></div>
			<div class="left"></div>
		</div>
		<input type="submit" value="업로드" />
	</form:form>
</body>
</html>
