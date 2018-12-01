$(document).ready(function() {
	$("#searchBtn").click(function(){
		search();
	});
	
	$("#searchValue").keydown(function(key){
		if(key.keyCode == 13){
			search();
			return false;
		}
	});
});


function openUserDetail(id){
    window.open("/admin/user.do?id=" + id, 'popup', "toolbar=no,location=no,directories=no,status=no,menubar=no,width=550px,height=440,resizable=yes,scrollbars=auto");
}

// 회원 검색
function search(){
	if($("#searchValue").val() == ''){
		alert('검색어를 입력하십시오.');
		return;
	}
	$("#mode").val("S");
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