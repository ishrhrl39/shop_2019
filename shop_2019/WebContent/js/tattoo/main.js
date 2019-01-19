$(document).ready(function(){
	// 타투상품 등록하러 가기
	$("#goInsertGoodsBtn").click(function(){
		goInsertGoods();
	});
	
	// 상품 검색
	$("#searchBtn").click(function(){
		searchGoods();
	});
	
	// 전체보기
	$("#allSelectBtn").click(function(){
		allSelect();
	});
	
	// 타투상품 삭제
	$("#goDeleteGoodsBtn").click(function(){
		goDeleteGoods();
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

// 페이지 이동 시 이동 url
function go(url){
	$("#tattooForm").attr("action", url);
	$("#tattooForm").submit();
}

// 상세보기 페이지로 넘어가기
function moveDetail(id){
	location.href = "/tattoo/detail.do?id="+id;
}


// 전체보기로 이동
function allSelect(){
	var goods = $("#goods").val();
	location.href ="/tattoo/list.do?goods="+goods;
}

// 선택된 상품 삭제
function goDeleteGoods(){
	var arr = new Array();
	
	$('input[name="checkGoods"]:checked').each(function(){
		arr.push($(this).val());
	});
	
	var data = arr.join(",");
	
	$.ajax({
		type: "POST",
		url: "/tattoo/list.do?cmd=delete",
		dataType: "json",
		data : "data="+data,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
				alert("삭제 완료되었습니다.");
				location.reload(true);
		}
	});
	
	
	
	
	
	
}



