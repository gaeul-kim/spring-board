<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/include/header.jspf"%>
<title>SampleProject - ${article.articleTitle }</title>
</head>
<body>
	<div class="container">
		<div class="content">
		  <div class="box-medium">
			<table class="table table-striped">
				<caption>
				    <a href="/articles/${article.articleCategory }">${article.articleCategory }</a>
				</caption>
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
			</div>
		</div>
	</div>
</body>
</html>