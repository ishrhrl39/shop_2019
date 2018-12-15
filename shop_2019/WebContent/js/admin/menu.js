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
		openMenuPopup($(this));
	});
	
	$("#deleteMenuBtn").click(function(){
		deleteMenu();
	});
	
	$("#updateMenuNmBtn").click(function(){
		updateMenu();
	});
	
	$(".moveItemBtn").click(function(){
		moveMenuItem($(this));
	});
	
	// 메뉴 순서저장
	$("#saveOrder").click(function(){
		saveMenuOrder();
	});
});

// 메뉴 등록
function insertMenu(){
	var menuNm = $("#menuNm").val();
	if(menuNm == ''){
		alert("메뉴를 입력하십시오.");
		return;
	}else if($("#link_url").val() == ''){
		alert("링크 URL을 입력하십시오");
		return;
	}
	
	var isMenuNm = false;
	$("#menuList > option").each(function(){
		if($(this).text() == menuNm){
			isMenuNm = true;
		}
	});
	
	if(isMenuNm){
		alert("이미 등록되있는 메뉴명입니다.");
		return;
	}
	
	var len = $("#menuList > option").length;
	console.log("menuList size() => " + len);
	if(len == 0){	// 메뉴가 아무것도 없을 경우
		$("#orderNo").val(1);	// order 1번
	}else{
		$("#orderNo").val(len+1);
	}
	
	
	$.ajax({
		type: "POST",
		url: "/admin/menu.do?cmd=insertMenu",
		dataType: "json",
		data : $("#menuFrm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			location.href = "/admin/menu.do";
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
	$(".moveItemBtn").attr("disabled", false);
	$("#saveOrder").attr("disabled", false);
}

// 메뉴 삭제
function deleteMenu(){
	var selectOption = $("#menuList option:selected");
	if(selectOption == null){
		alert("삭제할 메뉴를 선택하세요.");
		return;
	}
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

// 메뉴 수정
function updateMenu(){
	if($("#popup_menuNm").val() == ''){
		alert("메뉴명을 입력하십시오.");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "/admin/menu.do?cmd=updateMenu",
		dataType: "json",
		data : $("#menuUpdateFrm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			location.href = "/admin/menu.do";
		}
	});
}

// 메뉴 수정팝업
function openMenuPopup(option){
	$("#menuPopup").modal();
	$("#popup_menuCd").val(option.val());
	
	$.ajax({
		type: "POST",
		url: "/admin/menu.do?cmd=selectMenuOne",
		dataType: "json",
		data : { menu_cd : $("#popup_menuCd").val() },
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			$("#popup_menuNm").val(option.text());
			$("#popup_menuUrl").val(data.menu.link_url);
		}
	});
}

// 메뉴 순서변경
function moveMenuItem(btn){
	var id = btn.attr('id');
	
    var selIndex = $("#menuList option:selected").index();              // Selected Index
    var elementLength = $("#menuList > option").length;        // Select Element Item Length
    var selText = $("#menuList option:eq(" + selIndex + ")").text();      // Selected Item Text
    var selValue = $("#menuList option:eq(" + selIndex + ")").val();    // Selected Item Value

	if(id == 'moveTopBtn'){	// 선택한 항목을 위로 이동
		if(selIndex-1 < 0) return;
        var oldText = $("#menuList option:eq(" + (selIndex - 1) + ")").text();
        var oldValue = $("#menuList option:eq(" + (selIndex - 1) + ")").val();
        $("#menuList option:eq(" + (selIndex - 1) + ")").text(selText);
        $("#menuList option:eq(" + (selIndex - 1) + ")").val(selValue);
        $("#menuList option:eq(" + (selIndex) + ")").text(oldText);
        $("#menuList option:eq(" + (selIndex) + ")").val(oldValue);
        $("#menuList option:eq(" + (selIndex - 1) + ")").prop("selected", true);	
        $("#menuList option:eq(" + (selIndex) + ")").prop("selected", false);	
	}else{	// 선택한 항목을 아래로 이동
		if(selIndex+2 > elementLength) return;
        var oldText = $("#menuList option:eq(" + (selIndex + 1) + ")").text();
        var oldValue = $("#menuList option:eq(" + (selIndex + 1) + ")").val();
        $("#menuList option:eq(" + (selIndex + 1) + ")").text(selText);
        $("#menuList option:eq(" + (selIndex + 1) + ")").val(selValue);
        $("#menuList option:eq(" + (selIndex) + ")").text(oldText);
        $("#menuList option:eq(" + (selIndex) + ")").val(oldValue);
        $("#menuList option:eq(" + (selIndex + 1) + ")").prop("selected", true);	
        $("#menuList option:eq(" + (selIndex) + ")").prop("selected", false);	
	}
}

// 메뉴 순서저장
function saveMenuOrder(){
	
/*	
	
	$.ajax({
		type: "POST",
		url: "/admin/menu.do?cmd=selectMenuOne",
		dataType: "json",
		data : { menu_cd : $("#popup_menuCd").val() },
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			$("#popup_menuNm").val(option.text());
			$("#popup_menuUrl").val(data.menu.link_url);
		}
	});
	*/
}