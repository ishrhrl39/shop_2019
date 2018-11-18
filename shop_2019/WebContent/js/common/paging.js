/**
 * 원하는 페이지로 이동한다.
 * @param offset
 */
function goLocByPaging(page){
	var url = getDefaultUrl();
	location.href = (url.substring(0, url.indexOf("?"))) + "?page=" + page;
}

function getDefaultUrl(){
	return location.href.replace("#", "");
}