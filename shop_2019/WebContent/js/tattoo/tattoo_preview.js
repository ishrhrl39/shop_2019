$(document).ready(function(){
	loadPreview();
});


function loadPreview(){
	$("#preview_layout").html($(opener.document).find("#content").val());
}