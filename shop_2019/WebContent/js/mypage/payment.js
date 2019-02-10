$(document).ready(function(){
	$("#searchBtn").click(function(){
		search();
	});
});

function openTattooDetail(id){
	location.href = "/tattoo/detail.do?id=" + id;
}


function search(){
	if($("#searchValue").val() == ''){
		alert('검색어를 입력하십시오.');
		return;
	}
	$("#paymentForm").submit();
}