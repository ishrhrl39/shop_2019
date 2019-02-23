$(document).ready(function(){
	// 체크박스 전체 선택 여부
	$("#allBasketcheck").click(function(){
		checkSelect();
	});
	
	// 장바구니 삭제
	$("#basketDelBtn").click(function(){
		deleteBasket();
	});
});


function checkSelect(){
	var checkbox = $("input:checkbox[class='basketCheck']");
	if($("input:checkbox[id='allBasketcheck']").is(":checked") == true){
		checkbox.prop("checked", true); 
	}else{
		checkbox.prop("checked", false); 
	}
}

function deleteBasket(){
	var value = new Array();
	$(".basketCheck:checked").each(function(){ // class는 결국은 배열이여서 (여러개일 때) 반복문 가능
//		if($(this).is(":checked"))
		value.push($(this).val());
	});
	var data = value.join(",");
	

	$.ajax({
		type: "POST",
		url: "/mypage/basket.do?cmd=deleteBasket",
		dataType: "json",
		data : "data="+data,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			alert("장바구니에서 삭제되었습니다.");
			location.reload();
			
		}
	});
}

function onBasketSubmit(sn){
	$("#basketForm").attr("action", "/mypage/basket.do?cmd=sendReserve");
	$("#basketForm #basketSn").val(sn);
	
	$("#basketForm").submit();
}
