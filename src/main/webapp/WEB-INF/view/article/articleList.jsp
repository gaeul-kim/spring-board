<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SampleProject - ${articleCategory}</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty articles}">
        등록된 글이 없습니다.
    </c:when>
		<c:when test="${!empty articles }">
			<c:forEach items="${articles}" var="article">
				<div>
					${article.articleId } <a href="/article/${article.articleId }">${article.articleTitle }</a>
					${article.articleWriter } ${article.articleInsertDate }
					${article.articleHit}
				</div>
			</c:forEach>
		</c:when>
	</c:choose>

	<div>
		<a href="/">메인</a> &nbsp; <a href="/articles/${articleCategory}/write">글 작성</a>
	</div>
</body>
</html>