<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/main.css">
		<link rel="stylesheet" href="/css/admin/main.css">
		<link rel="stylesheet" href="/css/common/paging.css">
		<link rel="stylesheet" href="/css/common/font-awesome.css">
		<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="/js/common/function.js"></script>
		<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
		
		
		<script src="/js/common/paging.js"></script>
		<script src="/js/common/menu.js"></script>
		
		<title><tiles:getAsString name="title"></tiles:getAsString></title>
	</head>
	<body>
		<table class="table">
			<tr>
				<td width="15%" bgcolor="#1f2120">
					<center><img src="/images/common/menu_icon.png"></center>
					<tiles:insertAttribute name="menu"></tiles:insertAttribute>
				</td>
				<td width="85%"><tiles:insertAttribute name="body"></tiles:insertAttribute></td>
			</tr>	
		</table>
	</body>
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	
</html>