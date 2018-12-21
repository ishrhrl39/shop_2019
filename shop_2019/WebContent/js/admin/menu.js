$(document).ready(function() {
	// 그룹 메뉴 추가
	$("#insertMenuBtn").click(function(){
		insertMenu();
	});
	
	// 서브 메뉴 추가
	$("#sub_insertMenuBtn").click(function(){
		insertSubMenu();
	});
	
	$("#search").keyup(function(){
		searchMenu();
	});
	
	// 키보드 - 그룹메뉴 항목 선택시 액션
	$("#menuList").bind('keyup', function(e) {
		optionFocus($("#menuFrm option:selected"));
	});
	
	// 마우스 - 그룹메뉴 항목 선택시 액션
	$("#menuList").click(function(){
		optionFocus($("#menuList option:selected"));
	});
	
	$("#menuList").dblclick(function(){
		openMenuPopup($("#menuList option:selected"));
	});
	
	// 마우스 - 서브메뉴 항목 선택시 액션
	$("#sub_menuList").click(function(){
		subOptionFocus($("#sub_menuList option:selected"));
	});
	
	$("#sub_menuList").dblclick(function(){
		openSubMenuPopup($("#sub_menuList option:selected"));
	});
	
	$("#deleteMenuBtn").click(function(){
		deleteMenu();
	});
	
	$("#sub_deleteMenuBtn").click(function(){
		deleteSubMenu();
	});
	
	// 그룹 메뉴 수정
	$("#updateMenuNmBtn").click(function(){
		updateMenu();
	});
	
	// 서브 메뉴 수정
	$("#updateSubMenuNmBtn").click(function(){
		updateSubMenu();
	});
	
	// 그룹메뉴 순서변경 
	$(".moveItemBtn").click(function(){
		moveMenuItem($(this));
	});
	
	// 서브메뉴 순서변경
	$(".moveSubItemBtn").click(function(){
		moveSubMenuItem($(this));
	});
	
	// 그룹 메뉴 순서저장
	$("#saveOrder").click(function(){
		saveMenuOrder();
	});
	
	// 서브 메뉴 순서저장
	$("#sub_saveOrder").click(function(){
		saveSubMenuOrder();
	});
});

// 그룹 메뉴 등록
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

// 서브 메뉴 등록
function insertSubMenu(){
	var menuCd = $("#menuList option:selected").val();
	var subMenuNm = $("#subMenuNm").val();
	if(menuCd == null){
		alert("그룹 메뉴를 선택하십시오.");
		return;
	}
	
	if(subMenuNm == ''){
		alert("메뉴를 입력하십시오.");
		return;
	}else if($("#sub_link_url").val() == ''){
		alert("링크 URL을 입력하십시오");
		return;
	}
	
	var isMenuNm = false;
	$("#sub_menuList > option").each(function(){
		if($(this).text() == subMenuNm){
			isMenuNm = true;
		}
	});
	
	if(isMenuNm){
		alert("이미 등록되있는 서브 메뉴명입니다.");
		return;
	}
	
	var len = $("#sub_menuList > option").length;
	console.log("sub_menuList size() => " + len);
	if(len == 0){	// 메뉴가 아무것도 없을 경우
		$("#subOrderNo").val(1);	// order 1번
	}else{
		$("#subOrderNo").val(len+1);
	}
	
	$("#menuCd").val(menuCd);
	
	$.ajax({
		type: "POST",
		url: "/admin/menu.do?cmd=insertSubMenu",
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
	
	$.ajax({
		type: "POST",
		url: "/admin/menu.do?cmd=selectSubMenu",
		dataType: "json",
		data : { menuCd : option.val() },
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			$("#sub_menuList").html("");
			
			$(data.subMenuList).each(function(){
				$("#sub_menuList").append("<option value='" + this.sub_menu_cd + "'>" + this.sub_menu_nm + "</option>");
			});
		}
	});
}

// 서브 메뉴 선택시 옵션
function subOptionFocus(option){
	$("#sub_deleteMenuBtn").attr("disabled", false);
	$(".moveSubItemBtn").attr("disabled", false);
	$("#sub_saveOrder").attr("disabled", false);
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

// 서브메뉴 삭제
function deleteSubMenu(){
	var selectOption = $("#sub_menuList option:selected");
	if(selectOption == null){
		alert("삭제할 서브메뉴를 선택하세요.");
		return;
	}
	$("#menuCd").val(selectOption.val());
	$("#subMenuCd").val(selectOption.val());
	
	$.ajax({
		type: "POST",
		url: "/admin/menu.do?cmd=deleteSubMenu",
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

// 서브 메뉴 수정
function updateSubMenu(){
	if($("#popup_subMenuNm").val() == ''){
		alert("서브 메뉴명을 입력하십시오.");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "/admin/menu.do?cmd=updateSubMenu",
		dataType: "json",
		data : $("#subMenuUpdateFrm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			location.href = "/admin/menu.do";
		}
	});
}

// 메뉴 수정팝업
function openMenuPopup(option){
	$("#menuPopup").modal();
	$("#menuPopup #popup_menuCd").val(option.val());
	
	$.ajax({
		type: "POST",
		url: "/admin/menu.do?cmd=selectMenuOne",
		dataType: "json",
		data : { menu_cd : $("#menuPopup #popup_menuCd").val() },
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			$("#popup_menuNm").val(data.menu.menu_nm);
			$("#popup_menuUrl").val(data.menu.link_url);
		}
	});
}

// 서브메뉴 수정팝업
function openSubMenuPopup(option){
	$("#subMenuPopup").modal();
	
	$("#popup_subMenuCd").val(option.val());
	$("#subMenuPopup #popup_menuCd").val($("#menuList option:selected").val());
	
	$.ajax({
		type: "POST",
		url: "/admin/menu.do?cmd=selectSubMenuOne",
		dataType: "json",
		data : { 
			menu_cd : $("#subMenuPopup #popup_menuCd").val(), 
			sub_menu_cd : $("#popup_subMenuCd").val()
		},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			$("#popup_subMenuNm").val(option.text());
			$("#popup_subMenuUrl").val(data.menu.link_url);
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

// 서브 메뉴 순서변경
function moveSubMenuItem(btn){
	var id = btn.attr('id');
	
    var selIndex = $("#sub_menuList option:selected").index();              // Selected Index
    var elementLength = $("#sub_menuList > option").length;        // Select Element Item Length
    var selText = $("#sub_menuList option:eq(" + selIndex + ")").text();      // Selected Item Text
    var selValue = $("#sub_menuList option:eq(" + selIndex + ")").val();    // Selected Item Value

	if(id == 'sub_moveTopBtn'){	// 선택한 항목을 위로 이동
		if(selIndex-1 < 0) return;
        var oldText = $("#sub_menuList option:eq(" + (selIndex - 1) + ")").text();
        var oldValue = $("#sub_menuList option:eq(" + (selIndex - 1) + ")").val();
        $("#sub_menuList option:eq(" + (selIndex - 1) + ")").text(selText);
        $("#sub_menuList option:eq(" + (selIndex - 1) + ")").val(selValue);
        $("#sub_menuList option:eq(" + (selIndex) + ")").text(oldText);
        $("#sub_menuList option:eq(" + (selIndex) + ")").val(oldValue);
        $("#sub_menuList option:eq(" + (selIndex - 1) + ")").prop("selected", true);	
        $("#sub_menuList option:eq(" + (selIndex) + ")").prop("selected", false);	
	}else{	// 선택한 항목을 아래로 이동
		if(selIndex+2 > elementLength) return;
        var oldText = $("#sub_menuList option:eq(" + (selIndex + 1) + ")").text();
        var oldValue = $("#sub_menuList option:eq(" + (selIndex + 1) + ")").val();
        $("#sub_menuList option:eq(" + (selIndex + 1) + ")").text(selText);
        $("#sub_menuList option:eq(" + (selIndex + 1) + ")").val(selValue);
        $("#sub_menuList option:eq(" + (selIndex) + ")").text(oldText);
        $("#sub_menuList option:eq(" + (selIndex) + ")").val(oldValue);
        $("#sub_menuList option:eq(" + (selIndex + 1) + ")").prop("selected", true);	
        $("#sub_menuList option:eq(" + (selIndex) + ")").prop("selected", false);	
	}
}


// 메뉴 순서저장
function saveMenuOrder(){
	var items = "";
	$("#menuList > option").each(function(){
		items += $(this).val() + ",";
	});
	
	if(items == ""){
		alert("순서를 저장할 메뉴가 없습니다.");
		return;
	}else{
		items = items.substring(0, items.length-1);
	}
	
	
	$.ajax({
		type: "POST",
		url: "/admin/menu.do?cmd=updateMenuOrder",
		dataType: "json",
		data : { items : items },
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			alert("저장이 완료되었습니다.");
		}
	});
}

// 서브 메뉴 순서저장
function saveSubMenuOrder(){
	var items = "";
	$("#sub_menuList > option").each(function(){
		items += $(this).val() + ",";
	});
	
	if(items == ""){
		alert("순서를 저장할 메뉴가 없습니다.");
		return;
	}else{
		items = items.substring(0, items.length-1);
	}
	
	$.ajax({
		type: "POST",
		url: "/admin/menu.do?cmd=updateSubMenuOrder",
		dataType: "json",
		data : { 
			items : items,
			menu_cd : $("#menuList option:selected").val()
		},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			alert("저장이 완료되었습니다.");
		}
	});
}