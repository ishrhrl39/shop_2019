<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="/js/mypage/myInfo.js"></script>
	</head>
	<body>
		<form id="myInfoForm"> 
			<input type="hidden" id="userId" value="${loginUser.id}"/>
			<table id="myTable">
				<tbody>
					<tr>
						<td id="user_id">
						</td>
					</tr>
					<tr>
						<td id="user_name">
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" id="user_email" name="user_email"  style="width:200px;"/>
						</td>
					</tr>
					<tr>
						<td id="user_birth">
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" id="user_tel" name="user_tel" style="width:200px;"/>
						</td>
					</tr>
				</tbody>
			</table>
			<div id="updateLayout">
				<button type="button" id="infoUpdateBtn">수정</button>
				<button type="button" id="pwdUpdateUrlBtn">비밀번호 수정</button>
			</div>
		</form>
	</body>
</html>