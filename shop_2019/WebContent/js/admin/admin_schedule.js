$(document).ready(function() {
	$("#deleteSchduleBtn").click(function(){
		deleteSchdule();
	});
	
	$("#deleteTatooistBtn").click(function(){
		deleteTatooist();
	});
	
	$("#updateTatooistBtn").click(function(){
		updateTatooist();
	});
	
	$("#searchScheduleBtn").click(function(){
		searchSchedule();
	});
	
	$("#searchAllScheduleBtn").click(function(){
		location.href = "/admin/schedule.do";
	});
});




function deleteSchdule(){
	var cnt = 0;
	$(".delete_key:checked").each(function(){
		cnt++;
	});
	
	if(cnt == 0){
		alert("삭제할 스케줄을 선택하십시오.");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "/admin/schedule.do?cmd=deleteSchdule",
		dataType: "json",
		data : $("#tattooist_frm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			alert("삭제이 완료되었습니다.");
			location.reload(true);
		}
	});
}

function searchSchedule(){
	$("#tattooist_frm").submit();
}
