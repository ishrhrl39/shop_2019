<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Ÿ�� ����� ����</title>
	<script type="text/javascript" src="/js/admin/admin_schedule.js"></script>
	<link rel="stylesheet" href="/css/admin/admin_tattooist.css">
</head>
<body>
	<div id="tattoist_list_layer" align="center">
		<form id="tattooist_frm" method="post" action="/admin/schedule.do">
			<table>
				<thead>
					<tr>
						<th colspan="5" align="right" style="text-align: right">
							<select name="searchKey">
								<option value="TATTOOIST_NAME">Ÿ���̽�Ʈ��</option>
								<option value="RESERVED_DT">��¥</option>
							</select>
							<input type="text" name="searchValue" />
							<button type="button" id="searchScheduleBtn" class="btn btn-success">�˻�</button>
							<button type="button" id="searchAllScheduleBtn" class="btn btn-success">��ü����</button>
						</th>
					</tr>
					<tr>
						<th><button type="button" id="deleteSchduleBtn" class="btn btn-default">����</button></th>
						<th>��¥/�ð�</th>
						<th>Ÿ���̽�Ʈ��</th>
						<th>�����ڸ�</th>
						<th>������ ����ó</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${scheduleList }" var="schedule">
						<tr>
							<td><input type="checkbox" name="delete_key" class="delete_key" value="${schedule.RESERVED_DATE},${schedule.RESERVED_HOUR},${schedule.TATTOO_NAME}" /></td>
							<td>${schedule.RESERVED_DATE} / ${schedule.RESERVED_HOUR}��</td>
							<td>${schedule.TATTOO_NAME}</td>
							<td>${schedule.NAME}</td>
							<td>${schedule.TEL}</td>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	
</body>
</html>