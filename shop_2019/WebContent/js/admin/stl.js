$(document).ready(function() {
	
});

//결제 처리
function updateStlSts(sn, sts){
	$.ajax({
		type: "POST",
		url: "/admin/stl.do?cmd=updateStlSts",
		dataType: "json",
		data : { paymentSn : sn, cmpl_yn : sts},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			if(sts == 'Y'){
				alert("결제처리 완료되었습니다.");
			}else if(sts == 'X'){
				alert("결제취소 완료되었습니다.");
			}
			location.reload(true);
		}
	});
}
