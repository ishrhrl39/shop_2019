$(document).ready(function(){
	$("#orderBtn").click(function(){
		order();
	});
});


function order(){
	
	$.ajax({
		type: "POST",
		url: "payment.do?cmd=order",
		dataType: "json",
		data : $("#orderForm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			location.href ="/index.do";
			
		}
	});
	
}


