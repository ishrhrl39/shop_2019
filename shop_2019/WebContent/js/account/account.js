$(document).ready(function() {
	setDate();
	// 회원가입
	$("#joinBtn").click(function(){
		join();
	});
	
	// 아이디 중복 체크
	$("#duplCheckIdBtn").click(function(){
		duplCheckId();
	});
	
	// 전체동의를 눌렀을 때
	$("#fullagree").click(function(){
		if($('input:checkbox[id="fullagree"]').is(":checked")){
			$('input:checkbox[id="useable"]').attr("checked", true);
			$('input:checkbox[id="personalable"]').attr("checked", true);
		}else if(!$('input:checkbox[id="fullagree"]').is(":checked")){
			$('input:checkbox[id="useable"]').attr("checked", false);
			$('input:checkbox[id="personalable"]').attr("checked", false);
		}
	});
	
	// 아이디를 입력했을 경우
	$("#id").keyup(function(){ 
		$("#checkId").val("N");
	});
	
	// 아이디 찾기
	$("#findId").click(function(){
		findId();
	});
	
	// 비밀번ㅌ호 찾기
	$("#findPwd").click(function(){
		findPwd();
	});
	
	// 로그인 페이지로 이동
	$("#login").click(function(){
		location.href = "/account/login.do";
	});

});

// 날짜 불러오기
function setDate() {
	var dt = new Date();
	var year = dt.getFullYear();
	var month = dt.getMonth() + 1;
	var date = dt.getDate();

	var optionY = "";
	for ( var i = year - 50; i <= year; i++) {
		if (year == i) {
			optionY += "<option value='" + i + "' selected>";
		} else {
			optionY += "<option value='" + i + "'>";
		}
		optionY += i;
		optionY += "</option>";

	}
	$("#year").html(optionY);

	var optionM = "";
	for ( var i = 1; i <= 12; i++) {
		var m = i;
		if((i + "").length == 1){
			m = "0" + i;
		}
		if (month == i) {
			optionM += "<option value='" + m + "' selected>";
		} else {
			optionM += "<option value='" + m + "'>";
		}
		optionM += i;
		optionM += "</option>";

	}
	$("#month").html(optionM);

	var optionD = "";
	for ( var i = 1; i <= 31; i++) {
		var d = i;
		if((i + "").length == 1){
			d = "0" + i;
		}
		if (date == i) {
			optionD += "<option value='" + d + "' selected>";
		} else {
			optionD += "<option value='" + d + "'>";
		}
		optionD += d;
		optionD += "</option>";

	}
	$("#date").html(optionD);
}

//아이디 중복 체크 
function duplCheckId(){
	var id = $("#id").val();
	
	if( id == "" || id.length == 0){
		alert("아이디를 입력하세요");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "account.do?cmd=duplCheckId",
		dataType: "json",
		data : "id="+id,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			if(data.result=="true"){
				alert("중복된 아이디입니다.");
				return;
			}else{
				alert("사용가능한 아이디입니다.");
				$("#checkId").val("Y");
			}
		}
	});
}

// 회원가입
function join(){
	var name = $("#name").val();
	var id = $("#id").val();
	var pass_wd = $("#pass_wd").val();
	var repass_wd = $("#repass_wd").val();
	var email = $("#email").val();
	var tel = $("#tel").val();
	// 숫자 정규식 표현
	var regexP = /^[0-9]*$/;
	// 이메일 정규식 표현
	var regexE=/^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{1,5}$/;
	// 비밀번호 정규식 표현
	var passwordRules = /^[a-zA-Z0-9]{8,15}$/;

	// 유효성 체크
	if( name == "" || name.length == 0){
		alert("이름을 입력하세요");
		return;
	}else if( pass_wd == "" || pass_wd.length == 0){
		alert("비밀번호를 입력하세요");
		return;
	}else if(!passwordRules.test(pass_wd)){
		alert("비밀번호는 숫자와 영문자 조합으로 8~15자리를 사용해야 합니다.");
		return;
	}else if( repass_wd == "" || repass_wd.length == 0){
		alert("비밀번호 확인을 입력하세요");
		return;
	}else if(!passwordRules.test(repass_wd)){
		alert("숫자와 영문자 조합으로 10~15자리를 사용해야 합니다.");
		return;
	}else if( email == "" || email.length == 0){
    	alert("이메일을 입력하세요");
    	return;
	}else if(!regexE.test(email)){
		alert("이메일 형식으로 입력하세요");
    	return;
	}else if( tel == "" || tel.length == 0){
    	alert("휴대폰 번호를 입력하세요");
    	return;
	}else if(!regexP.test(tel)){
		alert("휴대폰 번호는 숫자만 입력하세요");
		return;
	}	
	
	// 중복확인을 하지 않았을 경우
	if($("#checkId").val()=="N"){
		alert("중복확인 체크가 필요합니다.");
		return;
	}
	
	// 필수 값이 체크 되어 있으면
	if(!$('input:checkbox[id="useable"]').is(":checked")&&!$('input:checkbox[id="personalable"]').is(":checked")){
		alert("전체동의를 눌러주셔야 합니다.");
	}else{
		// 패스워드가 같으면
		if($("#pass_wd").val() == $("#repass_wd").val()){
			$("#joinForm").submit();
		}else{
			alert("패스워드가 동일하지 않습니다.");
		}
	}
}

// 아이디 찾기 
function findId(){
	var name = $("#name").val();
	var birth = $("#birth").val();
	var tel = $("#tel").val();
	
	// 유효성 체크
	if(name == "" || name.length == 0){
		alert("이름을 입력하세요");
		return;
	}else if(birth == "" || birth.length == 0){
		alert("생년월일을 입력하세요");
		return;
	}else if(tel == "" || tel.length == 0){
		alert("휴대폰 번호를 입력하세요");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "account.do?cmd=findId",
		dataType: "json",
		data : $("#findIdForm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			var user = data.user;
			if(data.result==false){
				alert("아이디를 찾을 수 없습니다.");
				return;
			}else{
				location.href ="/account/account.do?cmd=findSuccess&id="+user.id;
			}
			
		}
	});
}

//비밀번호 찾기 
function findPwd(){
	var id = $("#id").val();
	var email = $("#email").val();
	
	// 유효성 체크
	if(id == "" || id.length == 0){
		alert("이름을 입력하세요");
		return;
	}else if(email == "" || email.length == 0){
		alert("생년월일을 입력하세요");
		return;
	}
	
	// 발송중 문구
	$("#confirming").show();
	
	$.ajax({
		type: "POST",
		url: "account.do?cmd=findPwd",
		dataType: "json",
		data : $("#findPwdForm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			var email = data.email;
			if(data.result==false){
				alert("해당하는 아이디 또는 이메일이 존재하지 않습니다.");
				return;
			}else{
				if(data.send == true){
					$("#confirming").hide();
					$("#confirmed").show();
					alert("입력하신"+email+"로 이메일을 발송하였습니다.");
				}
			}
		}
	});
}


