$(document).ready(function(){
	// 타투상품 등록하러 가기
	$("#goInsertGoodsBtn").click(function(){
		goInsertGoods();
	});
	
	// 상품 검색
	$("#searchBtn").click(function(){
		searchGoods();
	});
});

// 타투상품 등록하러 가기
function goInsertGoods(){
	var goods = $("#goods").val();
	location.href = "/tattoo/list.do?cmd=insert&goods=" + goods;
}


// 상품 검색
function searchGoods(){
	if($("#nm").val() == ""){
		alert("검색어를 입력하십시오");
		return;
	}
	$("#tattooForm").submit();
}

function go(url){
	$("#tattooForm").attr("action", url);
	$("#tattooForm").submit();
}