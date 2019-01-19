<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>타투 담당자 관리</title>
	<script type="text/javascript" src="/js/admin/admin_tattooist.js"></script>
	<link rel="stylesheet" href="/css/admin/admin_tattooist.css">
</head>
<body>
	<div id="tattoist_list_layer" align="center">
		<form id="tattooist_frm" method="post">
			<table>
				<thead>
					<tr>
						<th><button type="button" id="deleteTatooistBtn" class="btn btn-default">삭제</button></th>
						<th>번호</th>
						<th>이름</th>
						<th>경력</th>
						<th>등록일자</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>-</td>
						<td>-</td>
						<td><input type="text" name="name" id="name" maxlength="30" /></td>
						<td><input type="text" name="career" id="career" maxlength="2" size="2" />년</td>
						<td><button type="button" id="addTatooistBtn" class="btn btn-success">등록</button></td>
					</tr>
					<c:forEach items="${tattooistList }" var="tattooist">
						<tr>
							<td><input type="checkbox" name="delete_seq" class="delete_seq" value="${tattooist.SEQ}" /></td>
							<td>${tattooist.SEQ}</td>
							<td><a href="#" data-toggle="modal" onclick="openModal('${tattooist.SEQ}')" data-target="#updateModal">${tattooist.NAME}</a></td>
							<td>${tattooist.CAREER}년</td>
							<td>${tattooist.REQ_DTM}</td>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	
	<!-- Modal -->
	<div id="updateModal" class="modal fade" role="dialog">
		<form id="tattooist_update_frm" method="post">
			<input type="hidden" name="seq" id="up_seq" />
			<div class="modal-dialog">
	
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">담당자 정보 수정</h4>
					</div>
					<div class="modal-body">
						<table class="table">
							<tr>
								<th>이름</th>
								<td><input type="text" name="name" id="up_name"  />
							</tr>
							<tr>
								<th>경력</th>
								<td><input type="text" name="career" id="up_career" maxlength="3" size="3"/>년</td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" id="updateTatooistBtn" data-dismiss="modal">수정하기</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>