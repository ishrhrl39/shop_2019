<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>타투 색상 관리</title>
	<script type="text/javascript" src="/js/admin/admin_tattoo_color.js"></script>
	<link rel="stylesheet" href="/css/admin/admin_tattoo_color.css">
</head>
<body>
	<div id="tattoist_list_layer" align="center">
		<form id="tattoo_color_frm" method="post">
			<table>
				<thead>
					<tr>
						<th><button type="button" id="deleteTattooColorBtn" class="btn btn-default">삭제</button></th>
						<th>색상</th>
						<th>-</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>-</td>
						<td><input type="text" name="color" id="color" maxlength="30" /></td>
						<td><button type="button" id="addTattooColorBtn" class="btn btn-success">등록</button></td>
					</tr>
					<c:forEach items="${tattooColorList }" var="tattooColor">
						<tr>
							<td><input type="checkbox" name="delete_seq" class="delete_seq" value="${tattooColor.SEQ}" /></td>
							<td>${tattooColor.COLOR}</td>
							<td>-</td>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>