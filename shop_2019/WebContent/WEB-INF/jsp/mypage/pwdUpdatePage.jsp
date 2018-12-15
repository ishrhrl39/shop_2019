<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="/js/mypage/pwdUpdate.js"></script>
	</head>
	<body>
		<table>
			<tbody>
				<tr>
					<th>새 비밀번호  </th>
					<td><input type="password" id="newPwd" name="newPwd"></td>
				</tr>
				<tr>
					<th>새 비밀번호 확인  </th>
					<td><input type="password" id="reNewPwd" name="reNewPwd"></td>
				</tr>
			</tbody>
		</table>
		<div id="updateLayout">
			<button type="button" id="pwdUpdateBtn">비밀번호 수정</button>
		</div >
	</body>
</html>