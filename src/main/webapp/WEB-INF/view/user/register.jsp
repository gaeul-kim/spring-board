<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<script src="/js/jquery-3.1.1.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/user_register.css">
</head>
<body>
	<div class="container">
		<div class="content">
			<form class="form-signUp" action="register" method="post">
				<div class="form-box">
					<div class="input-box">
						<input class="form-control" type="text" placeholder="아이디"
							id="userId" name="userId" maxlength="15">
						<div class="info"></div>
					</div>
					<div class="input-box">
						<input class="form-control" type="password" placeholder="비밀번호"
							id="userPassword" name="userPassword" maxlength="15">
						<div class="info"></div>
					</div>
					<div class="input-box">
						<input class="form-control" type="password" placeholder="비밀번호 확인"
							id="checkPassword" name="checkPassword" maxlength="15">
						<div class="info"></div>
					</div>
				</div>
				<div class="form-box">
					<div class="input-box">
						<input class="form-control" type="text" placeholder="이름"
							id="userName" name="userName" maxlength="10">
						<div class="info"></div>
					</div>
					<div class="input-box">
						<input class="form-control" type="text" placeholder="이메일"
							id="userEmail" name="userEmail" maxlength="30">
						<div class="info"></div>
					</div>
				</div>
				<button class="btn btn-primary btn-block" id="signUp" name="signUp">회원가입</button>
			</form>
		</div>
	</div>
	<script>
		$(document).ready(function() {
	
			function validate_userId() {
				var val = $('#userId').val();
				var regex = /^[a-z0-9+]{5,15}$/;
	
				if (val == '' | val == null) {
					$('#userId + .info').html("필수 입력").attr('style', 'color:red');
					return false;
				} else if (!regex.test(val)) {
					$('#userId + .info').html("5~15자의 영문 소문자, 숫자만 가능").attr('style', 'color:red');
					return false;
				} else {
					var param = {
						"userId" : val
					}
					var result;
					$.ajax({
						dataType : 'json',
						data : param,
						async : false,
						url : '/user/checkId',
						method : 'post',
						success : function(data) {
							result = data.result;
						}
					});
					if (result == 'fail') {
						$('#userId + .info').html("이미 사용중이거나 탈퇴한 아이디 입니다").attr('style', 'color:red');
						return false;
					} else if (result == 'success') {
						$('#userId + .info').html("사용 가능한 아이디 입니다").attr('style', 'color:black');
						return true;
					}
				}
			}
			function validate_userPassword() {
				var val = $('#userPassword').val();
				var regex = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{5,15}$/;
	
				if (val == '' | val == null) {
					$('#userPassword + .info').html("필수 입력").attr('style', 'color:red');
					return false;
				} else if (!regex.test(val)) {
					$('#userPassword + .info').html("5~15자의 영문 대소문자, 숫자 혹은 특수문자를 반드시 포함").attr('style', 'color:red');
					return false;
				} else {
					$('#userPassword + .info').html("").attr('style', 'color:black');
					return true;
				}
			}
			function validate_checkPassword() {
				var checkPassword = $('#checkPassword').val();
				var userPassword = $('#userPassword').val();
	
				if (checkPassword == '' | checkPassword == null) {
					$('#checkPassword + .info').html("필수 입력").attr('style', 'color:red');
					return false;
				} else if (userPassword != checkPassword) {
					$('#checkPassword + .info').html("비밀번호 불일치").attr('style', 'color:red');
					return false;
				} else {
					$('#checkPassword + .info').html("비밀번호 일치").attr('style', 'color:black');
					return true;
				}
			}
	
			function validate_userName() {
				var val = $('#userName').val();
				var regex = /^[가-힣]{2,5}|[a-zA-Z]{4,10}$/;
	
				if (val == '' | val == null) {
					$('#userName + .info').html("필수 입력").attr('style', 'color:red');
					return false;
				} else if (!regex.test(val)) {
					$('#userName + .info').html("2~10자의 한글, 4~10자의 영문자").attr('style', 'color:red');
					return false;
				} else {
					$('#userName + .info').html("").attr('style', 'color:black');
					return true;
				}
			}
	
			function validate_userEmail() {
				var val = $('#userEmail').val();
				var regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
				if (val == '' | val == null) {
					$('#userEmail + .info').html("필수 입력").attr('style', 'color:red');
					return false;
				} else if (!regex.test(val)) {
					$('#userEmail + .info').html("이메일 주소가 올바르지 않습니다").attr('style', 'color:red');
					return false;
				} else {
					$('#userEmail + .info').html("").attr('style', 'color:black');
					return true;
				}
			}
	
			$('#userId').focusout(function() {
				validate_userId();
			});
			$('#userPassword, #checkPassword').focusout(function() {
				validate_userPassword();
				validate_checkPassword();
			});
	
			$('#userName').focusout(function() {
				validate_userName();
			});
			$('#userEmail').focusout(function() {
				validate_userEmail();
			});
	
	
			$('.form-signUp').submit(function() {
				if (!validate_userId() | !validate_userPassword() | !validate_checkPassword() | !validate_userName() | !validate_userEmail()) {
					return false;
				}
			});
		})
	</script>
</body>
</html>
