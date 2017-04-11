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
<title>SampleProject - 글작성</title>
</head>
<body>
	<div>
		분류 : <select>
			<c:choose>
				<c:when test="${empty articleCategories}">
					<option>미분류</option>
				</c:when>
				<c:when test="${!empty articleCategories }">
					<c:forEach items="${articleCategories}" var="category">
						<option>${category }</option>
					</c:forEach>
				</c:when>
			</c:choose>
		</select>
	</div>

	<div>
		제목 :<input type="text" name="article_title">
	</div>
	<div>
		내용 :
		<textarea rows="5" cols="10" name="article_content"></textarea>
	</div>
	<div>
		<a href="/">메인</a>
	</div>
</body>
</html>