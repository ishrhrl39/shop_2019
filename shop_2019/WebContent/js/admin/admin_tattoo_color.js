$(document).ready(function() {
	$("#addTattooColorBtn").click(function(){
		addTattooColor();
	});
	
	$("#deleteTattooColorBtn").click(function(){
		deleteTattooColor();
	});
});


function addTattooColor(){
	if($("#color").val() == ''){
		alert("색상명을 입력하십시오.");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "/admin/tattoo_color.do?cmd=addTattooColor",
		dataType: "json",
		data : $("#tattoo_color_frm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			if(data.result == 1){
				alert("등록이 완료되었습니다.");
				location.href = "/admin/tattoo_color.do";
			}
		}
	});
}



function deleteTattooColor(){
	var cnt = 0;
	$(".delete_seq:checked").each(function(){
		cnt++;
	});
	
	if(cnt == 0){
		alert("삭제할 담당자를 선택하십시오.");
		return;
	}
	
	
	$.ajax({
		type: "POST",
		url: "/admin/tattoo_color.do?cmd=deleteTattooColor",
		dataType: "json",
		data : $("#tattoo_color_frm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			if(data.result == 1){
				alert("삭제이 완료되었습니다.");
				location.href = "/admin/tattoo_color.do";
			}
		}
	});
}
