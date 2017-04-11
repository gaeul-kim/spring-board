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
<title>SampleProject - ${article.article_title }</title>
</head>
<body>
	<div>분류 : ${article.article_category }</div>
	<div>글번호 : ${article.article_id }</div>
	<div>작성자 : ${article.article_writer }</div>
	<div>제목 : ${article.article_title }</div>
	<div>내용 : ${article.article_content }</div>
	<div>작성일 : ${article.article_insert_date }</div>
	<div>조회수 : ${article.article_hit }</div>
	<div>
		<a href="/">메인</a>&nbsp;<a href="/board/${article.article_category}">목록</a>
	</div>
</body>
</html>