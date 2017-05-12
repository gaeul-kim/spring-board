<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/include/header.jspf"%>
<title>SampleProject - ${article.articleTitle }</title>
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
			<main>
			<div class="control">
				<c:if test="${isAdmin or loginId eq article.articleWriter }">
					<a class="btn btn-default" id="btn-article-delete">삭제</a>
					<a class="btn btn-default"
						href="/article/edit/${article.articleId}">수정</a>
				</c:if>
				<a class="btn btn-default"
					href="/articles/${article.articleCategory}">목록</a> <a
					class="btn btn-default" href="javascript:history.back();">이전</a>
			</div>
			<ul class="article-detail">
				<li class="article-wrap">
					<div class="article-title-wrap">
						<div>
							<span>#${article.articleId }</span>
							<c:if test="${not empty article.articleTag }">
								<span>[${article.articleTag }]</span>
							</c:if>
							<span class="article-info"> <span>${article.articleWriterName }</span>
								<span class="articleInsertDate"
								title="${article.articleInsertDate }"></span> <span>${article.articleHit}hit</span>
							</span>
						</div>
						<div>${article.articleTitle }</div>
					</div>
					<div class="article-info-wrap">
						<div>${article.articleWriterName }</div>
						<div>
							<span class="articleInsertDate"
								title="${article.articleInsertDate }"></span><span
								class="text-right">${article.articleHit}hit</span>
						</div>
					</div>
				</li>
				<li class="article-wrap ">${article.articleContent }</li>
			</ul>
			<ul class="comment-list">
				<c:if test="${!empty comments }">
					<c:forEach items="${comments }" var="comment">
						<li
							class="comment-wrap <c:if test="${!empty comment.commentParentsId}">reply</c:if>">
							<input type="hidden" id="commentId" name="commentId"
							value="${comment.commentId }" /> <input type="hidden"
							id="commentParentsId" name="commentParentsId"
							value="${comment.commentParentsId }" />
							<div class="comment-info">
								<span>${comment.commentWriterName }</span> <span
									class="commentInsertDate" title="${comment.commentInsertDate }"></span>
								<c:if test="${empty comment.commentParentsId}">
									<span><a href="javascript:;">답글</a></span>
								</c:if>

							</div>
							<div class="comment-content">
								<span>${comment.commentContent }</span>
							</div>
						</li>
					</c:forEach>
				</c:if>
				<li class="comment-control">
					<div>
						<span><input id="commentContent" type="text" /></span> <span><button
								id="btn-comment-write" class="btn btn-default">등록</button></span>
					</div>
				</li>
			</ul>

			<form id="commonForm" name="commonForm"></form>
			</main>
		</section>
		<footer>
			<a href="#">홈페이지</a>
		</footer>
	</div>
	<script>
		$(document).ready(function() {
			
			$('#btn-comment-write').on("click", function(){
				if(${isLogin}){
					
					var articleId = ${article.articleId};		
					var commentContent = $('#commentContent').val();
					var commentParentsId = null;
	                if(commentContent == '' || commentContent == null){
	                        alert("내용을 입력하세요");
	                        return false;
	                    }
					if($('.comment-control').hasClass('reply')){
						commentParentsId = $('.comment-control').prev().children('#commentId').val()
                    }
					
					var param = {
							"articleId" : articleId,
							"commentContent" : commentContent,
							"commentParentsId" : commentParentsId
					}
					$.ajax({
						dataType : 'json',
						data : param,
						async : false,
						url : '/comment/write',
						method : 'post',
						success : function(data){
							$('.comment-list>li').remove();
							
							var comments = new Array();
							comments = data.comments;
						
						}
					});
				} else{
					alert("로그인이 필요합니다.");
				}
			});
			
			// 댓글 입력창 이동
            $('.comment-wrap a').on("click",function(){
				if (!$(this).closest('li').next().hasClass('comment-control')) {						
					$('.comment-control').addClass('reply');
					$(this).closest('li').after($('.comment-control'));
				} else {
					$('.comment-control').removeClass('reply');
					$('.comment-list>li:last-child').after($('.comment-control'));
				}
			});
	
			$('#btn-article-delete').on("click", function(e) {
				e.preventDefault();
				var result = confirm('삭제하시겠습니까?');
				if (result) {
					fn_articleDelete();
				}
			});
	
			$.fn.setDate = function() {
				return this.each(function() {
					var str = date_calculator($(this).attr('title'));
					$(this).text(str);
				});
			};
			$('.articleInsertDate, .commentInsertDate').setDate();
		});
	
		function fn_articleDelete() {
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/article/delete/${article.articleId}' />");
			comSubmit.addParam("articleCategory", '${article.articleCategory}');
			comSubmit.submit();
		}
		
		function fn_commentList(comments){
			 
		}
	</script>
</body>
</html>