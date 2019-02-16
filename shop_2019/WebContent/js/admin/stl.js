$(document).ready(function() {
	$("#updateScheduleBtn").click(function(){
		updateSchedule();
	});
});

//결제 처리
function updateStlSts(sn, sts, tattooist, dtm){
	$.ajax({
		type: "POST",
		url: "/admin/stl.do?cmd=updateStlSts",
		dataType: "json",
		data : { paymentSn : sn, cmpl_yn : sts, tattooistNm : tattooist, reservedDtm : dtm},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			if(data.result == "OK"){
				if(sts == 'Y'){
					alert("결제처리 완료되었습니다.");
				}else if(sts == 'X'){
					alert("결제취소 완료되었습니다.");
				}
				location.reload(true);
			}else if(data.result == "EXIST"){
				alert("이미 담당자가 스케줄이 존재합니다.");
				$("#reservation_popup").modal('toggle');
				$("#payment_sn").val(sn);
				$("#tattooist_name").val(tattooist);
				$("#reserve_dt").val(dtm.substring(0,8));
			}
		}
	});
}

// 스케줄 수정
function updateSchedule(){
	$.ajax({
		type: "POST",
		url: "/admin/stl.do?cmd=updateSchedule",
		dataType: "json",
		data : $("#scheduleForm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			if(data.result == "OK"){
				alert("결제처리 완료되었습니다.");
				location.reload(true);
			}else if(data.result == "EXIST"){
				alert("이미 담당자가 스케줄이 존재합니다.");
			}
		}
	});
}