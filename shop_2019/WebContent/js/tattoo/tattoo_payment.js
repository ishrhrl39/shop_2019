$(document).ready(function(){
	$("#orderBtn").click(function(){
		order();
	});
});


function order(){
	if(!$("#orderAgree").is(":checked")){
		alert("주문 동의를 체크하여 주십시오.");
		return;
	}else if($("#name").val() == ""){
		alert("예약자 이름을 입력하십시오.");
		return;
	}else if($("#email").val() == ""){
		alert("예약자 이메일을 입력하십시오.");
		return;
	}else if($("#phone").val() == ""){
		alert("예약자 연락처를 입력하십시오.");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "payment.do?cmd=order",
		dataType: "json",
		data : $("#orderForm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			alert("구매 완료되었습니다.");
			location.href ="/mypage/myInfo.do?cmd=payment";
			
		}
	});
	
}


