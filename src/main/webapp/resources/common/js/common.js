/*function gfn_isNull(str) {
	if (str == null) return true;
	if (str == "NaN") return true;
	if (new String(str).valueOf() == "undefined") return true;
	var chkStr = new String(str);
	if (chkStr.valueOf() == "undefined") return true;
	if (chkStr == null) return true;
	if (chkStr.toString().length == 0) return true;
	return false;
}

function ComSubmit(opt_formId) {
	this.formId = gfn_isNull(opt_formId) == true ? "commonForm" : opt_formId;
	this.url = "";

	if (this.formId == "commonForm") {
		$("#commonForm")[0].reset();
	}

	this.setUrl = function setUrl(url) {
		this.url = url;
	};

	this.addParam = function addParam(key, value) {
		$("#" + this.formId).append($("<input type='hidden' name='" + key + "' id='" + key + "' value='" + value + "' >"));
	};

	this.submit = function submit() {
		var frm = $("#" + this.formId)[0];
		frm.action = this.url;
		frm.method = "post";
		frm.submit();
	};
}*/

function date_calculator(input_date) {
	var now = new Date();
	var date = new Date(input_date.replace(/-/g, '/'));
	var subtract_value = parseInt(((now - date) / 60000));
	var prefix = "";
	var suffix = "";
	var result = " 전";

	if (subtract_value < 1) {
		prefix = "방금";
	} else if (subtract_value < 60) {
		prefix = subtract_value;
		suffix = "분";
	} else if (subtract_value < (60 * 24)) {
		prefix = parseInt(subtract_value / 60);
		suffix = "시간";
	} else if (subtract_value < (60 * 24 * 30)) {
		prefix = parseInt(subtract_value / 60 / 24);
		suffix = "일";
	} else if (subtract_value < ((60 * 24 * 30 * 12) + 5)) {
		prefix = parseInt(subtract_value / 60 / 24 / 30 / 12);
		suffix = "달"
	} else {
		prefix = parseInt(subtract_value / 365);
		suffix = "년";
	}

	result = prefix + suffix + result;
	return result;
}