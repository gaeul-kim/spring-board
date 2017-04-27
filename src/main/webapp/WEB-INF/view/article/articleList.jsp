<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/include/header.jspf"%>
<title>SampleProject - ${articleCategory}</title>
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
			<main> <input type="hidden" id="articleCategory" value="${articleCategory }" />
			<div class="control">
				<a class="btn btn-default"
					href="/articles/${articleCategory}/write">글쓰기</a>
			</div>
			<ul class="article-list">
							<c:choose>
					<c:when test="${empty result.articles}">
						<li><div class="text-center">등록된 글이 없습니다.</div></li>
					</c:when>
					<c:when test="${!empty result.articles }">
						<c:forEach items="${result.articles}" var="article">
							<li class="article-wrap">
								<div class="article-title-wrap">
									<div>
										<span>#${article.articleId }</span> 
										<span class="article-info">
										      <span>${article.articleWriterName }</span>
											  <span class="articleInsertDate" title="${article.articleInsertDate }"></span>
											  <span>${article.articleHit}hit</span>
										</span>
									</div>
									<div>
										<a href="/article/${article.articleId }">
											${article.articleTitle }</a>
									</div>
								</div>
								<div class="article-info-wrap">
									<div>${article.articleWriterName }</div>
									<div>
										<span class="articleInsertDate" title="${article.articleInsertDate }"></span>
										<span class="text-right">${article.articleHit}hit</span>
									</div>
								</div>

							</li>
						</c:forEach>
					</c:when>
				</c:choose>
			</ul>
			<div class="text-center">
				<c:if
					test="${not empty result.articles && not empty result.paginationInfo}">
					<ui:pagination paginationInfo="${result.paginationInfo}"
						type="text" jsFunction="fn_search" />
				</c:if>
			</div>
			</main>
		</section>
		<footer>
			<a href="#">홈페이지</a>
		</footer>
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
		
			function fn_search(pageNo) {
				var articleCategory = $('#articleCategory').val();
				location.href = "/articles/" + articleCategory + "?currentPageNo=" + pageNo;
			}
		</script>
	</div>
</body>
</html>