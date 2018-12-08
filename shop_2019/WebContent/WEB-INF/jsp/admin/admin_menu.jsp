<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/admin/menu.js"></script>
<link rel="stylesheet" href="/css/admin/menu.css">
<title></title>
</head>
<body>	
	<form action="#" id="menuFrm">
		<input type="hidden" id="menuCd" name="menuCd" />	
		<input type="hidden" id="orderNo" name="orderNo" />
		
		<table class="form_select">
			<tr>
				<th colspan="2">
					그룹 메뉴
				</th>
			</tr>
			<tr>
				<td colspan="2">
					<input type="text" class="form-control" name="search" id="search"  maxlength="25" placeHolder="메뉴를 검색하세요." />
				</td>
			</tr>
			<tr>
				<td width="70%">
					<input type="text" class="form-control" name="menuNm" id="menuNm"  maxlength="25" />
				</td>
				<td width="30%">
					<button type="button" class="btn btn-default" id="insertMenuBtn" >등록</button>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<select size="20" id="menuList">
						<c:forEach items="${menu_list }" var="menu">
							<option value="${menu.menu_cd }" data-toggle="modal">${menu.menu_nm }</option>
						</c:forEach>	
					</select>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td width="30%">
					<button type="button" class="btn btn-primary" id="deleteMenuBtn" disabled="disabled">삭제</button>
				</td>
			</tr>
		</table>
	</form>
	
	
	<!-- Modal -->
	<div id="menuPopup" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modal Header</h4>
				</div>
				<div class="modal-body">
					<p>Some text in the modal.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
</body>
</html>