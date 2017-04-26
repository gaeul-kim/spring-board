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
			<main> <input type="hidden" id="articleCategory"
				value="${articleCategory }" />
			<div class="search-control">
				<a class="btn btn-default pull-right"
					href="/articles/${articleCategory}/write">글쓰기</a>
			</div>
			<ul>
				<c:choose>
					<c:when test="${empty result.articles}">
						<li><div class="text-center">등록된 글이 없습니다.</div></li>
					</c:when>
					<c:when test="${!empty result.articles }">
						<c:forEach items="${result.articles}" var="article">
							<li class="article-wrap">
								<div class="article-title-wrap">
									<div>
										<span>#${article.articleId }</span> <span id="article-info">${article.articleWriterName }${article.articleInsertDate }${article.articleHit}
											hit</span>
									</div>
									<div>
										<a href="/article/${article.articleId }">
											${article.articleTitle }</a>
									</div>
								</div>
								<div class="article-info-wrap">
									<div>${article.articleWriterName }</div>
									<div>
										${article.articleInsertDate }<span>&nbsp;${article.articleHit}hit</span>
									</div>
								</div>

							</li>
						</c:forEach>
						<div class="text-center">
							<c:if test="${not empty result.paginationInfo}">
								<ui:pagination paginationInfo="${result.paginationInfo}"
									type="text" jsFunction="fn_search" />
							</c:if>
						</div>
					</c:when>
				</c:choose>
			</ul>
			</main>
		</section>
		<footer>
			<a href="#">홈페이지</a>
		</footer>
		<script>
			function fn_search(pageNo) {
				var articleCategory = $('#articleCategory').val();
				location.href = "/articles/" + articleCategory + "?currentPageNo=" + pageNo;
			}
		</script>
	</div>
</body>
</html>