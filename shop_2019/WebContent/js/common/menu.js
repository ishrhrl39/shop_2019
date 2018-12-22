$(document).ready(function(){
	setMenuEnabled();
});

function setMenuEnabled(){
	var loc = location.pathname;
	var fullUrl = location.href;
	if(fullUrl.indexOf("?") > -1){
		loc += "?" + fullUrl.substring(fullUrl.indexOf("?") + 1);
	}
	$("#leftMenu > li").each(function(){
		var a = $(this).children("a");
		if(a.attr("href") == loc){
			a.css("color", "#fff");
			a.css("font-weight", "bold");
		}
	});
}