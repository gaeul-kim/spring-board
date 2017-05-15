/*$(document).ready(function() {
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
				dataType : 'html',
				data : param,
				async : false,
				url : '/comment/write',
				method : 'post',
				success : function(data){
					$('.comment-list').html(data);
                    fn_bindComments();
				}
			});
		} else{
			alert("로그인이 필요합니다.");
		}
		
		
		
		// 댓글 입력창 이동
        fn_bindComments();

		$('#btn-article-delete').on("click", function(e) {
			e.preventDefault();
			var result = confirm('삭제하시겠습니까?');
			if (result) {
				fn_articleDelete();
			}
		});
	});
	
	
	
	
	
});



function fn_bindComments() {
	$('.comment-wrap a').on("click", function() {
		if (!$(this).closest('li').next().hasClass('comment-control')) {
			$('.comment-control').addClass('reply');
			$(this).closest('li').after($('.comment-control'));
		} else {
			$('.comment-control').removeClass('reply');
			$('.comment-list>li:last-child').after($('.comment-control'));
		}
	});
}*/