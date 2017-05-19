<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/include/header.jspf"%>
<link rel="stylesheet" href="/css/article.css">
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
			<div class="article-control">
				<c:if test="${isAdmin or loginId eq article.articleWriter }">
					<a class="btn btn-default" id="btn-article-delete">삭제</a>
					<a class="btn btn-default" href="/article/edit/${article.articleId}">수정</a>
				</c:if>
				<a class="btn btn-default" href="/articles/${article.articleCategory}">목록</a> <a class="btn btn-default" href="javascript:history.back();">이전</a>
			</div>
			<ul class="article-detail">
				<li class="article-wrap">
					<div class="article-title-wrap">
						<div>
							<span>#${article.articleId }</span>
							<c:if test="${not empty article.articleTag }">
								<span class="tag">${article.articleTag }</span>
							</c:if>
							<span class="article-info">
								<span>${article.articleWriterName }</span>
								<span class="articleInsertDate" title="${article.articleInsertDate }"></span>
								<span>${article.articleHit}hit</span>
							</span>
						</div>
						<div>${article.articleTitle }</div>
					</div>
					<div class="article-info-wrap">
						<div>${article.articleWriterName }</div>
						<div>
							<span class="articleInsertDate" title="${article.articleInsertDate }"></span>
							<span class="text-right">${article.articleHit}hit</span>
						</div>
					</div>
				</li>
				<li class="article-wrap ">
					<div>
						<c:set var="enter" value="<%=\"\n\"%>" />
						${fn:replace(article.articleContent,enter,'<br />')}
					</div>
				</li>
			</ul>
			<ul class="comment-list">
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
	    // init
	    fn_getComments();
	    $('.articleInsertDate, .commentInsertDate').setDate();
	    $('#btn-article-delete').on("click", function(e) {
	        e.preventDefault();
	        var result=confirm('삭제하시겠습니까?');
	        if (result) {
	            fn_articleDelete();
	        }
	    }
	    );
	    $(document).on("click", ".btn-reply", function() {
	        if(!$('.comment-control').hasClass('reply')) {
	            $('.comment-control').addClass('reply');
	            $(this).closest('li').after($('.comment-control'));
	        }
	        else {
	            $('.comment-control').removeClass('reply');
	            $('.comment-list>li:last-child').after($('.comment-control'));
	        }
	    }
	    );
	    $(document).on("click", "#btn-comment-write", function() {
	        var articleId=${article.articleId};
	        var commentContent=$('#commentContent').val();
	        var commentParentsId=null;
	        if(!${isLogin}) {
	            alert("로그인이 필요합니다.");
	        }
	        else if(commentContent=='' || commentContent==null) {
	            alert("내용을 입력하세요");
	        }
	        else {
	            if($('.comment-control').hasClass('reply')) {
	                commentParentsId=$('.comment-control').prev().children('#commentId').val()
	            }
	            var param= {
	                "articleId": articleId, "commentContent": commentContent, "commentParentsId": commentParentsId
	            }
	            fn_insertComment(param);
	        }
	    }
	    );
	}

	);
	$.fn.setDate=function() {
	    return this.each(function() {
	        var str=date_calculator($(this).attr('title'));
	        $(this).text(str);
	    }
	    );
	}

	;
	function fn_getComments() {
	    $.ajax( {
	        dataType: 'html', data: {
	            "articleId": ${article.articleId}
	        }
	        , async: false, url: '/comment/list', method: 'post', success: function(data) {
	            $('.comment-list').html(data);
	        }
	    }
	    );
	}

	function fn_insertComment(param) {
	    $.ajax( {
	        dataType: 'html', data: param, async: false, url: '/comment/write', method: 'post', success: function(data) {
	            $('.comment-list').html(data);
	            $('.commentInsertDate').setDate();
	        }
	    }
	    );
	}

	function fn_articleDelete() {
	    var comSubmit=new ComSubmit();
	    comSubmit.setUrl("<c:url value='/article/delete/${article.articleId}' />");
	    comSubmit.addParam("articleCategory",
	    '${article.articleCategory}');
	    comSubmit.submit();
	}
	</script>
</body>
</html>