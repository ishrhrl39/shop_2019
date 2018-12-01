$(document).ready(function() {
	// 회원 검색
	$("#searchBtn").click(function(){
		search();
	});
	
	// 회원 탈퇴
	$("#deleteBtn").click(function(){
		deleteUser();
	});
	
	// 회원 사용 중 상태로 변경
	$("#useYesBtn").click(function(){
		useYesUser();
	});
	
	// 검색란에서 enter 키 처리시 이벤트
	$("#searchValue").keydown(function(key){
		if(key.keyCode == 13){
			search();
			return false;
		}
	});
});

function useYesUser(){
	if(!isCheckUser()){ return ; }
	
	$.ajax({
		type: "POST",
		url: "/admin/userList.do?cmd=useYesUser",
		dataType: "json",
		data : $("#adminAccountForm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			alert("회원 사용처리 완료되었습니다.");
			location.reload(true);
		}
	});
}

function openUserDetail(id){
    window.open("/admin/user.do?id=" + id, 'popup', "toolbar=no,location=no,directories=no,status=no,menubar=no,width=550px,height=450,resizable=yes,scrollbars=auto");
}

function isCheckUser(){
	if($("#user:checked").length == 0){
		alert("탈퇴할 계정을 선택하십시오.");
		return false;
	}
	return true;
}

// 회원 탈퇴처리
function deleteUser(){
	if(!isCheckUser()){ return ; }
	
	$.ajax({
		type: "POST",
		url: "/admin/userList.do?cmd=deleteUser",
		dataType: "json",
		data : $("#adminAccountForm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			alert("탈퇴처리 완료되었습니다.");
			location.reload(true);
		}
	});
}

// 회원 검색
function search(){
	if($("#searchValue").val() == ''){
		alert('검색어를 입력하십시오.');
		return;
	}
	$("#mode").val("S");	// S : 검색 모드, N : 일반 모드
	$.ajax({
		type: "POST",
		url: "/admin/userList.do?cmd=selectUserCount",
		dataType: "json",
		data : $("#adminAccountForm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			if(Number(data.count) >= 100){
				if(confirm("검색 대상자가 " + data.count + "건입니다. 검색하시겠습니까?")){
					$("#adminAccountForm").submit();
				}
			}else{
				$("#adminAccountForm").submit();
			}
		}
	});
}