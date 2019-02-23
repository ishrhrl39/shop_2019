$(document).ready(function() {
	// FAQ 등록
	$("#addFaqBtn").click(function(){
		addFaq();
	});
	
	$("#deleteFaqBtn").click(function(){
		deleteFaq();
	});
});

function addFaq(){
	var title = $("#title2").val();
	var content = $("#content").val();
	
	if(title == '' || title.length == 0){
		alert("FAQ 제목을 입력하십시오.");
		return;
	}else if(content == '' || content.length == 0){
		alert("FAQ 내용을 입력하십시오.");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "/admin/faqList.do?cmd=insert",
		dataType: "json",
		data : $("#faq_frm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			alert("FAQ 등록 완료되었습니다.");
			location.reload(true);
		}
	});
}


function updateFaq(no){
	$.ajax({
		type: "POST",
		url: "/admin/faqList.do?cmd=updateFaq&paramNo=" + no,
		dataType: "json",
		data : $("#faq_frm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			alert("FAQ 수정 완료되었습니다.");
		}
	});
}


function deleteFaq(){
	if($(".faqNo:checked").length == 0){
		alert("삭제할 FAQ를 선택하십시오.");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "/admin/faqList.do?cmd=deleteFaq",
		dataType: "json",
		data : $("#faq_frm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			alert("FAQ 삭제가 완료되었습니다.");
			location.reload(true);
		}
	});
}