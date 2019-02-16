$(document).ready(function(){
//	loadPreview();
	
	$("#reserveBtn").click(function(){
		reserve();
	});
	
	$("#basketBtn").click(function(){
		basket();
	});
});


//function loadPreview(){
//	$("#preview_layout").html($(opener.document).find("#content").val());
//}

// 예약하기
function reserve(){
	$("#reserveForm").attr("action","/tattoo/payment.do");
	$("#reserveForm").submit();
}


// 장바구니
function basket(){
	var con = confirm("1개의 도안이 장바구니에 담겼습니다. 지금 확인하시겠습니까?");
	if(con == true){
		// 장바구니 테이블에 삽입
		$.ajax({
			type: "POST",
			url: "/mypage/basket.do?cmd=insert",
			dataType: "json",
			data : $("#reserveForm").serialize(),
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			success: function(data){
				location.href = "/mypage/basket.do?cmd=list";
//				$("#reserveForm").attr("action","/mypage/basket.do");
//				$("#reserveForm").submit();
			}
		});
	}else{
		return;
	}
	

}