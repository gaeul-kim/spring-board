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
<title>SampleProject - ${articleCategory}</title>
</head>
<body>

	<div class="container">
		<div class="content">
			<table class="table table-hover">
				<caption>${articleCategory }</caption>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>이름</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty articles}">
							<tr>
								<td colspan="5" class="text-center">등록된 글이 없습니다.</td>
							</tr>
						</c:when>
						<c:when test="${!empty articles }">

							<c:forEach items="${articles}" var="article">
								<tr>
									<td>${article.articleId }</td>
									<td><a href="/article/${article.articleId }">${article.articleTitle }</a></td>
									<td>${article.articleWriter }</td>
									<td>${article.articleInsertDate }</td>
									<td>${article.articleHit}</td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
			</table>
			<div class="text-center">
				<a class="btn btn-default pull-left" href="/">메인</a>
				<ul class="pagination">
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">6</a></li>
					<li><a href="#">7</a></li>
					<li><a href="#">8</a></li>
					<li><a href="#">9</a></li>
					<li><a href="#">10</a></li>
				</ul>
				<a class="btn btn-default pull-right"
					href="/articles/${articleCategory}/write">글 작성</a>
			</div>

		</div>
	</div>
</body>
</html>