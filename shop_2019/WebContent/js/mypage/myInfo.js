$(document).ready(function(){
	myInfo();
	
	// 정보 수정
	$("#infoUpdateBtn").click(function(){
		infoUpdate();
	});
	
	// 비밀번호 수정페이지로 이동
	$("#pwdUpdateUrlBtn").click(function(){
		location.href = "/mypage/pwdUpdate.do?cmd=pwdUpdatePage";
	});
});

// 회원 정보 가져오기
function myInfo(){
	// 로그인한 회원ID
	var userId = $("#userId").val();	
	
	$.ajax({
		type: "POST",
		url: "myInfo.do?cmd=selectMyInfo",
		dataType: "json",
		data : "userId="+userId,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			var result = data.user;
			$("#user_id").html(result.id);
			$("#user_name").html(result.name);
			$("#user_email").val(result.email);
			$("#user_birth").html(result.birth);
			$("#user_tel").val(result.tel);
		}
	});
}

// 회원 정보 수정
function infoUpdate(){
	$.ajax({
		type: "POST",
		url: "myInfo.do?cmd=updateMyInfo",
		dataType: "json",
		data : $("#myInfoForm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			alert("수정되었습니다.");
			myInfo();
		}
	});
}

