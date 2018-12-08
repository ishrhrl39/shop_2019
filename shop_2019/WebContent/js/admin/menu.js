$(document).ready(function() {
	$("#insertMenuBtn").click(function(){
		insertMenu();
	});
	
	$("#search").keyup(function(){
		searchMenu();
	});
	
	$("#menuFrm option").click(function(){
		optionFocus($(this));
	});
	
	$("#menuFrm option").dblclick(function(){
		openMenuPopup();
	});
	
	$("#deleteMenuBtn").click(function(){
		deleteMenu();
	});
});

// 메뉴 등록
function insertMenu(){
	var menuNm = $("#menuNm").val();
	if(menuNm == ''){
		alert("메뉴를 입력하십시오.");
		return;
	}
	
	var len = $("#menuList > option").length;
	if(len == 0){	// 메뉴가 아무것도 없을 경우
		$("#orderNo").val(1);	// order 1번
	}else{
		$("#orderNo").val(len);
	}
	
	
	$.ajax({
		type: "POST",
		url: "/admin/menu.do?cmd=insertMenu",
		dataType: "json",
		data : $("#menuFrm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			var menu = data.menu;
			$("#menuList").append("<option value='" + menu.menu_cd + "'>" + menu.menu_nm + "</option>");
			$("#menuNm").val("");
			$("#deleteMenuBtn").attr("disabled", true);
		}
	});
	
}

// 메뉴 검색
function searchMenu(){
	var search = $("#search").val();
	$("#menuList > option").each(function(){
		if($(this).text().indexOf(search) > -1){
			$(this).css("display", "block");
		}else{
			$(this).css("display", "none");
		}
	});
}

// 그룹 메뉴 선택시 액션
function optionFocus(option){
	$("#deleteMenuBtn").attr("disabled", false);
}

// 메뉴 삭제
function deleteMenu(){
	var selectOption = $("#menuList option:selected");
	$("#menuCd").val(selectOption.val());
	
	$.ajax({
		type: "POST",
		url: "/admin/menu.do?cmd=deleteMenu",
		dataType: "json",
		data : $("#menuFrm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			selectOption.remove();
		}
	});
}

// 메뉴 수정팝업
function openMenuPopup(){
	$("#menuPopup").show();
}