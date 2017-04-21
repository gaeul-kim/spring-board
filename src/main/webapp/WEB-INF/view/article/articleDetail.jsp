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
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">
<!-- jQuery -->
<script src="/js/jquery-3.1.1.min.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/bootstrap/css//bootstrap-theme.min.css">
<script src="/bootstrap/js/bootstrap.min.js"></script>
<!--  register -->
<link rel="stylesheet" href="/css/article.css">
<!-- include summernote css/js-->
<link href="/summernote/summernote.css" rel="stylesheet">
<script src="/summernote/summernote.js"></script>

<!-- include summernote-ko-KR -->
<script src="/summernote/lang/summernote-ko-KR.js"></script>
<title>SampleProject - ${article.articleTitle }</title>
</head>
<body>

	<div class="container">
		<div class="content">

			<table class="table table-striped">
				<caption>${article.articleCategory }</caption>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>이름</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tr>
					<td>${article.articleId }</td>
					<td>${article.articleTitle }</td>
					<td>${article.articleWriterName }</td>
					<td>${article.articleInsertDate }</td>
					<td>${article.articleHit}</td>
				</tr>
				<tr>
					<td colspan="5">${article.articleContent }</td>
				</tr>

			</table>
<%-- 			<a class="btn btn-default pull-right"
				href="/articles/${article.articleCategory}">목록</a> <a
				class="btn btn-default pull-left" href="/">메인</a> --%>
		</div>
	</div>
</body>
</html>