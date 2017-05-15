<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/include/header.jspf"%>
<title>SampleProject - 글수정</title>
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
			<main> <input type="hidden" id="articleCategory" value="${articleCategory }" /> <input type="hidden" id="articleId" value="${articleId }" />
			<div class="box-medium">
				<form:form modelAttribute="article" method="post" autocomplete="false">
					<div class="form-box">
						<c:choose>
							<c:when test="${!empty articleTags }">
								<div class="input-box">
									<select name="articleTag" class="form-control">
										<c:forEach items="${articleTags}" var="articleTag">
											<c:choose>
												<c:when test="${articleTag eq article.articleTag }">
													<option selected>${articleTag }</option>
												</c:when>
												<c:otherwise>
													<option>${articleTag }</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
							</c:when>

						</c:choose>
						<div class="input-box">
							<form:input path="articleTitle" class="form-control" placeholder="제목" maxlength="50" required="required" />
						</div>
					</div>
					<div class="form-box">
						<div class="input-box">
							<form:textarea path="articleContent" class="form-control" placeholder="내용" rows="10" wrap="hard" required="required" />
						</div>
					</div>
					<button class="btn btn-default btn-block" id="btn-register">수정</button>
				</form:form>
			</div>
			</main>
		</section>
		<footer>
			<a href="#">홈페이지</a>
		</footer>
	</div>
</body>
</html>