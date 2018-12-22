$(document).ready(function(){
	// 비밀번호 수정
	$("#pwdUpdateBtn").click(function(){
		pwdUpdate();
	});
	
	$("#cancelPwdUpdateBtn").click(function(){
		location.href = "/mypage/myInfo.do";
	});
});

//비밀번호 수정
function pwdUpdate(){
	
	var newPwd = $("#newPwd").val();
	var reNewPwd = $("#reNewPwd").val();
	// 비밀번호 정규식 표현
	var passwordRules = /^[a-zA-Z0-9]{8,15}$/;

	
	if(newPwd == "" || newPwd.length == 0){
		alert("새 비밀번호를 입력해주세요.");
		return;
	}else if(reNewPwd == "" || reNewPwd.length == 0){
		alert("새 비밀번호 확인을 입력해주세요.");
		return;
	}else if(newPwd != reNewPwd){
		alert("비밀번호가 일치하지 않습니다.");
		return;
	}else if(!passwordRules.test(newPwd)){
		alert("비밀번호는 숫자와 영문자 조합으로 8~15자리를 사용해야 합니다.");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "myInfo.do?cmd=updatePwdInfo",
		dataType: "json",
		data : "newPwd="+newPwd,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			alert("비밀번호가  수정되었습니다.");
			location.href ="/mypage/myInfo.do";
		}
	});
}
