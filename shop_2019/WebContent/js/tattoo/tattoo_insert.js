$(document).ready(function(){
	$("#insertBtn").click(function(){
		insertTattoo();
	});
	
	$("#previewContentBtn").click(function(){
		window.open("/tattoo/preview.do", "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,top=50,left=50,width=650,height=800");
	});
	
	$("#cancelInsertBtn").click(function(){
		location.href = "/tattoo/list.do?goods=" + $("#goods").val();
	});
	
	$("#color").attr("disabled", true);
	$("[name=sale_option]").click(function(){
		if($(this).val() == 'all'){
			$("#color_list").val('all');
			$("#color").attr("disabled", true);
		}else{
			$("#color_list").val('');
			$("#color").attr("disabled", false);
			
		}
	});
});

// 타투 상품 등록
function insertTattoo(){

	var arr = new Array();
	var nm = $("#nm").val();
	var image = $("#image").val();
	var price = $("#price").val();
	var content = $("#content").val();
	
	if(nm == '' || nm.length == 0){
		alert("상품명을 입력하십시오.");
		return;
	}else if(image == "" || image.length == 0){
		alert("이미지를 업로드하십시오.");
		return;
	}else if(price == "" || price.length == 0){
		alert("상품 가격을 입력하십시오.");
		return;
	}else if(content == "" || content.length == 0){
		alert("상품 내용을 입력하십시오.");
		return;
	}
	
	if($("#color_list").val() == "all"){
		arr.push("all");
	}else{
		$("#color > option").each(function(){
			if($(this).is(":selected")){
				arr.push($(this).val());
			}
		});
		$("#color_list").val(arr.join(","));
	}
	
	if(arr.length == 0){
		alert('색상을 선택하십시오.');
		return;
	}
	
	if(!checkImage()){
		alert('썸네일은 이미지 파일(jpg, png, gif, bmp)만 등록 가능합니다.');
		return;
	}
	
	
	$("#insertTattooFrm").submit();
//	$.ajax({
//        type : 'post',
//        url : '/tattoo/list.do?cmd=insertProc',
//        data : $("#insertTattooFrm").serialize(),
//        contentType: true,
//        success : function(html) {
//            alert("파일 업로드하였습니다.");
//        },
//        error : function(error) {
//            alert("파일 업로드에 실패하였습니다.");
//            console.log(error);
//            console.log(error.status);
//        }
//    });
}

function checkImage(){
	var thumbext = $("#image").val(); //파일을 추가한 input 박스의 값
	thumbext = thumbext.slice(thumbext.indexOf(".") + 1).toLowerCase(); //파일 확장자를 잘라내고, 비교를 위해 소문자로 만듭니다.
	if(thumbext != "jpg" && thumbext != "png" &&  thumbext != "gif" &&  thumbext != "bmp"){ //확장자를 확인합니다.
		return false;
	}else{
		return true;
	}
}