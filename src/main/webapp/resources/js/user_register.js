$(document).ready(function() {

	function validateMemberId() {
		var val = $('#memberId').val();
		var regex = /^[a-z0-9+]{5,15}$/;

		if (val == '' | val == null) {
			$('#memberId + .info').html("필수 입력").addClass('errorMessage');
			return false;
		} else if (!regex.test(val)) {
			$('#memberId + .info').html("5~15자의 영문 소문자/숫자").addClass('errorMessage');
			return false;
		} else {
			var param = {
				"memberId" : val
			}
			var result;
			$.ajax({
				dataType : 'json',
				data : param,
				async : false,
				url : '/member/checkId',
				method : 'post',
				success : function(data) {
					result = data.result;
				}
			});
			if (result == 'fail') {
				$('#memberId + .info').html("사용중이거나 탈퇴한 아이디").addClass('errorMessage');
				return false;
			} else if (result == 'success') {
				$('#memberId + .info').html("사용 가능한 아이디").removeClass('errorMessage');
				return true;
			}
		}
	}
	function validateMemberPassword() {
		var val = $('#memberPassword').val();
		var regex = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{5,15}$/;

		if (val == '' | val == null) {
			$('#memberPassword + .info').html("필수 입력").addClass('errorMessage');
			return false;
		} else if (!regex.test(val)) {
			$('#memberPassword + .info').html("5~15자의 영문 대소문자와 숫자/특수문자를 포함").addClass('errorMessage');
			return false;
		} else {
			$('#memberPassword + .info').html("").removeClass('errorMessage');
			return true;
		}
	}
	function validateConfirmPassword() {
		var confirmPassword = $('#confirmPassword').val();
		var memberPassword = $('#memberPassword').val();

		if (confirmPassword == '' | confirmPassword == null) {
			$('#confirmPassword + .info').html("필수 입력").addClass('errorMessage');
			return false;
		} else if (memberPassword != confirmPassword) {
			$('#confirmPassword + .info').html("비밀번호 불일치").addClass('errorMessage');
			return false;
		} else {
			$('#confirmPassword + .info').html("비밀번호 일치").removeClass('errorMessage');
			return true;
		}
	}

	function validateMemberName() {
		var val = $('#memberName').val();
		var regex = /^[가-힣]{2,5}|[a-zA-Z]{4,10}$/;

		if (val == '' | val == null) {
			$('#memberName + .info').html("필수 입력").addClass('errorMessage');
			return false;
		} else if (!regex.test(val)) {
			$('#memberName + .info').html("2~10자의 한글, 4~10자의 영문자").addClass('errorMessage');
			return false;
		} else {
			$('#memberName + .info').html("").removeClass('errorMessage');
			return true;
		}
	}

	function validateMemberEmail() {
		var val = $('#memberEmail').val();
		var regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

		if (val == '' | val == null) {
			$('#memberEmail + .info').html("필수 입력").addClass('errorMessage');
			return false;
		} else if (!regex.test(val)) {
			$('#memberEmail + .info').html("이메일 주소가 유효하지 않습니다").addClass('errorMessage');
			return false;
		} else {
			$('#memberEmail + .info').html("").removeClass('errorMessage');
			return true;
		}
	}

	$('#memberId').blur(function() {
		validateMemberId();
	});
	$('#userPassword, #confirmPassword').blur(function() {
		validateMemberPassword();
		validateConfirmPassword();
	});

	$('#memberName').blur(function() {
		validateMemberName();
	});
	$('#memberEmail').blur(function() {
		validateMemberEmail();
	});

	$('#member').submit(function() {
		if (!validateMemberId() | !validateMemberPassword() | !validateConfirmPassword() | !validateMemberName() | !validateMemberEmail()) {
			return false;
		}
	});
})