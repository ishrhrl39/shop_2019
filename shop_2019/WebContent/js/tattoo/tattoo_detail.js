$(document).ready(function(){
//	loadPreview();
	
	$("#reserveBtn").click(function(){
		reserve();
	});
});


//function loadPreview(){
//	$("#preview_layout").html($(opener.document).find("#content").val());
//}

// 예약하기
function reserve(){
	$("#reserveForm").submit();
}