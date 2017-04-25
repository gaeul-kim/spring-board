<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/include/header.jspf" %>
<title>SampleProject - ${articleCategory}</title>
</head>
<body>
	<div class="container">
		<div class="content">
		  <div class="box-medium"> 
			<table class="table table-hover table-condensed">
				<caption>
					<input type="hidden" value="${articleCategory }" id="articleCategory" /> 
					<a href="/articles/${articleCategory }">${articleCategory }</a>
					<a class="btn btn-default pull-right" href="/articles/${articleCategory}/write">글쓰기</a>
				</caption>
				<thead>
					<tr>
						<th class="col-xs-1 text-center">번호</th>
						<th class="col-xs-5">제목</th>
						<th class="col-xs-2 text-center">작성자</th>
						<th class="col-xs-2 text-center">날짜</th>
						<th class="col-xs-2 text-center">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty result}">
							<tr>
								<td colspan="5" class="text-center">등록된 글이 없습니다.</td>
							</tr>
						</c:when>
						<c:when test="${!empty result }">
							<c:forEach items="${result.articles}" var="article">
								<tr>
									<td class="text-center">${article.articleId }</td>
									<td><a href="/article/${article.articleId }">
								<c:choose>
									   <c:when test="${fn:length(article.articleTitle) > 25 }">
									       <c:out value="${fn:substring(article.articleTitle,0,25) }"/>...
									   </c:when>
									   <c:otherwise>
									       <c:out value="${article.articleTitle }"/>
									   </c:otherwise>
									</c:choose>
									</a></td>
									<td class="text-center">${article.articleWriterName }</td>
									<td class="text-center">${article.articleInsertDate }</td>
									<td class="text-center">${article.articleHit}</td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
			</table>
			<div class="text-center">
				<c:if test="${not empty result.paginationInfo}">
					<ui:pagination paginationInfo="${result.paginationInfo}"
						type="text" jsFunction="fn_search" />
				</c:if>
				</div>
			</div>
		</div>
	</div>
	<script>
		function fn_search(pageNo) {
			var articleCategory = $('#articleCategory').val();
			location.href = "/articles/" + articleCategory + "?currentPageNo=" + pageNo;
		}
	</script>
</body>
</html>