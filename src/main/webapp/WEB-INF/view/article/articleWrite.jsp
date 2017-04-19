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
 <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">
<!-- jQuery -->
<script src="/js/jquery-3.1.1.min.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/bootstrap/css//bootstrap-theme.min.css">
<script src="/bootstrap/js/bootstrap.min.js"></script>
<!--  register -->
<link rel="stylesheet" href="/css/input_form.css">
<!-- include summernote css/js-->
<link href="/summernote/summernote.css" rel="stylesheet">
<script src="/summernote/summernote.js"></script>

<!-- include summernote-ko-KR -->
<script src="/summernote/lang/summernote-ko-KR.js"></script>

<title>SampleProject - 글작성</title>
</head>
<body>

	<div class="container">
		<div class="content">
			<form:form modelAttribute="article" mthod="post" autocomplete="false">
				<input type="hidden" name="articleWriter"
					value="<sec:authentication property="principal.memberId" />" />
				<div class="form-box">
					<c:choose>

						<c:when test="${!empty articleTags }">
							<div class="input-box">
								<select name="articleTag" class="form-control">
									<c:forEach items="${articleTags}" var="articleTag">
										<option>${articleTag }</option>
									</c:forEach>
								</select>
							</div>
						</c:when>

					</c:choose>
					<div class="input-box">

						<form:input path="articleTitle" class="form-control"
							placeholder="제목" maxlength="80" />
					</div>

				</div>

				<div class="form-box">
					<div class="input-box">
						<form:textarea path="articleContent" class="form-control"
							placeholder="내용" rows="10" wrap="hard" />
					</div>
				</div>
				<button class="btn btn-primary btn-block" id="btn-register">작성</button>
			</form:form>
			<a href="/">메인</a>
		</div>
	</div>
</body>
</html>