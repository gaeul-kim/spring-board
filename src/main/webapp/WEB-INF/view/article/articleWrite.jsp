<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/include/header.jspf"%>
<title>SampleProject - 글작성</title>
</head>
<body>
	<div class="container">
		<div class="content">
		  <div class="box-medium">
			<form:form modelAttribute="article" mthod="post" autocomplete="false">
				<input type="hidden" name="articleWriter" value="<sec:authentication property="principal.memberId" />" />
				<div class="form-box">
					<c:choose>
						<c:when test="${!empty articleTags }">
							<div class="input-box">
								<select name="articleTag" class="form-control">
									<c:forEach items="${articleTags}" var="articleTag">
										<option>${articleTag }</option>
									</c:forEach>
								</select>
							</div>
						</c:when>

					</c:choose>
					<div class="input-box">
						<form:input path="articleTitle" class="form-control" placeholder="제목" maxlength="80" required="required" />
					</div>
				</div>
				<div class="form-box">
					<div class="input-box">
						<form:textarea path="articleContent" class="form-control" placeholder="내용" rows="10" wrap="hard" required="required" />
					</div>
				</div>
				<button class="btn btn-default btn-block" id="btn-register">작성</button>
			</form:form>
			</div>
		</div>
	</div>
</body>
</html>