$(document).ready(function(){
	$("#login").click(function(){
		login();
	});
});

// 로그인
function login(){
	var id = $("#id").val();
	var passWd = $("#pass_wd").val();
	
	if(id == "" || id.length == 0){
		alert("아이디를 입력하세요.");
		return;
	}else if(passWd == "" || passWd.length == 0){
		alert("비밀번호를 입력하세요.");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "login.do?cmd=login",
		dataType: "json",
		data : $("#loginForm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			if(data.result==false){
				alert("아이디나 비밀번호가 틀렸습니다.");
				return;
			}else{
				alert("로그인을 성공하였습니다.");
				location.href = "/index.do";
			}
		}
	});
}