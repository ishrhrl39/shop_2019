$(document).ready(function() {
	$("#addTatooistBtn").click(function(){
		addTatooist();
	});
	
	$("#deleteTatooistBtn").click(function(){
		deleteTatooist();
	});
	
	$("#updateTatooistBtn").click(function(){
		updateTatooist();
	});
});


function addTatooist(){
	if($("#name").val() == ''){
		alert("담당자명을 입력하십시오.");
		return;
	}else if($("#career").val() == ''){
		alert("경력을 입력하십시오.");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "/admin/tattooist.do?cmd=addTatooist",
		dataType: "json",
		data : $("#tattooist_frm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			if(data.result == 1){
				alert("등록이 완료되었습니다.");
				location.href = "/admin/tattooist.do";
			}
		}
	});
}

function updateTatooist(){
	if($("#up_name").val() == ''){
		alert("담당자명을 입력하십시오.");
		return;
	}else if($("#up_career").val() == ''){
		alert("경력을 입력하십시오.");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "/admin/tattooist.do?cmd=updateTatooist",
		dataType: "json",
		data : $("#tattooist_update_frm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			if(data.result == 1){
				alert("수정이 완료되었습니다.");
				location.href = "/admin/tattooist.do";
			}
		}
	});
}


function deleteTatooist(){
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
		url: "/admin/tattooist.do?cmd=deleteTatooist",
		dataType: "json",
		data : $("#tattooist_frm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			if(data.result == 1){
				alert("삭제이 완료되었습니다.");
				location.href = "/admin/tattooist.do";
			}
		}
	});
}

function openModal(seq){
	$.ajax({
		type: "POST",
		url: "/admin/tattooist.do?cmd=selectTattooistOne",
		dataType: "json",
		data : {"seq" : seq},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			var tattooist = data.tattooist;
			$("#up_seq").val(tattooist.SEQ);
			$("#up_name").val(tattooist.NAME);
			$("#up_career").val(tattooist.CAREER);
		}
	});
}