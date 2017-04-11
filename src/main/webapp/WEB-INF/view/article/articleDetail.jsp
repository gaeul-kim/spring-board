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
<title>SampleProject - ${article.articleTitle }</title>
</head>
<body>
	<div>분류 : ${article.articleCategory }</div>
	<div>글번호 : ${article.articleId }</div>
	<div>작성자 : ${article.articleWriter }</div>
	<div>제목 : ${article.articleTitle }</div>
	<div>내용 : ${article.articleContent }</div>
	<div>작성일 : ${article.articleInsertDate }</div>
	<div>조회수 : ${article.articleHit }</div>
	<div>
		<a href="/">메인</a>&nbsp;<a href="/articles/${article.articleCategory}">목록</a>
	</div>
</body>
</html>