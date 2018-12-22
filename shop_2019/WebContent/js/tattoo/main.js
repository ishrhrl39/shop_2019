$(document).ready(function(){
	// 타투상품 등록하러 가기
	$("#goInsertGoodsBtn").click(function(){
		goInsertGoods();
	});
});

// 타투상품 등록하러 가기
function goInsertGoods(){
	var goods = $("#goods").val();
	location.href = "/tattoo/list.do?cmd=insert&goods=" + goods;
}
