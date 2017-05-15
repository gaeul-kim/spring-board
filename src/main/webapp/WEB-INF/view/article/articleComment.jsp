<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${!empty comments }">
	<c:forEach items="${comments }" var="comment">
		<li class="comment-wrap <c:if test="${!empty comment.commentParentsId}">reply</c:if>"><input type="hidden" id="commentId" name="commentId" value="${comment.commentId }" /> <input type="hidden"
				id="commentParentsId" name="commentParentsId" value="${comment.commentParentsId }" />
			<div class="comment-info">
				<span>${comment.commentWriterName }</span>
				<span class="commentInsertDate" title="${comment.commentInsertDate }"></span>
				<c:if test="${empty comment.commentParentsId}">
					<span>
						<a class="btn-reply" href="javascript:;">답글</a>
					</span>
				</c:if>
			</div>
			<div class="comment-content">
				<span>${comment.commentContent }</span>
			</div></li>
	</c:forEach>
</c:if>
<li class="comment-control">
	<div>
		<span>
			<input id="commentContent" type="text" />
		</span>
		<span>
			<button id="btn-comment-write" class="btn btn-default">등록</button>
		</span>
	</div>
</li>
