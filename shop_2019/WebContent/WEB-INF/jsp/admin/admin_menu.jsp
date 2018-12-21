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
		<input type="hidden" id="subMenuCd" name="subMenuCd" />	
		<input type="hidden" id="orderNo" name="orderNo" />
		<input type="hidden" id="subOrderNo" name="subOrderNo" />
		
		<table>
			<tr>
				<!-- 그룹 메뉴 관리 -->
				<td>
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
						<tr style="border:1px solid #BDBDBD;">
							<td width="50%" valign="top">
								<input type="text" class="form-control" name="menuNm" id="menuNm"  maxlength="25" placeHolder="메뉴명을 입력하십시오." />
								<input type="text" class="form-control" name="link_url" id="link_url"  maxlength="100" placeHolder="URL을 입력하십시오." />
							</td>
							<td width="50%" valign="bottom">
								<button type="button" class="btn btn-default" id="insertMenuBtn" >등록</button>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<select size="20" id="menuList">
									<c:forEach items="${menu_list }" var="menu">
										<option value="${menu.menu_cd }" data-toggle="modal">${menu.menu_nm } (${menu.sub_menu_count})</option>
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
				</td>
				
				<!-- 그룹 메뉴 순서 -->
				<td valign="middle" align="center">
					<button type="button" class="moveItemBtn" disabled="disabled" id="moveTopBtn">▲</button><br/>
					<button type="button" class="moveItemBtn" disabled="disabled" id="moveBottomBtn">▼</button><br/>
					<button type="button" class="btn btn-warning" data-dismiss="modal" id="saveOrder" disabled="disabled">순서 저장</button>
				</td>
				
				<!-- 서브 메뉴 관리 -->
				<td valign="top" style="padding-left:100px;">
					<table class="form_select">
						<tr>
							<th colspan="2">
								서브 메뉴
							</th>
						</tr>
						<tr style="border:1px solid #BDBDBD;">
							<td width="50%" valign="top">
								<input type="text" class="form-control" name="subMenuNm" id="subMenuNm"  maxlength="25" placeHolder="메뉴명을 입력하십시오." />
								<input type="text" class="form-control" name="sub_link_url" id="sub_link_url"  maxlength="100" placeHolder="URL을 입력하십시오." />
							</td>
							<td width="50%" valign="bottom">
								<button type="button" class="btn btn-default" id="sub_insertMenuBtn" >등록</button>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<select size="20" id="sub_menuList">	
								</select>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td width="30%">
								<button type="button" class="btn btn-primary" id="sub_deleteMenuBtn" disabled="disabled">삭제</button>
							</td>
						</tr>
					</table>
				</td>
				
				<!-- 서브 메뉴 순서 -->
				<td valign="middle" align="center">
					<button type="button" class="moveSubItemBtn" disabled="disabled" id="sub_moveTopBtn">▲</button><br/>
					<button type="button" class="moveSubItemBtn" disabled="disabled" id="sub_moveBottomBtn">▼</button><br/>
					<button type="button" class="btn btn-warning" data-dismiss="modal" id="sub_saveOrder" disabled="disabled">순서 저장</button>
				</td>
			</tr>
		</table>
	</form>
	
	
	<!-- 그룹메뉴 수정 팝업 -->
	<div id="menuPopup" class="modal fade" role="dialog">
		<form action="#" id="menuUpdateFrm">
			<input type="hidden" id="popup_menuCd" name="popup_menuCd" />
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">그룹메뉴명 수정</h4>
					</div>
					<div class="modal-body">
						<table style="width:100%">
							<tr>
								<th>메뉴명</th>
								<td><input type="text" id="popup_menuNm" name="popup_menuNm" maxlength="25" class="form-control" /></td>
							</tr>
							<tr>
								<td colspan='2'>&nbsp;</td>
							</tr>
							<tr>
								<th>URL</th>
								<td><input type="text" id="popup_menuUrl" name="popup_menuUrl" maxlength="100" class="form-control" /></td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="updateMenuNmBtn">수정</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	
	<!-- 서브메뉴 수정 팝업 -->
	<div id="subMenuPopup" class="modal fade" role="dialog">
		<form action="#" id="subMenuUpdateFrm">
			<input type="hidden" id="popup_menuCd" name="popup_menuCd" />
			<input type="hidden" id="popup_subMenuCd" name="popup_subMenuCd" />
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">서브메뉴명 수정</h4>
					</div>
					<div class="modal-body">
						<table style="width:100%">
							<tr>
								<th>메뉴명</th>
								<td><input type="text" id="popup_subMenuNm" name="popup_subMenuNm" maxlength="25" class="form-control" /></td>
							</tr>
							<tr>
								<td colspan='2'>&nbsp;</td>
							</tr>
							<tr>
								<th>URL</th>
								<td><input type="text" id="popup_subMenuUrl" name="popup_subMenuUrl" maxlength="100" class="form-control" /></td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="updateSubMenuNmBtn">수정</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>