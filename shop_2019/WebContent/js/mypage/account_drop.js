$(document).ready(function(){
	
	// 회원탈퇴
	$("#dropBtn").click(function(){
		withDraw();
	});
	
	// 회원탈퇴 취소 
	$("#cancelDropBtn").click(function(){
		location.href = "/mypage/myInfo.do";
	});
});

// 회원탈퇴 처리
function withDraw(){
	var id = $("#id").val();
	var pass_wd = $("#pass_wd").val();
	
	if(id == "" || id.length == 0){
		alert("아이디를 입력하십시오.");
		return;
	}else if(pass_wd == "" || pass_wd.length == 0){
		alert("비밀번호를 입력하십시오.");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "/mypage/myInfo.do?cmd=withDraw",
		dataType: "json",
		data : $("#withDrawFrm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			if(data.result == "SUCCESS"){
				alert("회원탈퇴처리가 완료되었습니다.");
				location.href = "/account/login.do?cmd=logout";
			}else if(data.result == "NOUSER"){
				alert("아이디 또는 비밀번호 정보가 맞지않습니다.");
				return;
			}
		}
	});
}
