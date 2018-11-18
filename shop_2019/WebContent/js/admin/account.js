$(document).ready(function() {
	setDate();
	$("#joinBtn").click(function() {
		join();
	});
});

// 날짜 불러오기
function setDate() {
	var dt = new Date();
	var year = dt.getFullYear();
	var month = dt.getMonth() + 1;
	var date = dt.getDate();

	var optionY = "";
	for ( var i = year - 50; i <= year; i++) {
		if (year == i) {
			optionY += "<option value='" + i + "' selected>";
		} else {
			optionY += "<option value='" + i + "'>";
		}
		optionY += i;
		optionY += "</option>";

	}
	$("#year").html(optionY);

	var optionM = "";
	for ( var i = 1; i <= 12; i++) {
		if (month == i) {
			optionM += "<option value='" + i + "' selected>";
		} else {
			optionM += "<option value='" + i + "'>";
		}
		optionM += i;
		optionM += "</option>";

	}
	$("#month").html(optionM);

	var optionD = "";
	for ( var i = 1; i <= 31; i++) {
		if (date == i) {
			optionD += "<option value='" + i + "' selected>";
		} else {
			optionD += "<option value='" + i + "'>";
		}
		optionD += i;
		optionD += "</option>";

	}
	$("#date").html(optionD);
}

// 회원가입
function join() {
	$("#joinForm").submit();

}