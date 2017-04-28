<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/include/header.jspf"%>
<title>SampleProject - ${article.articleTitle }</title>
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
			<div class="control">
				<c:if test="${isAdmin or loginId eq article.articleWriter }">
					<a class="btn btn-default" href="/article/delete/${articleId}">삭제</a>
					<a class="btn btn-default" href="/article/edit/${articleId}">수정</a> 
<!-- 					<a class="btn btn-default" id="btn-delete">삭제</a>
					<a class="btn btn-default" id="btn-edit">수정</a> -->
				</c:if>
			</div>
			<ul class="article-list">
				<li class="article-wrap">
					<div class="article-title-wrap">
						<div>
							<input type="hidden" id="articleId" value="${article.articleId }" />
							<span>#${article.articleId }</span> <span class="article-info">
								<span>${article.articleWriterName }</span> <span
								class="articleInsertDate" title="${article.articleInsertDate }"></span>
								<span>${article.articleHit}hit</span>
							</span>
						</div>
						<div>${article.articleTitle }</div>
					</div>
					<div class="article-info-wrap">
						<div>${article.articleWriterName }</div>
						<div>
							<span class="articleInsertDate"
								title="${article.articleInsertDate }"></span><span
								class="text-right">${article.articleHit}hit</span>
						</div>
					</div>
				</li>
				<li class="article-wrap">${article.articleContent }</li>
			</ul>
			</main>
		</section>
		<footer>
			<a href="#">홈페이지</a>
		</footer>
	</div>
	<script>
		$(document).ready(function() {
			$.fn.setDate = function() {
				return this.each(function() {
					var str = date_calculator($(this).attr('title'));
					$(this).text(str);
				});
			};
			$('.articleInsertDate').setDate();
		});
	</script>
</body>
</html>