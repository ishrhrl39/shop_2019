$(document).ready(function() {
	$("#updatePassWdBtn").click(function(){
		updatePassWd();
	});
});


function updatePassWd(){
	// 비밀번호 정규식 표현
	var passwordRules = /^[a-zA-Z0-9]{8,15}$/;
	if($("#pass_wd").val() == ''){
		alert("비밀번호를 입력하세요.");
		return;
	}else if(!passwordRules.test($("#pass_wd").val())){
		alert("비밀번호는 숫자와 영문자 조합으로 10~15자리를 사용해야 합니다.");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "/admin/user.do?cmd=updatePassWd",
		dataType: "json",
		data : $("#accountPopupForm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			if(data.result == 1){
				alert("수정이 완료되었습니다.");
				opener.parent.location.reload(true);
				self.close();
			}else{
				alert("수정을 실패하였습니다.");
			}
		}
	});
}
