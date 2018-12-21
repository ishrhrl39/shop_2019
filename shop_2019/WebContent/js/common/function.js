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

});