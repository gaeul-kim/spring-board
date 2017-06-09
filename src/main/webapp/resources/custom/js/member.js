function validateMemberId() {
	var val = $('#memberId').val();
	var regex = /^[a-z0-9+]{5,15}$/;

	if (val == '' | val == null) {
		$('#memberId + div').html("필수입력 항목").attr('class', 'errorMessage');
		return false;
	} else if (!regex.test(val)) {
		$('#memberId + div').html("5~15자의 영문 소문자와 숫자만 가능").attr('class', 'errorMessage');
		return false;
	} else {
		var result;
		$.ajax({
			dataType : 'json',
			data : {
				"memberId" : val
			},
			async : false,
			url : '/member/checkMemberId',
			method : 'post',
			error : function(error) {
				alert("error");
			},
			success : function(data) {
				result = data.result;
			}
		});
		if (result == 'success') {
			$('#memberId + div').html("사용 가능한 아이디").attr('class', 'successMessage');
			return true;
		} else if (result == 'fail') {
			$('#memberId + div').html("사용 불가능한 아이디").attr('class', 'errorMessage');
			return false;
		}
	}
}

function validateMemberPassword() {
	var val = $('#memberPassword').val();
	var regex = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{5,15}$/;

	if (val == '' | val == null) {
		$('#memberPassword + div').html("필수입력 항목").attr('class', 'errorMessage');
		return false;
	} else if (!regex.test(val)) {
		$('#memberPassword + div').html("숫자나 특수문자를 포함한 5~15자의 영문 대소문자").attr('class', 'errorMessage');
		return false;
	} else {
		$('#memberPassword + div').html("올바른 비밀번호").attr('class', 'successMessage');
		return true;
	}
}

function validateConfirmPassword() {
	var confirmPassword = $('#confirmPassword').val();
	var memberPassword = $('#memberPassword').val();

	if (confirmPassword == '' | confirmPassword == null) {
		$('#confirmPassword + div').html("필수입력 항목").attr('class', 'errorMessage');
		return false;
	} else if (memberPassword != confirmPassword) {
		$('#confirmPassword + div').html("비밀번호 불일치").attr('class', 'errorMessage');
		return false;
	} else {
		$('#confirmPassword + div').html("비밀번호 일치").attr('class', 'successMessage');
		return true;
	}
}

function validateMemberName() {
	var val = $('#memberName').val();
	var regex = /^[가-힣a-zA-Z]{2,10}$/;

	if (val == '' | val == null) {
		$('#memberName + div').html("필수입력 항목").attr('class', 'errorMessage');
		return false;
	} else if (!regex.test(val)) {
		$('#memberName + div').html("2~10자의 한글이나 영문만 가능").attr('class', 'errorMessage');
		return false;
	} else {
		$('#memberName + div').html("").attr('class', 'info');
		return true;
	}
}

function validateMemberEmail() {
	var val = $('#memberEmail').val();
	var regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

	if (val == '' | val == null) {
		$('#memberEmail + div').html("").attr('class', 'info');
		return true;
	} else if (!regex.test(val)) {
		$('#memberEmail + div').html("유효하지 않은 이메일 형식").attr('class', 'errorMessage');
		return false;
	} else {
		$('#memberEmail + div').html("").attr('class', 'info');
		return true;
	}
}

$('#memberId').blur(function() {
	validateMemberId();
});
$('#memberPassword, #confirmPassword').blur(function() {
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
	if (!(validateMemberId() && validateMemberPassword() && validateConfirmPassword() && validateMemberName() && validateMemberEmail())) {
		return false;
	}
});