$(document).ready(function() {

	function validate_user_id() {
		var val = $('#user_id').val();
		var regex = /^[a-z0-9+]{5,15}$/;

		if (val == '' | val == null) {
			$('#user_id + .info').html("필수 입력").attr('style', 'color:red');
			return false;
		} else if (!regex.test(val)) {
			$('#user_id + .info').html("5~15자의 영문 소문자, 숫자만 가능").attr('style', 'color:red');
			return false;
			} else {
			var param = {
				"user_id" : val
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
				$('#user_id + .info').html("사용중이거나 탈퇴한 아이디 입니다").attr('style', 'color:red');
				return false;
			} else if (result == 'success') {
				$('#user_id + .info').html("사용 가능한 아이디 입니다").attr('style', 'color:black');
				return true;
			}
		}
	}
	function validate_user_password() {
		var val = $('#user_password').val();
		var regex = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{5,15}$/;

		if (val == '' | val == null) {
			$('#user_password + .info').html("필수 입력").attr('style', 'color:red');
			return false;
		} else if (!regex.test(val)) {
			$('#user_password + .info').html("5~15자의 영문 대소문자, 숫자 혹은 특수문자를 반드시 포함").attr('style', 'color:red');
			return false;
		} else {
			$('#user_password + .info').html("").attr('style', 'color:black');
			return true;
		}
	}
	function validate_check_password() {
		var check_password = $('#check_password').val();
		var user_password = $('#user_password').val();

		if (check_password == '' | check_password == null) {
			$('#check_password + .info').html("필수 입력").attr('style', 'color:red');
			return false;
		} else if (user_password != check_password) {
			$('#check_password + .info').html("비밀번호 불일치").attr('style', 'color:red');
			return false;
		} else {
			$('#check_password + .info').html("비밀번호 일치").attr('style', 'color:black');
			return true;
		}
	}

	function validate_user_name() {
		var val = $('#user_name').val();
		var regex = /^[가-힣]{2,5}|[a-zA-Z]{4,10}$/;

		if (val == '' | val == null) {
			$('#user_name + .info').html("필수 입력").attr('style', 'color:red');
			return false;
		} else if (!regex.test(val)) {
			$('#user_name + .info').html("2~10자의 한글, 4~10자의 영문자").attr('style', 'color:red');
			return false;
		} else {
			$('#user_name + .info').html("").attr('style', 'color:black');
			return true;
		}
	}

	function validate_user_email() {
		var val = $('#user_email').val();
		var regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

		if (val == '' | val == null) {
			$('#user_email + .info').html("필수 입력").attr('style', 'color:red');
			return false;
		} else if (!regex.test(val)) {
			$('#user_email + .info').html("이메일 주소가 올바르지 않습니다").attr('style', 'color:red');
			return false;
		} else {
			$('#user_email + .info').html("").attr('style', 'color:black');
			return true;
		}
	}

	$('#user_id').focusout(function() {
		validate_user_id();
	});
	$('#user_password, #check_password').focusout(function() {
		validate_user_password();
		validate_check_password();
	});

	$('#user_name').focusout(function() {
		validate_user_name();
	});
	$('#user_email').focusout(function() {
		validate_user_email();
	});


	$('.form-signUp').submit(function() {
		if (!validate_user_id() | !validate_user_password() | !validate_check_password() | !validate_user_name() | !validate_user_email()) {
			return false;
		}
	});
})