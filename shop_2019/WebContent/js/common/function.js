$(document).ready(function() {
	
	$.ajax({
		type: "POST",
		url: "/index.do?cmd=selectMenuList",
		dataType: "json",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			var html = "<li class='current-menu-item'><a href='/index.do'>Home</a></li>";
			$(data.menuList).each(function(index, menu){
				html += "<li class='parent'>";
				html += "<a href='" + menu.link_url + "'>" + menu.menu_nm + "</a>";
				$(menu.subMenuList).each(function(index2, subMenu){
					if(index2 == 0){
						html += "<ul class='sub-menu'>";
					}
					
					html += "<li><a href='" + subMenu.link_url + "'> " + subMenu.sub_menu_nm + "</a></li>";
					
					if(index2 == menu.subMenuList.length - 1){
						html += "</ul>";
					}
				});
				html += "</li>";
			});
			html += "<li class='current-menu-item'><a href='/faq.do'>FAQ</a></li>";
			$("#main-menu").html(html);
		}
	});	
	

	/* MAIN MENU */
	$('#main-menu > li:has(ul.sub-menu)').addClass('parent');
	$('ul.sub-menu > li:has(ul.sub-menu) > a').addClass('parent');

	$('#menu-toggle').click(function() {
		$('#main-menu').slideToggle(300);
		return false;
	});

	$(window).resize(function() {
		if ($(window).width() > 700) {
			$('#main-menu').removeAttr('style');
		}
	});

	$.datepicker.setDefaults({
	    dateFormat: 'yy-mm-dd',
	    prevText: '이전 달',
	    nextText: '다음 달',
	    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	    showMonthAfterYear: true,
	    yearSuffix: '년'
	});
	$("#datepicker1, #datepicker2").datepicker();
	
	var dt = new Date();
	var year = dt.getFullYear();
	var month = (dt.getMonth() + 1) + "";
	var date = dt.getDate() + "";
	
	if(month.length == 1){
		month = "0" + month;
	}
	if(date.length == 1){
		date = "0" + date;
	}
	var today = year + "-" + month + "-" + date;
	$(".datepicker").val(today);
	$('.datepicker').attr('style',"background-image:url('/images/common/date_icon.png');");
	
	
	var $fileBox = $('.filetype');

	$fileBox.each(function() {
	  var $fileUpload = $(this).find('.input-file'),
	    $fileText = $(this).find('.file-text')
	  $fileUpload.on('change', function() {
	    var fileName = $(this).val();
	    $fileText.attr('disabled', 'disabled').val(fileName);
	  })
	})
});
